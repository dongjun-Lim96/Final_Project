package accounts.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsBean;
import accounts.model.AccountsDao;
import course.model.CourseBean;

@Controller
public class AccountsWishListController {
	private final String command = "/wishlist.acc";
	private String getPage = "accountsWishList";
	
	@Autowired
	AccountsDao adao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId) throws IOException{
		
		System.out.println("유저 아이디*****:  "+userId);
		
		String uploadPath = servletContext.getRealPath("/resources/");
		System.out.println("uploadPath: " + uploadPath);
		File destination = new File(uploadPath);
		
		String str = "C:/tempUpload"; 
		File destination_local = new File(str); //폴더로 만듬
		
		FileUtils.copyDirectory(destination_local, destination); //폴더쨰 카피
		
		ModelAndView mav = new ModelAndView();
		
		List<CourseBean> wishList = adao.getWishList(userId);
		
		mav.addObject("userId", userId);
		mav.addObject("wishList", wishList);
		
		mav.setViewName(getPage);
		
		return mav;
	}
}
