package category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import category.model.CategoryBean;
import category.model.CategoryDao;

@Controller
public class CategoryDeleteController {
	private final String command="delete.cg";
	private final String getPage="redirect:/categoryList.cg";
	 
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value = command)
	public String doAction(@RequestParam("categoryCode") String categoryCode, RedirectAttributes redirectAttributes,HttpSession session) {
	    System.out.println("categoryCodecategoryCode : " + categoryCode);
	    int cnt = categoryDao.deleteCategory(categoryCode);
	    
	    if (cnt > 0) {
			List<CategoryBean> categoryLists = categoryDao.getCategory();
			session.setAttribute("catelists", categoryLists);
	        redirectAttributes.addFlashAttribute("message", "카테고리 삭제완료");
	    } else {
	        redirectAttributes.addFlashAttribute("message", "카테고리 삭제실패");
	    }
	     
	    return getPage;
	}
}
