package unit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import unit.model.UnitBean;
import unit.model.UnitDao;

@Controller
public class UnitInsertController {
	private final String command="/insertUnit.un";
	private final String getPage="unitInsert";
	private final String gotoPage="redirect:/getUnit.un";
	
	@Autowired
	UnitDao unitDao;
	
	@RequestMapping(value = command,method=RequestMethod.GET)
	public ModelAndView doAction() {
		System.out.println("여기는 insertUnit 입니다");
		ModelAndView mav = new ModelAndView();
		
		List<UnitBean> noUnit = unitDao.getNoUnitCourse();
		System.out.println("noUnit.size() : " + noUnit.size());
		
		mav.addObject("noUnit", noUnit);
		mav.setViewName(getPage);
		return mav;
	} 
	
	@RequestMapping(value = command,method=RequestMethod.POST)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,UnitBean unitBean) {
		System.out.println("여기는 insertUnit POST POST POST 입니다 : " + courseCode);
		ModelAndView mav = new ModelAndView();
		
		System.out.println(unitBean.getCourseCode());
		System.out.println(unitBean.getCousreName());
		 
		int result = unitDao.insertUnit(unitBean);
		if(result >0) {
			mav.addObject("message", "목차 등록완료");
			mav.setViewName(gotoPage);
			return mav;
		}else {
			mav.addObject("message", "목차 등록실패");
			mav.setViewName(gotoPage);
			return mav;
		}

	}
}
