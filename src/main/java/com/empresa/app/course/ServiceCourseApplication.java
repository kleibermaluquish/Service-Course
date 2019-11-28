package com.empresa.app.course;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.empresa.app.course.model.dao.ICourseDao;
import com.empresa.app.course.model.document.Course;

import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceCourseApplication implements CommandLineRunner {

	@Autowired
	private ICourseDao dao;

	@Autowired
	private ReactiveMongoTemplate mongoTemplate;

	private static final Logger log = LoggerFactory.getLogger(ServiceCourseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceCourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		mongoTemplate.dropCollection("course").subscribe();

		Flux.just(
				new Course("COD1", "Curso 1", null, null, "Profesor 1", "Abierto", 30, 15),
				new Course("COD2", "Curso 2", null, null, "Profesor 2", "Cerrado", 30, 15),
				new Course("COD3", "Curso 3", null, null, "Profesor 3", "Abierto", 30, 15),
				new Course("COD4", "Curso 4", null, null, "Profesor 4", "Abierto", 30, 15)
				)
				.flatMap(c -> dao.save(c))
				.subscribe(c -> log.info("Code: " + c.getCodeCourse() + "Name: " + c.getNameCourse()));

	}

}
