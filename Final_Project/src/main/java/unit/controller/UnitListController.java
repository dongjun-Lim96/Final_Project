package unit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import unit.model.UnitBean;
import unit.model.UnitDao;
import utility.Paging;

@Controller
public class UnitListController {
	
	private final String command="/getUnit.un";
	private final String getPage="unitList";
	
	@Autowired
	UnitDao unitDao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		int totalCount = unitDao.getTotalCount(map);
		
		String url = request.getContextPath() + command;
		//∆‰¿Ã¬°
		Paging pageInfo = new Paging(pageNumber, "5", totalCount, url, whatColumn, keyword, null);
		
		
		
		List<UnitBean> unitList =unitDao.getUnitList(pageInfo,map);
		System.out.println("unitList.size() : " + unitList.size());
		mav.addObject("unitList", unitList);
		mav.setViewName(getPage);
		return mav;
	} 
}
