package course.controller;




import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import course.model.CourseBean;
import course.model.CourseDao;

@Controller
public class CourseUpdateController {
	private final String command="/updateCourse.cs";
	private final String getPage="CourseUpdate";

	@Autowired
	CourseDao courseDao;

	@Autowired
	ServletContext servletContext; 
 
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode) {
		ModelAndView mav = new ModelAndView();
		CourseBean course = courseDao.getOneCourseByCode(courseCode);

		mav.addObject("course",course);
		mav.setViewName(getPage);
		return mav;
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@RequestParam("courseCode") String courseCode,
			@ModelAttribute("courseBean") CourseBean courseBean
			) {
		ModelAndView mav= new ModelAndView();

		MultipartFile multi_img=null;
		MultipartFile multi_video=null;
		File destination_img;
		File destination_video;


		String uploadPath = servletContext.getRealPath("/resources");
		System.out.println("uploadPath : " + uploadPath);

		String str = "c:/tempUpload";


		System.out.println("getUploadimg : " +courseBean.getUploadimg().getOriginalFilename());
		//System.out.println("getCousreImg2 : " +courseBean.getCousreImg2());
		System.out.println("getUploadvideo : " +courseBean.getUploadvideo().getOriginalFilename());
		//System.out.println("getCousreVideo2 : " +courseBean.getCousreVideo2());


		CourseBean cb = courseDao.getOneCourseByCode(courseCode);
		if(courseBean.getUploadimg().getOriginalFilename() == null) { //비어있으면 기존것
			destination_img = new File(uploadPath+File.separator+cb.getUploadimg().getOriginalFilename());
			multi_img = cb.getUploadimg();		
			courseBean.setCousreImg(cb.getCousreImg());

		}else { //비어있지않으면 새로입력받은 값
			destination_img = new File(uploadPath+File.separator+courseBean.getUploadimg().getOriginalFilename());
			multi_img = courseBean.getUploadimg();		


		}
		File destination_local_img = new File(str + File.separator + multi_img.getOriginalFilename());

		if(courseBean.getUploadvideo().getOriginalFilename()==null) {
			destination_video = new File(uploadPath+File.separator+cb.getUploadvideo().getOriginalFilename());
			multi_video = cb.getUploadvideo();
			courseBean.setCousreVideo(cb.getCousreVideo());

		}else {
			destination_video = new File(uploadPath+File.separator+courseBean.getUploadvideo().getOriginalFilename());
			multi_video = courseBean.getUploadvideo();


		}
		File destination_local_video = new File(str + File.separator + multi_video.getOriginalFilename());

		int cnt = courseDao.UpdateCourse(courseBean);
		if(cnt > -1) {

			try {
				multi_img.transferTo(destination_local_img);
				multi_video.transferTo(destination_local_video);

				FileCopyUtils.copy(destination_img, destination_local_img); // 웹서버=>로컬
				FileCopyUtils.copy(destination_video, destination_local_video); // 웹서버=>로컬
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
