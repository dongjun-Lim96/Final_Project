package unit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import unit.model.UnitDao;

@Controller
public class UnitDeleteController {
	private final String command="deleteUnit.un";
	private final String getPage="redirect:/getUnit.un";
	
	@Autowired
	UnitDao unitDao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,
			@RequestParam("pageNumber") String pageNumber) {
		ModelAndView mav = new ModelAndView();
		System.out.println("courseCode : "+ courseCode);
		System.out.println("pageNumber : "+ pageNumber);
		
		int result = unitDao.deleteUnit(courseCode);
		System.out.println("result : " + result);
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
}
