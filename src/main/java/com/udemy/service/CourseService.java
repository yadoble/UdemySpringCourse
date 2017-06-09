package com.udemy.service;

import java.util.List;

import com.udemy.entity.Course;
import com.udemy.model.CourseModel;

public interface CourseService {
	
	public abstract List<CourseModel> listAllCoursees();
	public abstract Course addCourse(Course course);
	public abstract int removeCourse(int id);
	public abstract Course updateCourse(Course course);
	public abstract int removeCourse(Course course);
	
}
