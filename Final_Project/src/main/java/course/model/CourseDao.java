package course.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class CourseDao {

	private String namespace = "accounts.course";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<CourseBean> getCourse() {
		List<CourseBean> lists = new ArrayList<CourseBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetCourseList");
		
		return lists;
	}

	
	
}
