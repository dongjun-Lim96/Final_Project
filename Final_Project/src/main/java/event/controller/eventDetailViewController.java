package event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import event.model.EventBean;
import event.model.EventDao;


@Controller
public class eventDetailViewController {
   private final String command="detailView.ev";
   private final String getPage="eventDetailView";
   
   @Autowired
   EventDao edao;
   
   @RequestMapping(value = command)
   public String doAtcion(Model model,@RequestParam("eventNumber") int eventNumber, 
         @RequestParam("pageNumber") String pageNumber) {
      EventBean event= new EventBean();
      event = edao.getOneEventByNum(eventNumber);
      
      System.out.println("¿©±â´Â detailvie pageNumber"+pageNumber);
      model.addAttribute("pageNumber",pageNumber);
      model.addAttribute("event",event);
      return getPage;
   }
} 