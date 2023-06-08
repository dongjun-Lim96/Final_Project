package category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import category.model.CategoryDao;

@Controller
public class CategoryListController {
	private final String command="/categoryList.cg";
	private final String getPage="categoryList";
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value=command)
	public String doAction() {
		
		return getPage;
	}
}
