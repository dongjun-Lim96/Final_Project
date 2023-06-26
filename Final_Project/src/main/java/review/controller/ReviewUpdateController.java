package review.controller;

import java.util.HashMap;
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
public class ReviewUpdateController {
	private final String command = "/reviewUpdate.rv";
	private String getPage = "reviewUpdate";
	private String gotoPage = "redirect:/accountsLearning.acc";
	
	@Autowired
	ReviewDao rdao;
	
	@RequestMapping(value =  command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,
								@RequestParam("userId") String userId) {
		
		
		ModelAndView mav = new ModelAndView();
		
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("courseCode", courseCode);
		map.put("userId", userId);
		
		ReviewBean review = rdao.getUserReview(map);
		
		mav.addObject("review", review);
		mav.addObject("courseCode", courseCode);
		mav.addObject("userId", userId);
		mav.setViewName(getPage);
		
		return mav;
	}
	
	@RequestMapping(value =  command , method = RequestMethod.POST)
	public ModelAndView doAction(ReviewBean rb) {
		
		ModelAndView mav = new ModelAndView();
		
		rdao.updateReview(rb);
		
		mav.setViewName(gotoPage+"?courseCode="+rb.getCourseCode()+"&userId="+rb.getUserId());
		
		return mav;
	}
}
