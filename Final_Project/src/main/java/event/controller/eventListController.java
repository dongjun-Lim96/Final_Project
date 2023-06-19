package event.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import event.model.EventBean;
import event.model.EventDao;

import utility.Paging;
 

@Controller
public class eventListController {
   
   private final String command = "list.ev";
   private final String getPage= "eventList";
   
   @Autowired
   private EventDao edao;
   
   @RequestMapping(value = command, method = {RequestMethod.GET, RequestMethod.POST})
   public ModelAndView doAction(@RequestParam(value = "pageNumber",required = false) String pageNumber,
            @RequestParam(value = "whatColumn", required = false) String whatColumn,
            @RequestParam(value = "keyword",required = false) String keyword,
            @RequestParam(value = "expired", required = false) String expired,
            Model model, HttpServletRequest request
         ) {
	   if (expired==null) {
		   
	        expired = "0";
	    }

      ModelAndView mav = new ModelAndView();
      Map<String, String> map = new HashMap<String, String>();
      map.put("whatColumn", whatColumn);
      map.put("keyword", "%"+keyword+"%");
   
      System.out.println(keyword +whatColumn );
      
      int totalCount = edao.getTotalCount(map,expired);
      
      Paging pageInfo = new Paging(pageNumber, "6", totalCount, "list.ev", whatColumn, keyword, null);
      
      List<EventBean> eventLists = edao.getAllEvent(pageInfo,map,expired);
      
      mav.addObject("pageNumber",pageNumber);
      mav.addObject("pageInfo", pageInfo);
      mav.addObject("eventLists",eventLists);
      mav.addObject("selectedExpiredType", expired);
      mav.setViewName(getPage);
      System.out.println("¿©±â´Â listView pageNumber"+pageNumber);
      return mav;
   } 
   
 
}