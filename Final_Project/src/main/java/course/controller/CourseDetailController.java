package course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import course.model.CourseBean;
import course.model.CourseDao;

@Controller
public class CourseDetailController {
	private final String command="/courseDetail.cs";
	private final String getPage="courseDetail";
	
	@Autowired
	CourseDao courseDao; 
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,
			@RequestParam("pageNumber") String pageNumber	
			) {
		ModelAndView mav = new ModelAndView();
		CourseBean course = courseDao.getOneCourseByCode(courseCode);
		
		mav.addObject("course", course);
		mav.addObject("pageNumber", pageNumber);
		return mav;
	}
} 
