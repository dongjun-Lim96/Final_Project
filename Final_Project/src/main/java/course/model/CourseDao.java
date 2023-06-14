package course.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import category.model.CategoryBean;
import review.model.ReviewBean;
import utility.Paging;


 
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
		System.out.println("insertCourse cnt : " + cnt);
		return cnt;
	}

	public List<CourseBean> getAllCourse(Paging pageInfo,Map<String, String> map) {
		List<CourseBean> lists = new ArrayList<CourseBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".GetAllCourseList",map,rowBounds);
		
		return lists;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = 0;

		cnt = sqlSessionTemplate.selectOne(namespace+".CountCourse",map);

		return cnt;
	}
 
	public CourseBean getOneCourseByCode(String courseCode) {
		CourseBean courseBean = new CourseBean();
		courseBean = sqlSessionTemplate.selectOne(namespace+".OneCourseByCode",courseCode);
		return courseBean;
	}

	public int UpdateCourse(CourseBean courseBean) {
		int cnt=0;
		cnt = sqlSessionTemplate.update(namespace+".UpdateCourse",courseBean);
		return cnt;
	}

	public int deleteOneCourse(String courseCode) {
		int cnt=0;
		try {
			cnt = sqlSessionTemplate.delete(namespace+".DeleteCourse",courseCode);
		}catch (Exception e) {
	        // 예외 처리 로직
	        e.printStackTrace(); // 예외 정보 출력 (선택 사항)
	        // 추가적인 예외 처리 작업을 수행하고자 한다면 여기에 작성
	        cnt = -1;
	    } 
	    return cnt;
	}

	public List<CourseBean> getPaidCourse() {
		List<CourseBean> lists = new ArrayList<CourseBean>();
		
		lists = sqlSessionTemplate.selectList(namespace+".GetPaidCourseList");
		
		
		return lists;
	}

	public List<CategoryBean> getCategory() {
		List<CategoryBean> lists = new ArrayList<CategoryBean>();
		
		lists = sqlSessionTemplate.selectList(namespace+".getCategory"); 
		 
		return lists;
	}

	public List<ReviewBean> getReviewBycourseCode(String courseCode) {
		List<ReviewBean> review = new ArrayList<ReviewBean>();
		System.out.println("DAO의 getReviewBycourseCode : " + courseCode);
		review = sqlSessionTemplate.selectList(namespace+".getReviewBycourseCode",courseCode);
		System.out.println("review size : " + review.size());
		return review;
	}

	
	
}
