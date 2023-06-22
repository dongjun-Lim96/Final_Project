package course.controller;

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

import course.model.CourseBean;
import course.model.CourseDao;
import courseorder.model.CourseOrderBean;
import review.model.ReviewBean;
import unit.model.UnitBean;
import wishList.model.WishListBean;

@Controller
public class CoursePaidDetailController {
	private final String command="coursePaidDetail.cs";
	private final String getPage="coursePaidDetail";
	
	@Autowired
	CourseDao courseDao; 
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,
								@RequestParam("userId") String userId) throws IOException {
		
		//System.out.println("&8####888%%:  "+courseCode);
		//System.out.println("&8####888%%:  "+userId);
		
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
		List<UnitBean> unit = courseDao.getUnitBycourseCode(courseCode);
		
		
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("courseCode", courseCode);
		map.put("userId", userId);
		
		WishListBean wishLists= courseDao.selectWishListDetail(map);
		//System.out.println("&8####888%%:  "+wishLists.getCourseCode());
		
		CourseBean CourseIdLists = courseDao.selectCourseListDetail(map);
		
		mav.addObject("userId", userId);
		mav.addObject("wishLists", wishLists);
		mav.addObject("CourseIdLists", CourseIdLists);
		mav.addObject("course", course);
		mav.addObject("unit", unit);
		mav.addObject("review", review);
		
		mav.setViewName(getPage);
		return mav;
	}
} 
