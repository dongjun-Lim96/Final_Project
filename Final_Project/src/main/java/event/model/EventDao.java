package event.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import event.model.EventBean;
import utility.Paging;

@Component
public class EventDao {

   
private String namespace = "event.model";

@Autowired
SqlSessionTemplate sqlSessionTemplate;

public List<EventBean> getAllEvent(Paging pageInfo,Map<String, String> map, String expired) {
   List<EventBean> lists = new ArrayList<EventBean>();   
   RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
  
   
   if (expired.equals("2")) {
	      lists = sqlSessionTemplate.selectList(namespace + ".GetExpiredEvents", map, rowBounds);
	   }else if(expired.equals("1")) {
		 
		   lists = sqlSessionTemplate.selectList(namespace + ".GetNotExpiredEvents", map, rowBounds);
	   } 
   
   		else {
	      lists = sqlSessionTemplate.selectList(namespace + ".GetEventList", map, rowBounds);
	   }
	   
   return lists;
}

public int getTotalCount(Map<String, String> map,String expired) {
   int cnt = 0;

   
   if (expired.equals("2")) {
	     
	   cnt = sqlSessionTemplate.selectOne(namespace+".GetExpiredCountEvent",map);
	
   }else if(expired.equals("1")) {
		 
		   
	cnt = sqlSessionTemplate.selectOne(namespace+".GetNotExpiredCountEvent",map);
	   } 

		else {
	   
			cnt = sqlSessionTemplate.selectOne(namespace+".CountEvent",map);
	   }
   
   
   return cnt;
}


public int writeEvent(EventBean eventBean) {
    int cnt = 0;

    // ADMININFO 테이블에서 adminId 값이 존재하는지 확인
    String adminId = eventBean.getAdminId();
    int existingAdminCount = sqlSessionTemplate.selectOne(namespace + ".CheckExistingAdminId", adminId);

    if (existingAdminCount > 0) {
        // adminId 값이 존재하면 Event 테이블에 데이터 삽입
        cnt = sqlSessionTemplate.insert(namespace + ".WriteEvent", eventBean);
        System.out.println("cnt:"+cnt);
    } else {
        // adminId 값이 존재하지 않으면 오류 처리
        cnt = -1;
    }

    return cnt;
}

public EventBean getOneEventByNum(int eventNumber) {
    // 조회수 증가
    sqlSessionTemplate.update(namespace + ".UpdateEventView", eventNumber);

    // 해당 글 가져오기
    String query = namespace + ".OneEvent";
    EventBean event = sqlSessionTemplate.selectOne(query, eventNumber);

    return event;
}

public String getPasswordByNum(int eventNumber) {
   String originalPasswd="";
   originalPasswd = sqlSessionTemplate.selectOne(namespace+".GetoriginalPasswd",eventNumber);
   return originalPasswd;
}

public int deleteOneEvent(int eventNumber ) {
   int cnt=0;
   cnt = sqlSessionTemplate.delete(namespace+".DeleteOneEvent", eventNumber);
   return cnt;
}

public int updateEvent(EventBean eventBean) {
	int cnt=0; 
	cnt = sqlSessionTemplate.update(namespace+".UpdateEvent", eventBean);
	return cnt;
	
}

}