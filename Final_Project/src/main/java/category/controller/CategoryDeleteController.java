package category.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryDao;

@Controller
public class CategoryDeleteController {
	private final String command="delete.cg";
	private final String getPage="redirect:/categoryList.cg";
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value = command)
	public ModelAndView doAction(@RequestParam("categoryCode") String categoryCode) {
		ModelAndView mav= new ModelAndView();
		
		System.out.println("categoryCodecategoryCode : " + categoryCode);
		int cnt = categoryDao.deleteCategory(categoryCode);
		
		if(cnt >0) {
			mav.addObject("message", "카테고리 삭제완료"); 
			mav.setViewName(getPage);
			return mav;
		}else {
			mav.addObject("message", "카테고리 삭제실패");
			mav.setViewName(getPage);
			return mav;
		}
		
	}
}
