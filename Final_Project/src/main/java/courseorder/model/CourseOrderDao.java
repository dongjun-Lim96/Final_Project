package courseorder.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CourseOrderDao {
	
	private String namespace = "courseorder.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public CourseOrderBean getOrderById(String userId) {
		CourseOrderBean cob = new CourseOrderBean();
		cob = sqlSessionTemplate.selectOne(namespace+".GetOrderById",userId); 
		return cob;
	}
	
}
