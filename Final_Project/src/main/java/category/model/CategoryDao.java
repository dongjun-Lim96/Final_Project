package category.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import course.model.CourseBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CategoryDao {

	private String namespace = "category.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	



	public boolean searchCode(String categoryCode) {
		boolean result = false; 
		int cnt = sqlSessionTemplate.selectOne(namespace+".SearchCgCode", categoryCode);
		if (cnt>0) {
			result = true;
		}
		
		return result;
	}


	public int insertCategory(CategoryBean cb) {
		int cnt=0;
		cnt = sqlSessionTemplate.insert(namespace+".InsertCg", cb);
		return cnt;
	}


	public List<CategoryBean> getCategory() {
		List<CategoryBean> lists = new ArrayList<CategoryBean>();
		
		lists = sqlSessionTemplate.selectList(namespace+".GetCategoryList");
		 
		return lists;
	}

 
	public int deleteCategory(String categoryCode) {
		
		int cnt = sqlSessionTemplate.delete(namespace+".DeleteCategory", categoryCode);
		return cnt;
	}

	
}
