package accounts.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import course.model.CourseBean;
import courseorder.model.CourseOrderBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class AccountsDao {

	private String namespace = "accounts.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	
	public AccountsBean GetAccountsById(String userId) {
		AccountsBean ab= new AccountsBean();
		ab = sqlSessionTemplate.selectOne(namespace+".GetAccountsById",userId); 
		return ab;

	}


	public AccountsBean GetUserIdByUserEmail(String input_userEmail) {
		AccountsBean ab= new AccountsBean();
		ab = sqlSessionTemplate.selectOne(namespace+".GetUserIdByUserEmail",input_userEmail); 
		
		return ab;
	}


	public AccountsBean GetAccountsByName(String input_userName) {
		AccountsBean ab= new AccountsBean();
		ab = sqlSessionTemplate.selectOne(namespace+".GetUserIdByUserName",input_userName); 
		
		return ab;
	}

	public AccountsBean GetAccountsByEmail(String input_userEmail) {
		AccountsBean ab= new AccountsBean();
		ab = sqlSessionTemplate.selectOne(namespace+".GetUserIdByUserEmail",input_userEmail); 
		
		return ab;
	}

	public AccountsBean GetAccountsByNameEmail(String input_userName, String input_userEmail) {
		AccountsBean ab= new AccountsBean();
		
		HashMap<String, String> M =new HashMap<String, String>(); 
		M.put("userName", input_userName);
		M.put("userEmail", input_userEmail);
		ab = sqlSessionTemplate.selectOne(namespace+".GetUserIdByUserNameEmail",M); 
		
		return ab;
	}


	public AccountsBean GetAccountsByIdEmail(String input_userId, String input_userEmail) {
		AccountsBean ab= new AccountsBean();
		HashMap<String, String> M =new HashMap<String, String>(); 
		M.put("userId", input_userId);
		M.put("userEmail", input_userEmail);
		ab = sqlSessionTemplate.selectOne(namespace+".GetUserIdByUserIdEmail",M); 
		
		return ab;
	}
	
	public boolean searchId(String userId) {
		boolean result = false; 
		int cnt = sqlSessionTemplate.selectOne(namespace+".SearchId", userId);
		if (cnt>0) {
			result = true;
		}
		
		return result;
	}
	
	public int accountsRegister(AccountsBean ab) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".AccountsRegister", ab);
		
		return cnt;
	}
	
	
	public List<CourseBean> getOrderById(String userId) {
		List<CourseBean> lists = new ArrayList<CourseBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetOrderById",userId); 
		return lists;
	}
	
	public int accountsUpdate(AccountsBean ab) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".AccountsUpdate", ab);
		
		return cnt;
	}
	
	public void outUser(String userId) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".OutUser", userId);
	}
	
	public List<CourseBean> getWishList(String userId) {
		List<CourseBean> lists = new ArrayList<CourseBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetWishList", userId); 
		return lists;
	}


	public List<CourseOrderBean> getPayList(String userId) {
		List<CourseOrderBean> lists = new ArrayList<CourseOrderBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetPayList", userId);
		return lists;
	}


	public List<CourseBean> getCourseList(String userId) {
		List<CourseBean> lists = new ArrayList<CourseBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetCourseList", userId); 
		return lists;
	}

	public List<CourseBean> getCourseEndList(String userId) {
		List<CourseBean> lists = new ArrayList<CourseBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetCourseEndList", userId); 
		return lists;
	}
	
	
}
