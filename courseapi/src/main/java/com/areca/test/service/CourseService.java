package com.areca.test.service;

import com.areca.test.data.CourseRepository;
import com.areca.test.data.TopicRepository;
import com.areca.test.model.Course;
import com.areca.test.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicid){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicid)
                .forEach(courses::add);
        return courses;
    }

    public Course getCourse(String id){

        return courseRepository.findById(id).get();
    }

    public void addCourse(Course course){

        courseRepository.save(course);

    }

    public void updateCourse(Course course){
        courseRepository.save(course);

    }

    public void deleteCourse(String id){

        courseRepository.deleteById(id);

    }
}
