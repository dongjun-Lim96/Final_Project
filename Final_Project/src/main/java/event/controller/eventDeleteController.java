package event.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import event.model.EventBean;
import event.model.EventDao;


@Controller
public class eventDeleteController {

   private final String command="deleteEvent.ev";
   private final String getPage="redirect:/list.ev";
   private final String backPage="redirect:/detailView.ev";
   
   @Autowired
   EventDao edao;
   
   @Autowired
   ServletContext servletContext;
   
   @RequestMapping(value = command, method=RequestMethod.GET)
   public ModelAndView doAction(@RequestParam("pageNumber") String pageNumber,
         @RequestParam("eventNumber") int eventNumber
         ) {
      ModelAndView mav = new ModelAndView();
      
      
      
      EventBean eventBean = edao.getOneEventByNum(eventNumber);
      int cnt = edao.deleteOneEvent(eventNumber);
      
      mav.setViewName(getPage);
      if(cnt != -1) {
         System.out.println("삭제성공");
         String deletePath = servletContext.getRealPath("/resources");
         // 이미지 파일 경로
         File nImage = new File(deletePath + File.separator + eventBean.getEventImage());
         // 파일삭제
         boolean flag = nImage.delete();
         if(flag) {
            System.out.println("이미지 삭제 성공");
            
         }else {
            System.out.println("이미지 삭제 실패");
            mav.setViewName(backPage);
         }
      }
      else{
         System.out.println("삭제실패");
         mav.setViewName(backPage);
      }
      return mav; 
   }
}