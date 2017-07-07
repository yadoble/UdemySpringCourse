package com.udemy.controller;

import com.udemy.converter.CourseConverter;
import com.udemy.model.CourseModel;
import com.udemy.service.CourseService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static final String COURSES_VIEW ="courses";
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses(){
		LOG.info("Call: " + "listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new CourseModel());
		mav.addObject("courses", courseService.listAllCoursees());
		return mav;
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("courseModel") CourseModel courseModel){
		LOG.info("Call: " + "addCourse()" + "-- Param: " + courseModel.toString());
		courseService.addCourse((new CourseConverter()).model2Entity(courseModel));
		return "redirect:/courses/listcourses";
	}
	
	@PostMapping("/removecourse")
	public String removeCourse(@ModelAttribute("courseModel") CourseModel courseModel ){
		LOG.info("Call: " + "removeCourse()" + "-- Param: " + courseModel.toString());
		courseService.removeCourse((new CourseConverter().model2Entity(courseModel)));
		return "redirect:/courses/listcourses";
	}
	
}
