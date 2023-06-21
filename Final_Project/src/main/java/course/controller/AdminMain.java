package course.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import course.model.CourseDao;
import courseorder.model.CourseOrderBean;

@Controller
public class AdminMain {
   private final String command="adminmain.cs";
   private final String getPage="adminMian";
   
   @Autowired
   CourseDao courseDao;
   
   @RequestMapping(value = command)
   public ModelAndView doAction() {
      Date today = new Date();
      System.out.println("today :" + today);
      
      
      ModelAndView mav= new ModelAndView();
      LocalDate endDate = LocalDate.now().plusDays(1);
      LocalDate startDate = endDate.minusDays(6);

      java.sql.Date sqlEndDate = java.sql.Date.valueOf(endDate);
      java.sql.Date sqlStartDate = java.sql.Date.valueOf(startDate);
      
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      //System.out.println("오늘 날짜 :" +sqlEndDate);
      //System.out.println("7일전 날짜 :" + sqlStartDate);
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(sqlStartDate);
      

      Map<String,Object> param  = new HashMap<String,Object>();
      
      param .put("startDate", sqlStartDate);
      param .put("endDate", sqlEndDate);
      
      List<CourseOrderBean> weeklist = new ArrayList<CourseOrderBean>();
      weeklist = courseDao.getWeekOrder(param);
      System.out.println("weeklist size : "+ weeklist.size());
      
      /*
       * while (calendar.getTime().before(sqlEndDate) ||
       * calendar.getTime().equals(sqlEndDate)) { System.out.println("날짜: " +
       * dateFormat.format(calendar.getTime())); calendar.add(Calendar.DAY_OF_MONTH,
       * 1); }
       */
      

      
       boolean foundMatch;

       while (calendar.getTime().before(sqlEndDate) || calendar.getTime().equals(sqlEndDate)) {
           String currentDate = dateFormat.format(calendar.getTime());
           foundMatch = false;

           for (int i = 0; i < weeklist.size(); i++) {
               String orderDate = dateFormat.format(weeklist.get(i).getOrderDate());

               if (currentDate.equals(orderDate)) {
                  //System.out.println("weeklist.get(i).getOrderDate(): " + orderDate);
                   //System.out.println("weeklist.get(i).getTotalPrice(): " + weeklist.get(i).getTotalPrice());
                   foundMatch = true;
                   break;
               }
           }

           if (!foundMatch) {
              java.sql.Date sqlCurrentDate = java.sql.Date.valueOf(currentDate);
              CourseOrderBean cob = new CourseOrderBean();
              cob.setOrderDate(sqlCurrentDate);
              cob.setTotalPrice(0);
               //System.out.println("날짜: " + currentDate);
               //System.out.println("날짜2: " + sqlCurrentDate);
               //System.out.println("weeklist.get(i).getTotalPrice(): 0");
               weeklist.add(cob);
           }

           calendar.add(Calendar.DAY_OF_MONTH, 1);
       }
      
       Collections.sort(weeklist, new Comparator<CourseOrderBean>() {
           @Override
           public int compare(CourseOrderBean o1, CourseOrderBean o2) {
               return o1.getOrderDate().compareTo(o2.getOrderDate());
           }
       });
       System.out.println("weeklist.size(); : " + weeklist.size());
       
       

       List<CourseOrderBean> mergedList = new ArrayList<CourseOrderBean>();

       for (CourseOrderBean order : weeklist) {
           foundMatch = false;

           for (CourseOrderBean mergedOrder : mergedList) {
               if (mergedOrder.getOrderDate().equals(order.getOrderDate())) {
                   // 중복된 날짜를 찾았을 때 가격을 합산
                   mergedOrder.setTotalPrice(mergedOrder.getTotalPrice() + order.getTotalPrice());
                   foundMatch = true;
                   break;
               }
           }

           if (!foundMatch) {
               // 중복된 날짜가 없으면 새로운 객체로 추가
               CourseOrderBean mergedOrder = new CourseOrderBean();
               mergedOrder.setOrderDate(order.getOrderDate());
               mergedOrder.setTotalPrice(order.getTotalPrice());
               mergedList.add(mergedOrder);
           }
       }

       System.out.println("mergedList : " + mergedList.size());
       
       
      mav.addObject("weeklist",mergedList);
      
      mav.setViewName(getPage);
      return mav;
   }
}