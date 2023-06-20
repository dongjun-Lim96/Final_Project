package cart.controller;

import java.util.ArrayList;
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
import courseorder.model.CourseOrderBean;
import courseorder.model.CourseOrderDao;

@Controller
public class Payment {
	private final String command = "/payment.ct";
	private String getPage = "payment";
	
	@Autowired
	CartDao cdao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId) {
		
		ModelAndView mav = new ModelAndView();
		
		List<CartBean> cartList = cdao.cartList(userId);
		mav.addObject("cartList", cartList);
		mav.addObject("userId", userId);
		
		List<CourseOrderBean> coList = new ArrayList<CourseOrderBean>();
		
		for (int i = 0; i < cartList.size(); i++) {
			CourseOrderBean coBean = new CourseOrderBean();
			
			coBean.setCourseCode(cartList.get(i).getCourseCode());
		    coBean.setUserId(cartList.get(i).getUserId());
		    coBean.setTotalPrice(cartList.get(i).getCousrePrice());
		    
		    cdao.insertOrder(coBean);
		}
		
		cdao.endCart();
		
		
		mav.setViewName(getPage);
		
		return mav;
	}

}
