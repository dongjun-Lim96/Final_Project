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

    // ADMININFO ���̺��� adminId ���� �����ϴ��� Ȯ��
    String adminId = eventBean.getAdminId();
    int existingAdminCount = sqlSessionTemplate.selectOne(namespace + ".CheckExistingAdminId", adminId);

    if (existingAdminCount > 0) {
        // adminId ���� �����ϸ� Event ���̺� ������ ����
        cnt = sqlSessionTemplate.insert(namespace + ".WriteEvent", eventBean);
        System.out.println("cnt:"+cnt);
    } else {
        // adminId ���� �������� ������ ���� ó��
        cnt = -1;
    }

    return cnt;
}

public EventBean getOneEventByNum(int eventNumber) {
    // ��ȸ�� ����
    sqlSessionTemplate.update(namespace + ".UpdateEventView", eventNumber);

    // �ش� �� ��������
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