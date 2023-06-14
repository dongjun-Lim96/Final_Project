package course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import course.model.CourseBean;
import course.model.CourseDao;

@Controller
public class CoursePaidDetailController {
	private final String command="coursePaidDetail.cs";
	private final String getPage="coursePaidDetail";
	
	@Autowired
	CourseDao courseDao; 
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode) {
		ModelAndView mav = new ModelAndView();
		CourseBean course = courseDao.getOneCourseByCode(courseCode);
		
		mav.addObject("course", course);
		
		return mav;
	}
} 
