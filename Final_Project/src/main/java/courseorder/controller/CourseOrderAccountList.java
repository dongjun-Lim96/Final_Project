package courseorder.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsBean;
import courseorder.model.CourseOrderDao;
import utility.Paging;

@Controller
public class CourseOrderAccountList {
	private final String command="/courseAccountList.co";
	private final String getPage="CourseOrderAccountList";
	
	@Autowired
	CourseOrderDao courseOrderDao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		

		System.out.println("whatColumn : " + whatColumn);
		System.out.println("keyword :" + keyword);
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = courseOrderDao.getTotalCount(map);
		System.out.println("totalCount : " + totalCount);
		
		String url = request.getContextPath() + command;
		
		Paging pageInfo = new Paging(pageNumber, "5", totalCount, url, whatColumn, keyword, null);
		
		 
		List<AccountsBean> accountBuyList = courseOrderDao.getAccountBuyList(pageInfo,map);
		System.out.println("accountBuyList : "+ accountBuyList.size());
		for(AccountsBean x :accountBuyList) {
			System.out.println(x.getUserId());
			System.out.println(x.getCount());
		}
		
		System.out.println("asdfasdfasdf");
		mav.addObject("accountBuyList", accountBuyList);
		mav.addObject("pageInfo", pageInfo);
		mav.setViewName(getPage);
		return mav;
		
	}
	
}