package com.areca.test.controller;

import com.areca.test.model.Course;
import com.areca.test.model.Topic;
import com.areca.test.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicid}/courses/{id}")
    public Course getCourse(@PathVariable(name = "id", required=true) String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics/{topicid}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicid){
        course.setTopic(new Topic(topicid, "",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{topicid}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicid){
        course.setTopic(new Topic(topicid, "",""));
        courseService.updateCourse(course);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{topicid}/courses/{id}")
    public void deleteCourse(@PathVariable(name = "id", required=true) String id){
        courseService.deleteCourse(id);
    }

}
