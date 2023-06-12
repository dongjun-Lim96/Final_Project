package course.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import category.model.CategoryDao;
import course.model.CourseDao;

@Controller
public class CourseCheckController {
	private final String command = "/CourseCheck.cs";
	
	@Autowired
	CourseDao courseDao; 
	
	@ResponseBody
	@RequestMapping(command)
	public String doAction(HttpServletResponse response ,
			@RequestParam("courseCode") String courseCode) {
		
		System.out.println("courseCode : " + courseCode);
		boolean result = courseDao.searchCode(courseCode);
		System.out.println("result : " + result);
		if (result) { 
			return "NO";
		}else {
			return "YES";
		}
		
		
	}
}
