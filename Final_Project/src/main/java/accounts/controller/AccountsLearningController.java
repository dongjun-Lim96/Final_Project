package accounts.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsDao;
import course.model.CourseBean;
import review.model.ReviewBean;
import unit.model.UnitBean;

@Controller
public class AccountsLearningController {
	private final String command="accountsLearning.acc";
	private final String getPage="accountsCourseLearning";
	
	@Autowired
	AccountsDao adao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,
								@RequestParam("userId") String userId) throws IOException {
		
		
		System.out.println("&8####888%%:  "+courseCode);
		System.out.println("&8####888%%:  "+userId);
		
		String uploadPath = servletContext.getRealPath("/resources/");
		System.out.println("uploadPath: " + uploadPath);
		File destination = new File(uploadPath);
		
		String str = "C:/tempUpload"; 
		File destination_local = new File(str); //폴더로 만듬
		
		FileUtils.copyDirectory(destination_local, destination); //폴더쨰 카피
		
		ModelAndView mav = new ModelAndView();
		System.out.println("여기는 CourseLearningController : "+ courseCode);
		CourseBean course = adao.getOneCourseByCode(courseCode);
		System.out.println("여기는 Course : "+ course.getCourseCode());
		List<ReviewBean> review= adao.getReviewBycourseCode(courseCode);
		List<UnitBean> unit = adao.getUnitBycourseCode(courseCode);
		
		
		mav.addObject("userId", userId);
		mav.addObject("course", course);
		mav.addObject("unit", unit);
		mav.addObject("review", review);
		
		mav.setViewName(getPage);
		return mav;
	}
}
