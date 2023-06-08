package category.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import category.model.CategoryDao;

@Controller
public class CategoryCheckController {
	private final String command = "/CategoryDao.cg";
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(command)
	public String doAction(HttpServletResponse response ,
			@RequestParam("categoryCode") String categoryCode) {
		System.out.println("categoryCode : " + categoryCode);
		boolean result = categoryDao.searchCode(categoryCode);
		System.out.println("result : " + result);
		if (result) { 
			return "NO";
		}else {
			return "YES";
		}
		
	}
}
