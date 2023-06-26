package data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.model.DataBean;
import data.model.DataDao;

import utility.Paging;


@Controller
public class dataListController {
	
	private final String command = "list.dt";
	private final String getPage= "dataList";
	
	@Autowired
	private DataDao ddao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam(value = "pageNumber",required = false) String pageNumber,
				@RequestParam(value = "whatColumn", required = false) String whatColumn,
				@RequestParam(value = "keyword",required = false) String keyword,
				Model model, HttpServletRequest request
			) {
		
		ModelAndView mav = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		System.out.println(keyword +whatColumn );
		
		int totalCount = ddao.getTotalCount(map);
		
		Paging pageInfo = new Paging(pageNumber, "5", totalCount, "list.nt", whatColumn, keyword, null);
		
		List<DataBean> dataLists = ddao.getAllData(pageInfo,map);
		
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("dataLists",dataLists);
		mav.setViewName(getPage);
		System.out.println("¿©±â´Â listView pageNumber"+pageNumber);
		return mav;
	} 
}
