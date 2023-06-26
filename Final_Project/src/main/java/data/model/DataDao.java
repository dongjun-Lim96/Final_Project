package data.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class DataDao {

	private String namespace = "data.model";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<DataBean> getAllData(Paging pageInfo,Map<String, String> map) {
		List<DataBean> lists = new ArrayList<DataBean>();	
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".GetDataList",map,rowBounds);
		return lists;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".CountData",map);
		return cnt;
	}

	public int writeData(DataBean dataBean) {
	    int cnt = 0;

	    // ADMININFO 테이블에서 adminId 값이 존재하는지 확인
	    String adminId = dataBean.getAdminId();
	    int existingAdminCount = sqlSessionTemplate.selectOne(namespace + ".CheckExistingAdminId", adminId);

	    if (existingAdminCount > 0) {
	        
	        cnt = sqlSessionTemplate.insert(namespace + ".WriteData", dataBean);
	    } else {
	        // adminId 값이 존재하지 않으면 오류 처리
	        cnt = -1;
	    }

	    return cnt;
	}

	public DataBean getOneDataByNum(int dataNumber) {
	    // 조회수 증가
	    sqlSessionTemplate.update(namespace + ".UpdateDataView", dataNumber);

	    // 해당 글 가져오기
	    String query = namespace + ".OneData";
	    DataBean data = sqlSessionTemplate.selectOne(query, dataNumber);

	    return data;
	}

	public String getPasswordByNum(int dataNumber) {
		String originalPasswd="";
		originalPasswd = sqlSessionTemplate.selectOne(namespace+".GetoriginalPasswd",dataNumber);
		return originalPasswd;
	}

	public int deleteOneData(int dataNumber ) {
		int cnt=0;
		cnt = sqlSessionTemplate.delete(namespace+".DeleteOneData", dataNumber);
		return cnt;
	}

	public int updateData(DataBean dataBean) {
		int cnt=0; 
		cnt = sqlSessionTemplate.update(namespace+".UpdateData", dataBean);
		return cnt;
		
	}


	public int updateBoardCuzReply(DataBean dataBean) {
		int cnt=0;
		
		cnt = sqlSessionTemplate.update(namespace+".UpdateBoardCuzReply", dataBean);
		return cnt;
		
	}
	
}
