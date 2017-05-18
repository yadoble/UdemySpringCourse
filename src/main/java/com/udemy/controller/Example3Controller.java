/**
 * 
 */
package com.udemy.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.model.Person;

/**
 * @author Jesus
 *
 */

/**
 * @author Jesus
 *
 */
@Controller
@RequestMapping("/example3")
public class Example3Controller {

	private static final Log LOG = LogFactory.getLog(Example3Controller.class);

	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";

	/*
	 * //#1
	 * 
	 * @GetMapping("/") public String redirect(){ return
	 * "redirect:/example3/showform"; }
	 */

	/**
	 * @return
	 */
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}

	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/showform")
	public String ShowForm(Model model) {
		model.addAttribute("person", new Person());
		return FORM_VIEW;
	}

	
	/**
	 * @param person
	 * @param bindingResult
	 * @return ModelAndView
	 */
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView(); 
		if(bindingResult.hasErrors()){
			mav.setViewName(FORM_VIEW);			
		}else{
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);			
		}
		return mav;
	}
}
