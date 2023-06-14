package event.model;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

public class EventBean {

	private int eventNumber;
	private String adminId;
	private String eventTitle;
	private String eventContent;
	private String eventImage;
	private Timestamp eventDate;
	private int eventView;
	
	 private int rank; 
	   
	   
	   public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

		private MultipartFile upload;
		private String upload2;
		  
	 

	public EventBean(int eventNumber, String adminId, String eventTitle, String eventContent, String eventImage,
				Timestamp eventDate, int eventView, int rank, MultipartFile upload, String upload2) { 
			super();
			this.eventNumber = eventNumber;
			this.adminId = adminId;
			this.eventTitle = eventTitle;
			this.eventContent = eventContent;
			this.eventImage = eventImage;
			this.eventDate = eventDate;
			this.eventView = eventView;
			this.rank = rank;
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
		
		String fileName = upload.getOriginalFilename();
		System.out.println("fileName : " + fileName);
		
		this.eventImage = fileName;
	}
	
	
	public int getEventNumber() {
		return eventNumber;
	}
	public void setEventNumber(int eventNumber) {
		this.eventNumber = eventNumber;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public String getEventContent() {
		return eventContent;
	}
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	public String getEventImage() {
		return eventImage;
	}
	public void setEventImage(String eventImage) {
		this.eventImage = eventImage;
	}
	public Timestamp getEventDate() {
		return eventDate;
	}
	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}
	public int getEventView() {
		return eventView;
	}
	public void setEventView(int eventView) {
		this.eventView = eventView;
	}
	
	
}
