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
	        redirectAttributes.addFlashAttribute("message", "���� �����Ϸ�");
	    } else if(cnt == -1 ){
	        redirectAttributes.addFlashAttribute("message", "���Ἲ ����");
	    } else {
	    	 redirectAttributes.addFlashAttribute("message", "���� ��������");
	    }
		return getPage;
	}
}
