package review.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import review.model.ReviewDao;

@Controller
public class ReviewDeleteController {
	private final String command = "/reviewDelete.rv";
	private String gotoPage = "redirect:/accountsLearning.acc";
	
	@Autowired
	ReviewDao rdao;
	
	@RequestMapping(value =  command)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,
								@RequestParam("userId") String userId) {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("courseCode", courseCode);
		map.put("userId", userId);
		
		rdao.deleteReview(map);
		
		mav.setViewName(gotoPage+"?courseCode="+courseCode+"&userId="+userId);
		
		return mav;
	}
}
