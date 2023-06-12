package notice.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class NoticeBean {
   private int noticeNumber;
   private String adminId;
   private String noticeTitle;
   private String noticeContent;
   private String noticeImage;
   private Timestamp noticeDate;
   private int noticeView;
   
   private int rank;
   //list에서 연속적으로 순서 보여주기 위해서
   
   
   public int getRank() {
	return rank;
}
public void setRank(int rank) {
	this.rank = rank;
}
	//파일 담을 변수
	private MultipartFile upload;
	private String upload2;
	
	
	
	
	public NoticeBean() {
		super();
	}
	public NoticeBean(int noticeNumber, String adminId, String noticeTitle, String noticeContent, String noticeImage,
			Timestamp noticeDate, int noticeView, MultipartFile upload, String upload2) { 
		super();
		this.noticeNumber = noticeNumber;
		this.adminId = adminId;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeImage = noticeImage;
		this.noticeDate = noticeDate;
		this.noticeView = noticeView;
		this.upload = upload;
		this.upload2 = upload2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public String getUpload2() {
		return upload2;
	}
	public void setUpload2(String upload2) {
		this.upload2 = upload2;
	}

	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		System.out.println("setUpload");
		this.upload = upload;
		
		System.out.println("upload : " + upload); // upload에는 내가 선택한 화일의 정보가 들어간다.
		
		// 파일의 오리지널 이름을 가져온다.
		String fileName = upload.getOriginalFilename();
		System.out.println("fileName : " + fileName);
		
		// this 안붙여도 ㄱㅊ지만 멤버변수 확실히 하기 위해서!
		// 파일명을 image 변수에 넣는다
		this.noticeImage = fileName;
	}
	
	
	
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
	public String getNoticeImage() {
		return noticeImage;
	}
	public void setNoticeImage(String noticeImage) {
		this.noticeImage = noticeImage;
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