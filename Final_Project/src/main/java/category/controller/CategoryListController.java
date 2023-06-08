package category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDao;

@Controller
public class CategoryListController {
	private final String command="/categoryList.cg";
	private final String getPage="categoryList";
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction() {
		ModelAndView mav = new ModelAndView();
		
		
		mav.setViewName(getPage);
		return mav;
	}
}
