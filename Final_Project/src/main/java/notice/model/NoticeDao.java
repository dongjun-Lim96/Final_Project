package notice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class NoticeDao {

	private String namespace = "notice.model";

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<NoticeBean> getAllNotice(Paging pageInfo,Map<String, String> map) {
		List<NoticeBean> lists = new ArrayList<NoticeBean>();	
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList(namespace+".GetNoticeList",map,rowBounds);
		return lists;
	}

	public int getTotalCount(Map<String, String> map) {
		int cnt = 0;
		cnt = sqlSessionTemplate.selectOne(namespace+".CountNotice",map);
		return cnt;
	}

	public int writeNotice(NoticeBean noticeBean) {
	    int cnt = 0;

	    // ADMININFO 테이블에서 adminId 값이 존재하는지 확인
	    String adminId = noticeBean.getAdminId();
	    int existingAdminCount = sqlSessionTemplate.selectOne(namespace + ".CheckExistingAdminId", adminId);

	    if (existingAdminCount > 0) {
	        // adminId 값이 존재하면 NOTICE 테이블에 데이터 삽입
	        cnt = sqlSessionTemplate.insert(namespace + ".WriteNotice", noticeBean);
	    } else {
	        // adminId 값이 존재하지 않으면 오류 처리
	        cnt = -1;
	    }

	    return cnt;
	}

	public NoticeBean getOneNoticeByNum(int noticeNumber) {
	    // 조회수 증가
	    sqlSessionTemplate.update(namespace + ".UpdateNoticeView", noticeNumber);

	    // 해당 글 가져오기
	    String query = namespace + ".OneNotice";
	    NoticeBean notice = sqlSessionTemplate.selectOne(query, noticeNumber);

	    return notice;
	}

	public String getPasswordByNum(int noticeNumber) {
		String originalPasswd="";
		originalPasswd = sqlSessionTemplate.selectOne(namespace+".GetoriginalPasswd",noticeNumber);
		return originalPasswd;
	}

	public int deleteOneNotice(int noticeNumber ) {
		int cnt=0;
		cnt = sqlSessionTemplate.delete(namespace+".DeleteOneNotice", noticeNumber);
		return cnt;
	}

	public int updateNotice(NoticeBean noticeBean) {
		int cnt=0; 
		cnt = sqlSessionTemplate.update(namespace+".UpdateNotice", noticeBean);
		return cnt;
		
	}

	/*
	 * public int replyNotice(NoticeBean noticeBean) { int cnt=0;
	 * noticeBean.setRestep(noticeBean.getRestep()+1);
	 * noticeBean.setRelevel(noticeBean.getRelevel()+1); cnt=
	 * sqlSessionTemplate.insert(namespace+".ReplyNotice",noticeBean); return cnt;
	 * 
	 * }
	 */

	public int updateBoardCuzReply(NoticeBean noticeBean) {
		int cnt=0;
		
		cnt = sqlSessionTemplate.update(namespace+".UpdateBoardCuzReply", noticeBean);
		return cnt;
		
	}
	
}
