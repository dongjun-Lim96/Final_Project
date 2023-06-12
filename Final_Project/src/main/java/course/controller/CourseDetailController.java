package course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import course.model.CourseDao;

@Controller
public class CourseDetailController {
	private final String command="/courseDetail.cs";
	private final String getPage="courseDetail";
	
	@Autowired
	CourseDao courseDao; 
	
	@RequestMapping(value=command)
	public String doAction() {
		
		return getPage;
	}
}
