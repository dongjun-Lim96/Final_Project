package unit.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnitDao {
	private String namespace = "unit.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
}
