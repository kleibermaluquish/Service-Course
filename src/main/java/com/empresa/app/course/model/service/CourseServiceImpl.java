package com.empresa.app.course.model.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.empresa.app.course.model.dao.ICourseDao;
import com.empresa.app.course.model.document.Course;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private ICourseDao dao;

	@Override
	public Flux<Course> findAll() {

		return dao.findAll();
	}

	@Override
	public Mono<Course> findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Flux<Course> findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findAll().filter(c->c.getNameCourse().equals(name));
	}

	@Override
	public Mono<Course> save(Course course) {
		// TODO Auto-generated method stub
		return dao.save(course);
	}

	@Override
	public Mono<ResponseEntity<Course>> update(Course course, String id) {
		
		return dao.findById(id).flatMap(p -> {
			p.setCodeCourse(course.getCodeCourse());
			p.setNameCourse(course.getNameCourse());
			p.setListNotes(course.getListNotes());
			p.setListStudents(course.getListStudents());
			p.setNameTeacher(course.getNameTeacher());

			return dao.save(p);
		}).map(s->ResponseEntity.created(URI.create("/api/course/".concat(s.getId())))
				.contentType(MediaType.APPLICATION_JSON_UTF8).body(s))
		    		.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@Override
	public Mono<Course> findByCode(String code) {
		// TODO Auto-generated method stub
		return dao.findAll().filter(p->p.getCodeCourse().equals(code)).next();
	}

	@Override
	public Mono<Void> deleteById(String id) {
		// TODO Auto-generated method stub
		return dao.deleteById(id);
	}

}
