package review.model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewDao {
	private String namespace = "review.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public void insertReview(ReviewBean rb) {
		sqlSessionTemplate.insert(namespace+".InsertReview", rb);
	}

	public int reviewCount(Map<String, Object> map) {
		int cnt = sqlSessionTemplate.selectOne(namespace+".ReviewCount", map);
		return cnt;
	}

	public ReviewBean getUserReview(Map<String, Object> map) {
		ReviewBean rb = sqlSessionTemplate.selectOne(namespace+".GetUserReview", map);
		return rb;
	}

	public void updateReview(ReviewBean rb) {
		sqlSessionTemplate.update(namespace+".UpdateReview", rb);
	}

	public void deleteReview(Map<String, Object> map) {
		sqlSessionTemplate.delete(namespace+".DeleteReview", map);
	}
	
	
	
}
