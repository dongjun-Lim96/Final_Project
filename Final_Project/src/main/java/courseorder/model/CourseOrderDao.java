package courseorder.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import accounts.model.AccountsBean;


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

	public List<AccountsBean> getAccountBuyList() {
		List<AccountsBean> lists = new ArrayList<AccountsBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetAccountBuyList");
		return lists;
	}
	
}
