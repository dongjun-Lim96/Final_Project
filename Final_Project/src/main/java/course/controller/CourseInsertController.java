package course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import course.model.CourseDao;

@Controller
public class CourseInsertController {   
	private final String command="/insert.cs";
	private final String getPage="CourseInsert"; 
	 
	@Autowired
	CourseDao coursedao;
	
	@RequestMapping(value = command)
	public String doAction() {
		
		return getPage;
	}
}
