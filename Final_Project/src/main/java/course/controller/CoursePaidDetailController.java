package course.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
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
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode) throws IOException {
		
		String uploadPath = servletContext.getRealPath("/resources/");
		System.out.println("uploadPath: " + uploadPath);
		File destination = new File(uploadPath);
		
		String str = "C:/tempUpload"; 
		File destination_local = new File(str); //폴더로 만듬
		
		FileUtils.copyDirectory(destination_local, destination); //폴더쨰 카피
		
		ModelAndView mav = new ModelAndView();
		System.out.println("여기는 CoursePaidDetailController : "+ courseCode);
		CourseBean course = courseDao.getOneCourseByCode(courseCode);
		List<ReviewBean> review= courseDao.getReviewBycourseCode(courseCode);
		mav.addObject("course", course);
		mav.addObject("review", review);
		
		mav.setViewName(getPage);
		return mav;
	}
} 
