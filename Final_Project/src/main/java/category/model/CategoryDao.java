package category.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class CategoryDao {

	private String namespace = "category.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	
	public CategoryBean GetAccountsById(String userId) {
		CategoryBean cb= new CategoryBean();
		cb = sqlSessionTemplate.selectOne(namespace+".GetAccountsById",userId); 
		return cb;

	}

	
}
