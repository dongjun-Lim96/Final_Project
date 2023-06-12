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

	    // ADMININFO ���̺��� adminId ���� �����ϴ��� Ȯ��
	    String adminId = noticeBean.getAdminId();
	    int existingAdminCount = sqlSessionTemplate.selectOne(namespace + ".CheckExistingAdminId", adminId);

	    if (existingAdminCount > 0) {
	        // adminId ���� �����ϸ� NOTICE ���̺� ������ ����
	        cnt = sqlSessionTemplate.insert(namespace + ".WriteNotice", noticeBean);
	    } else {
	        // adminId ���� �������� ������ ���� ó��
	        cnt = -1;
	    }

	    return cnt;
	}

	public NoticeBean getOneNoticeByNum(int noticeNumber) {
	    // ��ȸ�� ����
	    sqlSessionTemplate.update(namespace + ".UpdateNoticeView", noticeNumber);

	    // �ش� �� ��������
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
