package cart.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cart.model.CartBean;
import cart.model.CartDao;
import course.model.CourseBean;

@Controller
public class CartListController {
	private final String command = "/cartList.ct";
	private String getPage = "cartList";
	
	@Autowired
	CartDao cdao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId) {
		
		ModelAndView mav = new ModelAndView();
		
		List<CartBean> cartList = cdao.cartList(userId);
		
		mav.addObject("cartList", cartList);
		mav.addObject("userId", userId);
		
		mav.setViewName(getPage);
		
		return mav;
	}
}
