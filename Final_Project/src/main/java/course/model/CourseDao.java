package course.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import accounts.model.AccountsBean;
import category.model.CategoryBean;
import courseorder.model.CourseOrderBean;
import review.model.ReviewBean;
import unit.model.UnitBean;
import utility.Paging;
import wishList.model.WishListBean;


 
@Component
public class CourseDao {
//주석처리입니다
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

	public List<CourseBean> getFreeCourse() {
	      
	      List<CourseBean> lists = new ArrayList<CourseBean>();
	      
	      lists = sqlSessionTemplate.selectList(namespace+".GetFreeCourseList");
	      
	      
	      return lists; 
	   }

	public List<UnitBean> getUnitBycourseCode(String courseCode) {
		List<UnitBean> lists = new ArrayList<UnitBean>();
		lists = sqlSessionTemplate.selectList(namespace+".getUnitBycourseCode",courseCode);
		return lists;
	}
	
	
	public List<WishListBean> selectWishList(String userId) {
		List<WishListBean> lists = new ArrayList<WishListBean>();
		lists = sqlSessionTemplate.selectList(namespace+".SelectWishList", userId);
		
		return lists;
	}

	public List<CourseBean> getSotredPaidCourse(String categoryCode) {
		List<CourseBean> lists = new ArrayList<CourseBean>();		
		lists = sqlSessionTemplate.selectList(namespace+".GetSotredPaidCourseList",categoryCode);		
		return lists;
	}

	public List<CourseOrderBean> getWeekOrder(Map<String,Object> param ) {
		List<CourseOrderBean> lists = new ArrayList<CourseOrderBean>();
		//System.out.println("1111111111111");
		//System.out.println("map map map"  + param );
		lists = sqlSessionTemplate.selectList(namespace+".GetWeekOrder",param );
		//System.out.println("222222222222222");
		return lists;
	} 
	public List<Integer> getOrderDetails(String userId) {
	      
	      List<Integer> oddArr = sqlSessionTemplate.selectList(namespace + ".GetOrderDetails", userId);
	      System.out.println("userid:%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + userId);
	      return oddArr;
	}

	public List<AccountsBean> getCountAccount() {  
		System.out.println("11111111  11111");
		List<AccountsBean> lists = new ArrayList<AccountsBean>();
		System.out.println("22222222222222");
		lists = sqlSessionTemplate.selectList(namespace+".GetCountAccount");
		System.out.println("333333333333333");
		return lists;
	}
	
	public CourseBean getOneCourseByName(String courseCode) {
	      CourseBean courseBean = new CourseBean();
	      
	      //System.out.println("888888888888"+courseCode);
	      courseBean = sqlSessionTemplate.selectOne(namespace+".GetOneCourseByName",courseCode);
	      return courseBean;
	   }

	public List<CourseOrderBean> selectCourseList(String userId) {
		List<CourseOrderBean> lists = new ArrayList<CourseOrderBean>();		
		lists = sqlSessionTemplate.selectList(namespace+".SelectCourseList",userId);		
		return lists;
	}

	public WishListBean selectWishListDetail(Map<String, Object> map) {
		WishListBean wb = new WishListBean();
		wb = sqlSessionTemplate.selectOne(namespace+".SelectWishListDetail",map);
		return wb;
	}

	public CourseBean selectCourseListDetail(Map<String, Object> map) {
		CourseBean cob = new CourseBean();
		cob = sqlSessionTemplate.selectOne(namespace+".SelectCourseListDetail",map);
		return cob;
	}

	public int getTotalCountAccount() {
		int cnt;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetTotalCountAccount");
		return cnt;
	}
	public int getLeaveAccount() {
		int cnt;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetLeaveAccount");
		return cnt;
	}

	public List<AccountsBean> recentlyAccount() {
		List<AccountsBean> lists  = new ArrayList<AccountsBean>();
		lists = sqlSessionTemplate.selectList(namespace+".recentlyAccount");
		return lists;
	}

	public int getnotRegistUnit() {
		int cnt =0;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetnotRegistUnit");
		return cnt;
	}

	public int getrunningCourseCnt() {
		int cnt =0;
		cnt = sqlSessionTemplate.selectOne(namespace+".GetrunningCourseCnt");
		return cnt;
	}

	public AccountsBean getUserInfo(String userId) {
		AccountsBean accounts = sqlSessionTemplate.selectOne(namespace+".GetUserInfo", userId);
		return accounts;
	}
}
