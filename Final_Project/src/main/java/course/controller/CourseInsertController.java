package course.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryBean;
import category.model.CategoryDao;
import course.model.CourseBean;
import course.model.CourseDao;

@Controller
public class CourseInsertController {   
	private final String command="/insertCourse.cs";
	private final String getPage="CourseInsert"; 
	private final String gotoPage="CourseList";
	@Autowired
	CourseDao coursedao;
	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public ModelAndView doAction() {
		ModelAndView mav = new ModelAndView();
		
		
		
		
		mav.setViewName(getPage);
		return mav;

	}
	
	@RequestMapping(value = command,method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("courseBean") CourseBean courseBean) {
	    String courseCode = courseBean.getCourseCode();
	    String categoryCode = courseBean.getCategoryCode();
	    String cousreName = courseBean.getCousreName();
	    int cousrePrice = courseBean.getCousrePrice();
	    String cousreTeacher = courseBean.getCousreTeacher();
	     
	    System.out.println(courseCode);
	    System.out.println(categoryCode);
	    System.out.println(cousreName);
	    System.out.println(cousrePrice);
	    System.out.println(cousreTeacher);
		System.out.println("잘넘어옴미다");
		ModelAndView mav= new ModelAndView();

		mav.setViewName(gotoPage);
		return mav;
		
	}
}
