package com.udemy.service;

import java.util.List;

import com.udemy.entity.Course;

public interface CourseService {
	
	public abstract List<Course> listAllCoursees();
	public abstract Course addCourse(Course course);
	public abstract int removeCourse(int id);
	public abstract Course updateCourse(Course course);
	
}
