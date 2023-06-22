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

import com.spring.ex.MyBean;

import course.model.CourseBean;
import course.model.CourseDao;
import courseorder.model.CourseOrderBean;
import wishList.model.WishListBean;
import wishList.model.WishListDao;

@Controller
public class CoursePaidController {
	private final String command="/paidCourse.cs";
	private final String getPage="CoursePaid";
	
	@Autowired 
	CourseDao courseDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam("userId") String userId) throws IOException {
		
		String uploadPath = servletContext.getRealPath("/resources/");
		System.out.println("uploadPath: " + uploadPath);
		File destination = new File(uploadPath);
		
		String str = "C:/tempUpload"; 
		File destination_local = new File(str); //폴더로 만듬
		
		FileUtils.copyDirectory(destination_local, destination); //폴더쨰 카피

		ModelAndView mav = new ModelAndView();
		List<CourseBean> paidCourseLists= courseDao.getPaidCourse();
		
		List<WishListBean> wishLists= courseDao.selectWishList(userId);
		
		List<CourseOrderBean> CourseIdLists = courseDao.selectCourseList(userId);
		
		mav.addObject("userId", userId);
		mav.addObject("wishLists", wishLists);
		mav.addObject("CourseIdLists", CourseIdLists);
		mav.addObject("paidCourseLists", paidCourseLists);
		mav.setViewName(getPage);
		return mav;
	}
}
