package course.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseDao {

	private String namespace = "accounts.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	
	
}
