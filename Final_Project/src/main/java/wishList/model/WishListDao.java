package wishList.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishListDao {
	
private String namespace = "wishList.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int deleteWishList(String courseCode) {
		int cnt=0;
		try {
			cnt = sqlSessionTemplate.delete(namespace+".DeleteWishList",courseCode);
		}catch (Exception e) {
	        // 예외 처리 로직
	        e.printStackTrace(); // 예외 정보 출력 (선택 사항)
	        // 추가적인 예외 처리 작업을 수행하고자 한다면 여기에 작성
	        cnt = -1;
	    } 
	    return cnt;
	}

	public void addWishList(WishListBean wb) {
		sqlSessionTemplate.insert(namespace+".AddWishList", wb);
	}
}
