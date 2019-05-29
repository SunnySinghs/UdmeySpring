package com.sourabh.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	
	public void initialize(CourseCode courseCode) {
		this.coursePrefix = courseCode.value();
	}
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		
		boolean result = true;
		
		if(theCode!=null) {
			result = theCode.startsWith(coursePrefix);
		}
		
		return result;
	}

}
