package course.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import accounts.model.AccountsBean;
import accounts.model.AccountsDao;
import course.model.CourseDao;
import courseorder.model.CourseOrderBean;

@Controller
public class AdminMain {
   private final String command="/adminmain.cs";
   private final String getPage="adminMian";
   
   @Autowired
   CourseDao courseDao;
   
   
   @RequestMapping(value = command)
   public ModelAndView doAction() {
      Date today = new Date();
      System.out.println("today :" + today);
      
      
      ModelAndView mav= new ModelAndView();
      LocalDate endDate = LocalDate.now().plusDays(1);
      LocalDate startDate = endDate.minusDays(7);

      java.sql.Date sqlEndDate = java.sql.Date.valueOf(endDate);
      java.sql.Date sqlStartDate = java.sql.Date.valueOf(startDate);
      
      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      System.out.println("위 오늘 날짜 :" +sqlEndDate);
      System.out.println("위 7일전 날짜 :" + sqlStartDate);
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
       
      
      
      
      AccountsDao accountsDao = new AccountsDao();
      List<AccountsBean> countAccount = courseDao.getCountAccount();
      System.out.println("countAccount :" +countAccount.size());

      
      
      

      LocalDate currentDate = LocalDate.now().plusDays(0);
      LocalDate sevenDaysAgo = currentDate.minusDays(6);

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

      String accounttoday = currentDate.format(formatter);
      String sevenDaysAgoString = sevenDaysAgo.format(formatter);

      System.out.println("accounttoday 오늘 날짜: " + accounttoday);
      System.out.println("7일 전 날짜: " + sevenDaysAgoString);

      Set<String> existingDates = new HashSet<String>();
    
      
      List<AccountsBean> mergedList2 = new ArrayList<AccountsBean>();
      
      //mergedList2 에 해당하는건 그대루 넣어준다
      LocalDate date = sevenDaysAgo;
      while (!date.isAfter(currentDate)) {
          String dateString = date.format(formatter);
          boolean dateMatched = false;
          
          for (AccountsBean bean : countAccount) {
              if (dateString.equals(bean.getJoin_date())) {
                  AccountsBean mergedBean = new AccountsBean();
                  mergedBean.setJoin_date(dateString);
                  mergedBean.setCount(bean.getCount());
                  mergedList2.add(mergedBean);
                  dateMatched = true;
                  break;
              }
          }
          
          if (!dateMatched) {
              AccountsBean mergedBean = new AccountsBean();
              mergedBean.setJoin_date(dateString);
              mergedBean.setCount(0);
              mergedList2.add(mergedBean);
          }
          
          date = date.plusDays(1);
      }

      //sort
      Collections.sort(mergedList2, new Comparator<AccountsBean>() {
    	    public int compare(AccountsBean a1, AccountsBean a2) {
    	        return a1.getJoin_date().compareTo(a2.getJoin_date());
    	    }
    	});
      
		/*
		 * System.out.println("countAccount: " + countAccount.size()); for (AccountsBean
		 * x : countAccount) { System.out.println("x.getJoin_date(): " +
		 * x.getJoin_date()); System.out.println("x.getCount(): " + x.getCount());
		 * System.out.println(); }
		 */
      
      
      
      int courseCount = courseDao.getTotalCount(null);
      int accountLeave = courseDao.getLeaveAccount();
      int accountTotal = courseDao.getTotalCountAccount();
      
      int notRegistUnit = courseDao.getnotRegistUnit();
      List<AccountsBean> recentlyAccount = courseDao.recentlyAccount();
      
      mav.addObject("weeklist",mergedList);
      mav.addObject("countAccount", mergedList2);      
      
      mav.addObject("notRegistUnit", notRegistUnit);
      mav.addObject("courseCount", courseCount);
      mav.addObject("accountLeave", accountLeave);
      mav.addObject("accountTotal", accountTotal);
      
      mav.addObject("recentlyAccount", recentlyAccount);
      mav.setViewName(getPage);
      return mav;
   }
   
}