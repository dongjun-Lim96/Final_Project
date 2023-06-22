package courseorder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import accounts.model.AccountsBean;
import course.model.CourseBean;
import utility.Paging;


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

	public List<AccountsBean> getAccountBuyList(Paging pageInfo,Map<String,String> map) {
		List<AccountsBean> lists = new ArrayList<AccountsBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".GetAccountBuyList",map,rowBounds);
		return lists;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCount",map);
		System.out.println("cnt : " + cnt );
		return cnt;
	}

	public int deleteAccount(String userId) {
		int cnt=0;
		try {
			cnt = sqlSessionTemplate.delete(namespace+".DeleteAccount",userId);
		} catch (DataIntegrityViolationException e) {
			cnt=0;
		}
		return cnt;
	}

	public List<CourseBean> getProgressById(String userId) {
		List<CourseBean> lists = new ArrayList<CourseBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetProgressById",userId);
		return lists;
	}

	public List<CourseBean> getFinishedById(String userId) {
		List<CourseBean> lists = new ArrayList<CourseBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetFinishedById",userId);
		return lists;
	}
	
}
