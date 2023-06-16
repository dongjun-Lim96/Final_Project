package wishList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import wishList.model.WishListBean;
import wishList.model.WishListDao;

@Controller
public class WIshListAddController {
	private final String command = "/WLadd.wl";
	
		@Autowired
		WishListDao wdao;
		
		@ResponseBody
		@RequestMapping(command)
		public String doAction(@RequestParam("courseCode") String courseCode,
				@RequestParam("userId") String userId) {
			
			System.out.println("유저 아이디: "+userId);
			System.out.println("코스 코드: "+courseCode);
			
			WishListBean wb = new WishListBean();
			wb.setCourseCode(courseCode);
			wb.setUserId(userId);
			
			wdao.addWishList(wb);
			
			return "redirect:/paidCourse.cs";
		}
}
