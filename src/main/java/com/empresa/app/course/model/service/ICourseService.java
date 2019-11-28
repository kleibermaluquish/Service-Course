package com.empresa.app.course.model.service;

import org.springframework.http.ResponseEntity;

import com.empresa.app.course.model.document.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICourseService {

	public Flux<Course> findAll();

	public Mono<Course> findById(String id);

	public Mono<Course> findByCode(String code);

	public Flux<Course> findByName(String name);

	public Mono<Course> save(Course course);

	public Mono<Void> deleteById(String id);

	public Mono<ResponseEntity<Course>> update(Course course, String id);

}
