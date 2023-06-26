package courseorder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import courseorder.model.CourseOrderBean;
import courseorder.model.CourseOrderDao;
import utility.Paging;

@Controller
public class CourseOrderListController {
	private final String command="/courseOrderList.co";
	private final String getPage="CourseorderListAdmin";
	
	@Autowired
	CourseOrderDao courseOrderDao;
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam(value = "pageNumber", required = false) String pageNumber,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "whatColumn", required = false) String whatColumn,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		Map<String,String> map = new HashMap<String,String>();
		System.out.println("whatColumn : " + whatColumn);
		System.out.println("keyword : " + keyword);
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = courseOrderDao.getTotalOrderCount(map);
		
		String url = request.getContextPath() + command;
		
		Paging pageInfo = new Paging(pageNumber, "20", totalCount, url, whatColumn, keyword, null);
		
		List<CourseOrderBean> courseOrderList = courseOrderDao.getOrderList(pageInfo,map);
		
		mav.addObject("courseOrderList", courseOrderList);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;
		 
	}

}
