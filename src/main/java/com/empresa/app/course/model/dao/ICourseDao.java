package com.empresa.app.course.model.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.empresa.app.course.model.document.Course;

public interface ICourseDao extends ReactiveMongoRepository<Course, String> {

}
