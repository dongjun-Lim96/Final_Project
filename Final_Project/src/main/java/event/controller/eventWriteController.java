package event.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsBean;
import event.model.EventBean;
import event.model.EventDao;
import notice.model.NoticeBean;
import notice.model.NoticeDao;

@Controller
public class eventWriteController {
   private final String command="write.ev";
   private final String getPage="eventWriteForm";
   private String gotoPage="redirect:/list.ev";



   @Autowired
   EventDao edao;
   @Autowired
   ServletContext servletContext;
   
   
   
   @RequestMapping(value = command, method=RequestMethod.GET)
   public String doAction() {

      return getPage;
   }
   @RequestMapping(value = command, method=RequestMethod.POST)
   public ModelAndView doAction(@ModelAttribute("eventBean") EventBean eventBean,
         BindingResult result, HttpServletRequest request,Model model, HttpSession session) {

	   String EndStr = request.getParameter("eventEnd");
	   String StartStr  = request.getParameter("eventStart");
       System.out.println("EndStr: " + EndStr);
       System.out.println("StartStr: " + StartStr);
       
       

       
      ModelAndView mav = new ModelAndView();
      // 이미지 파일을 저장할 위치(웹서버폴더)
      
      AccountsBean loginInfo = (AccountsBean) session.getAttribute("loginInfo");

      model.addAttribute("loginInfo", loginInfo);
      
      String uploadPath = servletContext.getRealPath("/resources");
      System.out.println("uploadPath : " + uploadPath);

      System.out.println("*:"+uploadPath+File.separator+eventBean.getUpload().getOriginalFilename());
      
      File destination = new File(uploadPath + File.separator + eventBean.getUpload().getOriginalFilename());

      System.out.println(destination);
      
      MultipartFile multi = eventBean.getUpload();
      // 아래 폴더 밑에 올릴 준비를 햇음!
      String str = "c:/tempUpload";
      File destination_local = new File(str + File.separator + multi.getOriginalFilename());

      System.out.println(destination);
      System.out.println("*1:"+destination_local);
      
      
      eventBean.setEventDate(new Timestamp(System.currentTimeMillis()));
      
      
      

      System.out.println("111111111111111111");
      System.out.println(eventBean.getEventStart()+","+eventBean.getEventEnd());
      int cnt = edao.writeEvent(eventBean);
      System.out.println("cnt"+cnt);
      if(cnt != -1) {
     
         try {
            multi.transferTo(destination); // destination : 웹서버폴더
            FileCopyUtils.copy(destination, destination_local); // 웹서버폴더의 값을 로컬로 옮김
         } catch (IllegalStateException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }

         mav.setViewName(gotoPage);
      }else {
         System.out.println("삽입 실패 : " + cnt);
         mav.setViewName(getPage);
      }
      
   return mav;
}
}
 