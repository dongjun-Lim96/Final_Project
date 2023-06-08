package category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import category.model.CategoryDao;

@Controller
public class CategoryController {
	
	private final String command="/category.cg";
	private final String getPage="categoryInsertForm";
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value=command , method = RequestMethod.GET)
	public String doAction() {
		
		return getPage;
	}
}
