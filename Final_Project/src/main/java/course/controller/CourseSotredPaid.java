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

import category.model.CategoryBean;
import course.model.CourseBean;
import course.model.CourseDao;
import wishList.model.WishListBean;

@Controller
public class CourseSotredPaid {
	private final String command="/sortedPaidCourse.cs";
	private final String getPage="sortedPaidCourse";
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	ServletContext servletContext; 
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam("categoryCode") String categoryCode,
			@RequestParam("userId") String userId) throws IOException {
		ModelAndView mav = new ModelAndView();
		
		
		String uploadPath = servletContext.getRealPath("/resources/");
		System.out.println("uploadPath: " + uploadPath);
		File destination = new File(uploadPath);
		
		String str = "C:/tempUpload"; 
		File destination_local = new File(str); //폴더로 만듬
		
		FileUtils.copyDirectory(destination_local, destination); //폴더쨰 카피

		
		List<CourseBean> paidCourseLists= courseDao.getSotredPaidCourse(categoryCode);
		
		List<WishListBean> wishLists= courseDao.selectWishList(userId);
		
		mav.addObject("userId", userId);
		mav.addObject("wishLists", wishLists);
		mav.addObject("paidCourseLists", paidCourseLists);

		
		
		mav.setViewName(getPage);
		return mav;
	}
}
