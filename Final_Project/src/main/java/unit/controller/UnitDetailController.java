package unit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import unit.model.UnitBean;
import unit.model.UnitDao;

@Controller
public class UnitDetailController {
	private final String command="unitDetail.un";
	private final String getPage="unitDetail";
	
	@Autowired 
	UnitDao unitDao; 
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,
				@RequestParam(value ="pageNumber",required = false) String pageNumber,
				 RedirectAttributes redirectAttributes
			) {
		
		System.out.println("여기는 디테일 컨트롤러 : "+ courseCode);
		ModelAndView mav = new ModelAndView();
		
		UnitBean unitBean = unitDao.getOneUnitByCode(courseCode);
		System.out.println("1 :" + unitBean.getCourseCode());
		System.out.println("2 :" + unitBean.getCousreName());
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("unitBean", unitBean); 
		mav.setViewName(getPage);
		return mav;
		
	}
}
