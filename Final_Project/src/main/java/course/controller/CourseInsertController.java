package course.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import category.model.CategoryBean;
import category.model.CategoryDao;
import course.model.CourseBean;
import course.model.CourseDao;

@Controller
public class CourseInsertController {   
	private final String command="/insertCourse.cs";
	private final String getPage="CourseInsert"; 
	private final String gotoPage="CourseList";
	@Autowired
	CourseDao coursedao;

	
	@Autowired
	ServletContext servletContext;
	
	
	@RequestMapping(value = command,method = RequestMethod.GET)
	public ModelAndView doAction() {
		ModelAndView mav = new ModelAndView();
		

		List<CategoryBean> lists = coursedao.getCategory();
		
		mav.addObject("lists", lists);
		
		
		mav.setViewName(getPage);
		return mav;

	}
	
	@RequestMapping(value = command,method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("courseBean") CourseBean courseBean) {
		String uploadPath = servletContext.getRealPath("/resources");
		System.out.println("uploadPath : " + uploadPath);
		ModelAndView mav= new ModelAndView();
		String str = "c:/tempUpload";
		
		File destination_img = new File(uploadPath+File.separator+courseBean.getUploadimg().getOriginalFilename());
		MultipartFile multi_img = courseBean.getUploadimg();		
		File destination_local_img = new File(str + File.separator + multi_img.getOriginalFilename());
		
		File destination_video = new File(uploadPath+File.separator+courseBean.getUploadvideo().getOriginalFilename());
		MultipartFile multi_video = courseBean.getUploadvideo();
		File destination_local_video = new File(str + File.separator + multi_video.getOriginalFilename());
		
		int cnt= coursedao.insertCourse(courseBean);
		if(cnt > -1) {
			
			try {
				multi_img.transferTo(destination_local_img);
				multi_video.transferTo(destination_local_video);
				
				FileCopyUtils.copy(destination_img, destination_local_img); // �쎒�꽌踰�=>濡쒖뺄
				FileCopyUtils.copy(destination_video, destination_local_video); // �쎒�꽌踰�=>濡쒖뺄
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		mav.setViewName(getPage);
		return mav;
		
	}
}