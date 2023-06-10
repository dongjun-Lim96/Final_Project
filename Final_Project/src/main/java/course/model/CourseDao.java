package course.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class CourseDao {

	private String namespace = "course.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<CourseBean> getCourse() {
		List<CourseBean> lists = new ArrayList<CourseBean>();
		lists = sqlSessionTemplate.selectList(namespace+".GetCourseList");
		
		return lists;
	}

	public boolean searchCode(String courseCode) {
		boolean result = false; 
		int cnt = sqlSessionTemplate.selectOne(namespace+".SearchCourseCode", courseCode);
		if (cnt>0) {
			result = true;
		}
		
		return result;
	}

	public int insertCourse(CourseBean courseBean) {
		int cnt= -1;
		cnt = sqlSessionTemplate.insert(namespace+".InsertCourse",courseBean);
		return cnt;
	}

	
	
}
