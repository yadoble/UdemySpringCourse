package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.component.RequestTimeInterceptor;
import com.udemy.model.Person;
import com.udemy.service.impl.PrintLogImpl;

@Controller
@RequestMapping("/ejercicio")
public class EjercicioController {

	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "resultEjercicio";
	
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);
	
	@Autowired
	@Qualifier("printlog")
	PrintLogImpl printlog;
	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/ejercicio/");
	}
	
	/**
	 * @param model
	 * @return
	 */
	@GetMapping("/showform")
	public ModelAndView ShowForm(Model model) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", printlog.message());
		mav.setViewName(RESULT_VIEW);
		return mav;
	}

}
