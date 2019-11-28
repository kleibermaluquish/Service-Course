package com.empresa.app.course.model.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "course")
public class Course {

	@Id
	private String id;
	private String codeCourse;
	private String nameCourse;
	private List<Double> listNotes;
	private List<String> listStudents;
	private String nameTeacher;
	private String status;
	private int max;
	private int min;

	public Course() {
	}

	public Course(String codeCourse, String nameCourse, List<Double> listNotes, List<String> listStudents,
			String nameTeacher, String status, int max, int min) {
		super();
		this.codeCourse = codeCourse;
		this.nameCourse = nameCourse;
		this.listNotes = listNotes;
		this.listStudents = listStudents;
		this.nameTeacher = nameTeacher;
		this.status = status;
		this.max = max;
		this.min = min;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCodeCourse() {
		return codeCourse;
	}

	public void setCodeCourse(String codeCourse) {
		this.codeCourse = codeCourse;
	}

	public String getNameCourse() {
		return nameCourse;
	}

	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	public List<Double> getListNotes() {
		return listNotes;
	}

	public void setListNotes(List<Double> listNotes) {
		this.listNotes = listNotes;
	}

	public List<String> getListStudents() {
		return listStudents;
	}

	public void setListStudents(List<String> listStudents) {
		this.listStudents = listStudents;
	}

	public String getNameTeacher() {
		return nameTeacher;
	}

	public void setNameTeacher(String nameTeacher) {
		this.nameTeacher = nameTeacher;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

}
