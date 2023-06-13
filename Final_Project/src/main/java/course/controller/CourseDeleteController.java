package course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import course.model.CourseDao;

@Controller
public class CourseDeleteController {
	private final String command="deleteCourse.cs";
	private final String getPage="redirect:/getlist.cs";
	
	@Autowired
	CourseDao courseDao;
	
	@RequestMapping(value = command )
	public String doAction(@RequestParam("courseCode") String courseCode,
			RedirectAttributes redirectAttributes
			) {
		System.out.println("courseCode : " + courseCode);
		int cnt = courseDao.deleteOneCourse(courseCode);
		
	    if (cnt > 0) {
	        redirectAttributes.addFlashAttribute("message", "강의 삭제완료");
	    } else if(cnt == -1 ){
	        redirectAttributes.addFlashAttribute("message", "무결성 오류");
	    } else {
	    	 redirectAttributes.addFlashAttribute("message", "강의 삭제실패");
	    }
		return getPage;
	}
}
