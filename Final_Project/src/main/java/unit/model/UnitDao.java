package unit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class UnitDao {
	private String namespace = "unit.model";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<UnitBean> getUnitList(Paging pageInfo,Map<String, String> map) {
		List<UnitBean> lists = new ArrayList<UnitBean>();
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".getUnitList",map,rowBounds);
		return lists;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".CountUnit",map);
		return cnt;
	}

	public UnitBean getOneUnitByCode(String courseCode) {
		UnitBean ub = new UnitBean();
		ub = sqlSessionTemplate.selectOne(namespace+".getOneUnit",courseCode);
		return ub;
	}

	public List<UnitBean> getNoUnitCourse() {
		List<UnitBean> lists = new ArrayList<UnitBean>();
		lists = sqlSessionTemplate.selectList(namespace+".NoUnitCourse");				
		return lists;
	} 

	public int insertUnit(UnitBean unitBean) {
		int cnt =0;
		cnt = sqlSessionTemplate.insert(namespace+".InsertUnit", unitBean);
		return cnt;
		
	}
}
