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
			// ���������������� �̹��� ������ �ۼ���.
			// �Ǵ� ���� if��ó�� �ۼ��ص� ��!
			notice.setNoticeImage(notice.getUpload2());
			mav.setViewName(getPage);*/
		}else {
			//���������
			String uploadPath = servletContext.getRealPath("/resources");
			//���ε����ϰ��
			File destination = new File(uploadPath + "//" + eventBean.getUpload().getOriginalFilename());
			//�������ϰ��
			File delFile = new File(uploadPath + File.separator + eventBean.getUpload2());
			
			//�����۾�
			int cnt = edao.updateEvent(eventBean);
			
			if(cnt != -1) {
				// DB �۾� �Ϸ� �� �����̹��� �����, ���ο� �̹����� �÷����Ѵ�.
				//���ϰ�ü ����
				MultipartFile multi = eventBean.getUpload();  
				try {
					//���Ͼ��ε� �۾�
					multi.transferTo(destination);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				// ���ε� �� ���� ���� ����
				delFile.delete();
			} // if cnt
			mav.setViewName(gotoPage);
		}
		
	
		return mav;
	}
}