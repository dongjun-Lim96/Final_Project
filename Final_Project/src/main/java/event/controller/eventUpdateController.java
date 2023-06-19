package event.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsDao;
import event.model.EventBean;
import event.model.EventDao;



@Controller
public class eventUpdateController {
   private final String command="updateEvent.ev"; 
   private final String getPage="eventUpdateForm";
   private final String backPage="redirect:/detailView.ev";
   private final String gotoPage="redirect:/list.ev";
   
   @Autowired
   EventDao edao;

   @Autowired
   ServletContext servletContext;
   
   @RequestMapping(value = command,method = RequestMethod.GET)
   public String doAction(@RequestParam("pageNumber") String pageNumber,
         @RequestParam("eventNumber") int eventNumber,
         Model model) {
      
	 
         EventBean event = edao.getOneEventByNum(eventNumber);
         System.out.println(eventNumber+" , "+ pageNumber);
         model.addAttribute("event", event);
         model.addAttribute("eventNumber", eventNumber);
         model.addAttribute("pageNumber",pageNumber);
         
         return getPage;
               
      }

   
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("eventBean")  EventBean eventBean,
			BindingResult result,
			@RequestParam("pageNumber") int pageNumber) {
		
		System.out.println("111111111111111111111111");
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		

			
		
	if(eventBean.getEventImage().equals("")) {
		eventBean.setEventImage(eventBean.getUpload2());
			
			int cnt = edao.updateEvent(eventBean);
			if(cnt != -1) {
	
				MultipartFile multi = eventBean.getUpload();  
				try {

				} catch (IllegalStateException e) {
					e.printStackTrace();
				}

			} // if cnt
			mav.setViewName(gotoPage); 
	
			

	
/*		if(result.hasErrors()) {
			// 수정실패했을때도 이미지 띄우려고 작성함.
			// 또는 위에 if문처럼 작성해도 됨!
			notice.setNoticeImage(notice.getUpload2());
			mav.setViewName(getPage);*/
		}else {
			//웹서버경로
			String uploadPath = servletContext.getRealPath("/resources");
			//업로드파일경로
			File destination = new File(uploadPath + "//" + eventBean.getUpload().getOriginalFilename());
			//삭제파일경로
			File delFile = new File(uploadPath + File.separator + eventBean.getUpload2());
			
			//수정작업
			int cnt = edao.updateEvent(eventBean);
			
			if(cnt != -1) {
				// DB 작업 완료 후 원래이미지 지우고, 새로운 이미지를 올려야한다.
				//파일객체 주입
				MultipartFile multi = eventBean.getUpload();  
				try {
					//파일업로드 작업
					multi.transferTo(destination);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 업로드 후 원래 파일 삭제
				delFile.delete();
			} // if cnt
			mav.setViewName(gotoPage);
		}
		
	
		return mav;
	}
}