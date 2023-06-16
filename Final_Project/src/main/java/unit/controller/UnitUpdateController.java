package unit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import unit.model.UnitBean;
import unit.model.UnitDao;

@Controller
public class UnitUpdateController {
	private final String command="/updateUnit.un";
	private final String getPage="unitUpdateFrom";
	private final String gotoPage="redirect:/unitDetail.un";
	
	@Autowired
	UnitDao unitDao;
	
	@RequestMapping(value = command , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,
			@RequestParam("pageNumber") String pageNumber) {
		ModelAndView mav = new ModelAndView();
		System.out.println("咯扁绰 updatecontroller GET GET GET");
		System.out.println("courseCode :" + courseCode);
		System.out.println("pageNumber :" + pageNumber);
		UnitBean unitBean = unitDao.getOneUnitByCode(courseCode);
		
		
		mav.addObject("unitBean", unitBean);
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(getPage);
		return mav;
		
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("unitBean") UnitBean unitBean,
			@RequestParam( value = "pagaeNumber",required = false) String pageNumber) {
		ModelAndView mav = new ModelAndView();
		System.out.println("咯扁绰 updatecontroller POST POST POST");
		
		int result = unitDao.updateUnit(unitBean);
		
		mav.addObject("courseCode", unitBean.getCourseCode());
		
			mav.addObject("pageNumber", pageNumber);
		
		mav.setViewName(gotoPage);
		System.out.println("POST POST POST 场场场场场场场场");
		return mav;
	}
	
}
