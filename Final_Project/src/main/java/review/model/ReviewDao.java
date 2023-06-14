package review.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewDao {
	private String namespace = "review.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
}
