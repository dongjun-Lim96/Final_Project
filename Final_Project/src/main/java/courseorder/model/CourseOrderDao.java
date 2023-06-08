package courseorder.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CourseOrderDao {
	
	private String namespace = "courseOrder.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public CourseOrderBean getOrderById(String userId) {
		CourseOrderBean cob = new CourseOrderBean();
		cob = sqlSessionTemplate.selectOne(namespace+".GetOrderById",userId); 
		return cob;
	}
}
