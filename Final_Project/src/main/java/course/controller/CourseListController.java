package course.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.ex.MyBean;

import course.model.CourseBean;
import course.model.CourseDao;
import utility.Paging;

@Controller 
public class CourseListController {
	
	private final String command="/getlist.cs";
	private final String getPage="CourseList";
	
	@Autowired
	CourseDao coursedao;
	 
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			HttpServletRequest request
			) {
		
		ModelAndView mav= new ModelAndView();
		MyBean mybean = new MyBean();
		try {
			mybean.afterPropertiesSet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		int totalCount = coursedao.getTotalCount(map);
		
		String url = request.getContextPath() + command;

		//∆‰¿Ã¬°
		Paging pageInfo = new Paging(pageNumber, "2", totalCount, url, whatColumn, keyword, null);

		
		List<CourseBean> courseLists= coursedao.getAllCourse(pageInfo,map);
		System.out.println("courseLists size : " + courseLists.size() );
		
		mav.addObject("pageInfo", pageInfo);
		mav.addObject("courseLists",courseLists);
		mav.setViewName(getPage);
		return mav;
	}
}
