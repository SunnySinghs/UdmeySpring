package com.sourabh.springdemo.controller;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.RestController;

import com.sourabh.springdemo.service.StudentService;

@RestController
public class StudentController {

	@Lookup
	public StudentService getStudentService() {
		return null;
		
	}
}
