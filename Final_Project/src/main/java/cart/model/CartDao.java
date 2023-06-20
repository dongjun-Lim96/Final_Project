package cart.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import course.model.CourseBean;
import courseorder.model.CourseOrderBean;

@Component
public class CartDao {

	private String namespace = "cart.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public void cartAdd(CartBean cart) {
		sqlSessionTemplate.insert(namespace+".CartAdd", cart);
	}

	public boolean cartCheck(String courseCode) {
		boolean flag = false;
		int cnt = sqlSessionTemplate.selectOne(namespace+".CartCheck",courseCode);
		if (cnt>0) {
			flag = true; 
		}
		//System.out.println("//////////////////**************"+cnt);
		return flag;
	}
	
	public List<CartBean> cartList(String userId) {
		List<CartBean> lists = new ArrayList<CartBean>();
		lists = sqlSessionTemplate.selectList(namespace+".CartList",userId); 
		return lists;
	}

	public List<CartBean> getCartNumber(String userId) {
		List<CartBean> numList = new ArrayList<CartBean>();
		numList = sqlSessionTemplate.selectList(namespace+".GetCartNumber",userId); 
		return numList;
	}

	public void cartDelete(int[] array) {
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
		sqlSessionTemplate.delete(namespace+".CartDelete", array);
	}

	
	public void insertOrder(CourseOrderBean coBean) {
		System.out.println(coBean.getTotalPrice());
		sqlSessionTemplate.insert(namespace+".InsertOrder", coBean);
	}

	public void endCart() {
		sqlSessionTemplate.delete(namespace+".EndCart");
	}
	
	
}
