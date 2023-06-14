package course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import course.model.CourseBean;
import course.model.CourseDao;
import review.model.ReviewBean;

@Controller
public class CoursePaidDetailController {
	private final String command="coursePaidDetail.cs";
	private final String getPage="coursePaidDetail";
	
	@Autowired
	CourseDao courseDao; 
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode) {
		ModelAndView mav = new ModelAndView();
		System.out.println("¿©±â´Â CoursePaidDetailController : "+ courseCode);
		CourseBean course = courseDao.getOneCourseByCode(courseCode);
		List<ReviewBean> review= courseDao.getReviewBycourseCode(courseCode);
		mav.addObject("course", course);
		mav.addObject("review", review);
		
		mav.setViewName(getPage);
		return mav;
	}
} 
