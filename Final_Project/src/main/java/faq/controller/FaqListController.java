package faq.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import faq.model.FaqBean;
import faq.model.FaqDao;

@Controller
public class FaqListController {

   private final String command = "/list.faq";
   private final String getPage = "faqlist";
      
      @Autowired
      FaqDao faqDao;
      
      @RequestMapping(value=command)
      public ModelAndView doAction(HttpSession session) {
         ModelAndView mav = new ModelAndView();
         
         List<FaqBean> faqLists = faqDao.getFaq();
         session.setAttribute("sessionFaq", faqLists);
         mav.addObject("faqLists",faqLists);
         
         mav.setViewName(getPage);
         return mav;
   }

   
}