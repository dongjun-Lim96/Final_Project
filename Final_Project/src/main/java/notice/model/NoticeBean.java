package notice.model;

import java.sql.Timestamp;

public class NoticeBean {
	private int noticeNumber;
	private String adminId;
	private String noticeTitle;
	private String noticeContent;
	private String noticeImage1;
	private String noticeImage2;
	private Timestamp noticeDate;
	private int noticeView;
	
	
	public int getNoticeNumber() {
		return noticeNumber;
	}
	public void setNoticeNumber(int noticeNumber) {
		this.noticeNumber = noticeNumber;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeImage1() {
		return noticeImage1;
	}
	public void setNoticeImage1(String noticeImage1) {
		this.noticeImage1 = noticeImage1;
	}
	public String getNoticeImage2() {
		return noticeImage2;
	}
	public void setNoticeImage2(String noticeImage2) {
		this.noticeImage2 = noticeImage2;
	}
	public Timestamp getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Timestamp noticeDate) {
		this.noticeDate = noticeDate;
	}
	public int getNoticeView() {
		return noticeView;
	}
	public void setNoticeView(int noticeView) {
		this.noticeView = noticeView;
	}
	
	
}
