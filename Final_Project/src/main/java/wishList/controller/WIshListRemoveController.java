package wishList.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import wishList.model.WishListDao;

@Controller
public class WIshListRemoveController {
	
	private final String command = "/WLremove.wl";
	
	@Autowired
	WishListDao wdao;
	
	@ResponseBody
	@RequestMapping(command)
	public String doAction(@RequestParam("courseCode") String courseCode) {
		
		System.out.println("코스 코드 : "+courseCode);
		
		wdao.deleteWishList(courseCode);
		
		return "redirect:/paidCourse.cs";
	}
}
