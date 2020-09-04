package com.areca.test.data;

import com.areca.test.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {

    public List<Course> findByName(String name);
    public List<Course> findByDescription(String description);

    public List<Course> findByTopicId(String topicid);
}
