package com.empresa.app.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.app.course.model.document.Course;
import com.empresa.app.course.model.service.ICourseService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/course")
public class CourseController {

	@Autowired
	private ICourseService service;

	@GetMapping("/list")
	public Flux<Course> listarCursos() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Mono<Course> findById(@PathVariable String id) {
		return service.findById(id);
	}

	@GetMapping("/listName/{name}")
	public Flux<Course> findByName(@PathVariable String name) {
		return service.findByName(name);
	}

	@GetMapping("/listCode/{code}")
	public Mono<Course> findByCode(@PathVariable String code) {
		return service.findByCode(code);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/create")
	public Mono<Course> create(@RequestBody Course course) {
		return service.save(course);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> deleteById(@PathVariable String id) {
		return service.deleteById(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/{id}")
	public Mono<ResponseEntity<Course>> update(@RequestBody Course course, @PathVariable String id) {
		return service.update(course, id);
	}

}
