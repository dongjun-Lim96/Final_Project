package data.model;

import java.sql.Timestamp;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

public class DataBean {
   private int dataNumber;
   private String adminId;
   @Length(min = 1, message = "내용을 입력하세요")
   private String dataTitle;
   @Length(min = 1, message = "내용을 입력하세요")
   private String dataContent;
   
   private String dataImage;
   private Timestamp dataDate;
   private int dataView;
   
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
	
	
	
	
	public DataBean() {
		super();
	}
	
	public DataBean(int dataNumber, String adminId, String dataTitle, String dataContent, String dataImage,
			Timestamp dataDate, int dataView, int rank, MultipartFile upload, String upload2) {
		super();
		this.dataNumber = dataNumber;
		this.adminId = adminId;
		this.dataTitle = dataTitle;
		this.dataContent = dataContent;
		this.dataImage = dataImage;
		this.dataDate = dataDate;
		this.dataView = dataView;
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
		
		System.out.println("upload : " + upload);
		
		// 파일의 오리지널 이름을 가져온다.
		String fileName = upload.getOriginalFilename();
		System.out.println("fileName : " + fileName);
		
		this.dataImage = fileName;
	}
	
	
	
	public int getDataNumber() {
		return dataNumber;
	}
	public void setDataNumber(int dataNumber) {
		this.dataNumber = dataNumber;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getDataTitle() {
		return dataTitle;
	}
	public void setDataTitle(String dataTitle) {
		this.dataTitle = dataTitle;
	}
	public String getDataContent() {
		return dataContent;
	}
	public void setDataContent(String dataContent) {
		this.dataContent = dataContent;
	}
	public String getDataImage() {
		return dataImage;
	}
	public void setDataImage(String dataImage) {
		this.dataImage = dataImage;
	}
	public Timestamp getDataDate() {
		return dataDate;
	}
	public void setDataDate(Timestamp dataDate) {
		this.dataDate = dataDate;
	}
	public int getDataView() {
		return dataView;
	}
	public void setDataView(int dataView) {
		this.dataView = dataView;
	}

	
	
	
	
}