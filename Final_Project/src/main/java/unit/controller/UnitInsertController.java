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
		System.out.println("����� insertUnit �Դϴ�");
		ModelAndView mav = new ModelAndView();
		
		List<UnitBean> noUnit = unitDao.getNoUnitCourse();
		System.out.println("noUnit.size() : " + noUnit.size());
		
		mav.addObject("noUnit", noUnit);
		mav.setViewName(getPage);
		return mav;
	} 
	
	@RequestMapping(value = command,method=RequestMethod.POST)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,UnitBean unitBean) {
		System.out.println("����� insertUnit POST POST POST �Դϴ� : " + courseCode);
		ModelAndView mav = new ModelAndView();
		
		System.out.println(unitBean.getCourseCode());
		System.out.println(unitBean.getCousreName());
		 
		int result = unitDao.insertUnit(unitBean);
		if(result >0) {
			mav.addObject("message", "���� ��ϿϷ�");
			mav.setViewName(gotoPage);
			return mav;
		}else {
			mav.addObject("message", "���� ��Ͻ���");
			mav.setViewName(gotoPage);
			return mav;
		}

	}
}
