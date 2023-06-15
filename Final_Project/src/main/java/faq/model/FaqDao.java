package faq.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FaqDao {

private String namespace = "faq.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<FaqBean> getFaq() {
		List<FaqBean> lists = new ArrayList<FaqBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetFaqList");
		
		return lists;
	}

	public int insertFaq(FaqBean fb) {
		
		
		
		return 0;
	}

}
