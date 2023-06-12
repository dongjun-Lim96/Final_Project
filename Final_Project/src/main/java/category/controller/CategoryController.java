package category.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryBean;
import category.model.CategoryDao;

@Controller
public class CategoryController { 
	
	private final String command="/category.cg";
	private final String getPage="categoryInsertForm";
	private final String gotoPage="redirect:/categoryList.jsp";
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value=command , method = RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
	@RequestMapping(value=command , method = RequestMethod.POST)
	public ModelAndView  doAction(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String categoryCode = request.getParameter("categoryCode");
		String categoryName = request.getParameter("categoryName");
		CategoryBean cb = new CategoryBean(categoryCode,categoryName);
		System.out.println("POSTPOSTPOST : "+categoryCode+" , " + categoryName);
		int cnt = categoryDao.insertCategory(cb);
		if(cnt >0) {
			mav.addObject("message", "카테고리 등록완료");
			mav.setViewName(getPage);
			return mav;
		}else {
			mav.addObject("message", "카테고리 등록실패");
			mav.setViewName(getPage);
			return mav;
		}
		
	}
	
}
