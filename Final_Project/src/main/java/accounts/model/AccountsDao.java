package accounts.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import courseorder.model.CourseOrderBean;

import java.util.HashMap;

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
	
	
	public CourseOrderBean getOrderById(String userId) {
		CourseOrderBean cob = new CourseOrderBean();
		cob = sqlSessionTemplate.selectOne(namespace+".GetOrderById",userId); 
		return cob;
	}
	
}
