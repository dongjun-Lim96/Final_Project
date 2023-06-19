package cart.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cart.model.CartBean;
import cart.model.CartDao;

@Controller
public class CartDeleteController {
	private final String command = "/cartDelete.ct";
	private String getPage = "redirect:/cartList.ct";
	
	@Autowired
	CartDao cdao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId,
								@RequestParam("cartNumber") int[] cartNumber) {
		
		ModelAndView mav = new ModelAndView();
		
		cdao.cartDelete(cartNumber);
		
		mav.addObject("userId", userId);
		mav.setViewName(getPage);
		
		return mav;
	}
}
