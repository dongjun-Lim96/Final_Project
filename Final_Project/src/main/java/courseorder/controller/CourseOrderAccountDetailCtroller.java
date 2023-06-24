package courseorder.controller;

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
import courseorder.model.CourseOrderBean;
import courseorder.model.CourseOrderDao;

@Controller
public class CourseOrderAccountDetailCtroller {
	private final String command="/accountDetail.co";
	private final String getPage="userAccountDetail";
	
	@Autowired 
	CourseOrderDao courseOrderDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam("userId") String userId,
			@RequestParam(value = "pageNumber" ,required = false) String pageNumber
			) throws IOException {
		ModelAndView mav = new ModelAndView();
		  
		
		String uploadPath = servletContext.getRealPath("/resources/");
		System.out.println("uploadPath: " + uploadPath);
		File destination = new File(uploadPath);
		
		String str = "C:/tempUpload"; 
		File destination_local = new File(str); //폴더로 만듬
		
		FileUtils.copyDirectory(destination_local, destination); //폴더쨰 카피
		
		   
		List<CourseBean> progressCousre = courseOrderDao.getProgressById(userId);
		List<CourseBean> finishedCousre = courseOrderDao.getFinishedById(userId);
		 
		mav.addObject("userId",userId);
		mav.addObject("progressCousre", progressCousre);
		mav.addObject("finishedCousre", finishedCousre);
		mav.setViewName(getPage);
		return mav;
	}
}
