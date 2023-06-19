package cart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cart.model.CartBean;
import cart.model.CartDao;

@Controller
public class CartAddController {
	private final String command = "/cartAdd.ct";
	private String getPage = "redirect:/cartList.ct";
	
	@Autowired
	CartDao cdao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId,
								@RequestParam("courseCode") String courseCode,
								HttpServletResponse response) {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		
		ModelAndView mav = new ModelAndView();
		
		CartBean cart = new CartBean();
		cart.setCourseCode(courseCode);
		cart.setUserId(userId);
		
		boolean flag = cdao.cartCheck(courseCode);
		
		if (!flag) {
			cdao.cartAdd(cart);
			
			mav.addObject("userId", userId);
			
			mav.setViewName(getPage);
		}else {
			try {
				out = response.getWriter();
				out.println("<script>alert('이미 장바구니에 있습니다.');history.go(-1);</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return mav;
	}
}
