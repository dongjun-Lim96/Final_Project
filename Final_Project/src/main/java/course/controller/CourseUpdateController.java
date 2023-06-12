package course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import course.model.CourseBean;
import course.model.CourseDao;

@Controller
public class CourseUpdateController {
	private final String command="/updateCourse.cs";
	private final String getPage="CourseUpdate";
	
	@Autowired
	CourseDao courseDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode) {
		ModelAndView mav = new ModelAndView();
		CourseBean course = courseDao.getOneCourseByCode(courseCode);
		
		mav.addObject("course",course);
		mav.setViewName(getPage);
		return mav;
	}
}
