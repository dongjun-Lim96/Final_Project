package category.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryBean;
import category.model.CategoryDao;


@Controller 
public class CategoryListController {
	private final String command="/categoryList.cg";
	private final String getPage="categoryList";
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		List<CategoryBean> categoryLists = categoryDao.getCategory();
		session.setAttribute("sessionCategory", categoryLists);
		mav.addObject("categoryLists",categoryLists);
		
		mav.setViewName(getPage);
		return mav;
	}
}
