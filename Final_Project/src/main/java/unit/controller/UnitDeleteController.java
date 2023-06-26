package unit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import category.model.CategoryBean;
import unit.model.UnitDao;

@Controller
public class UnitDeleteController {
	private final String command="deleteUnit.un";
	private final String getPage="redirect:/getUnit.un";
	
	@Autowired
	UnitDao unitDao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,
			@RequestParam("pageNumber") String pageNumber,
			RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();
		System.out.println("courseCode : "+ courseCode);
		System.out.println("pageNumber : "+ pageNumber);
		
		int result = unitDao.deleteUnit(courseCode);
	    if (result > 0) {
	        redirectAttributes.addFlashAttribute("message", "목차 삭제완료");
	    } else {
	        redirectAttributes.addFlashAttribute("message", "목차 삭제실패");
	    }
		System.out.println("result : " + result);
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
}
