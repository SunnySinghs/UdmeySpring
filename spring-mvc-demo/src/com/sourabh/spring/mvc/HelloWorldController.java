package com.sourabh.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-from";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		String studentName = request.getParameter("studentName");
		studentName = studentName.toUpperCase();
		studentName = "Yo! "+studentName;
		model.addAttribute("message", studentName);
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String studentName, Model model) {
		
		studentName = studentName.toUpperCase();
		studentName = "Yo! "+studentName;
		model.addAttribute("message", studentName);
		return "helloworld";
	}
	
}
