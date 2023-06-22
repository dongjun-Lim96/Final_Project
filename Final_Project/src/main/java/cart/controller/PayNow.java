package cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cart.model.CartBean;
import cart.model.CartDao;
import course.model.CourseBean;
import course.model.CourseDao;
import courseorder.model.CourseOrderBean;

@Controller
public class PayNow {
	private final String command = "/paynow.ct";
	private String getPage = "payment";
	
	@Autowired
	CartDao cdao;

	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId,
								@RequestParam("courseCode") String courseCode,
								HttpServletResponse response) {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		
		ModelAndView mav = new ModelAndView();
		
		boolean flag = cdao.cartCheck(courseCode);
		
		
		CartBean cart = new CartBean();
		cart.setCourseCode(courseCode);
		cart.setUserId(userId);
		
		if (!flag) {
			cdao.cartAdd(cart);
			
			List<CartBean> cartList = cdao.cartList(userId);
			mav.addObject("cartList", cartList);
			mav.addObject("userId", userId);

			
			for (int i = 0; i < cartList.size(); i++) {
				CourseOrderBean coBean = new CourseOrderBean();

				coBean.setCourseCode(cartList.get(i).getCourseCode());
			    coBean.setUserId(cartList.get(i).getUserId());
			    coBean.setTotalPrice(cartList.get(i).getCousrePrice());

			    cdao.insertOrder(coBean);
			}

			cdao.endCart();
			
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
