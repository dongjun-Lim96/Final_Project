package review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import review.model.ReviewBean;
import review.model.ReviewDao;

@Controller
public class ReviewListController {
	private final String command = "/reviewList.rv";
	private String getPage = "reviewList";
	private String gotoPage = "redirect:/accountsLearning.acc";
	
	@Autowired
	ReviewDao rdao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("userId") String userId) {
		
		
		ModelAndView mav = new ModelAndView();
		
		List<ReviewBean> lists = rdao.getUserList(userId);
		
		mav.addObject("lists", lists);
		mav.addObject("userId", userId);
		mav.setViewName(getPage);
		
		return mav;
	}
}
