package accounts.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	
}
