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
	        // ���� ó�� ����
	        e.printStackTrace(); // ���� ���� ��� (���� ����)
	        // �߰����� ���� ó�� �۾��� �����ϰ��� �Ѵٸ� ���⿡ �ۼ�
	        cnt = -1;
	    } 
	    return cnt;
	}

	public void addWishList(WishListBean wb) {
		sqlSessionTemplate.insert(namespace+".AddWishList", wb);
	}
}
