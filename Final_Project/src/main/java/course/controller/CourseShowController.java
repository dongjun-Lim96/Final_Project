package course.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import course.model.CourseBean;
import course.model.CourseDao;  

@Controller
public class CourseShowController {

   private final String command="/goshow.cs";
   private String getPage = "courseShow";
   

   @Autowired
   CourseDao courseDao;
   
   @RequestMapping(value=command , method = RequestMethod.GET)
   public ModelAndView  doAction(@RequestParam(value="courseCode", required=false) String courseCode,
                           HttpServletRequest request) {
      ModelAndView mav = new ModelAndView();
      
      CourseBean cb = courseDao.getOneCourseByName(courseCode);
      
      mav.addObject("list", cb);
      
      mav.setViewName(getPage);
      return mav;
   }
   
}