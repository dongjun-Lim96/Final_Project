package course.model;

import org.springframework.web.multipart.MultipartFile;
 
public class CourseBean {
	private String courseCode;
	private String categoryCode;
	private String cousreName;
	private int cousrePrice;
	private String cousreTeacher;
	private String cousreImg;
	private String cousreVideo;
	private String cousreImg2;
	private String cousreVideo2;
	 
	private int cousreTerm;
	 
	private MultipartFile uploadimg;
	private MultipartFile uploadvideo;
	
	
	
	
	public String getCousreImg2() {
		return cousreImg2;
	}
	public void setCousreImg2(String cousreImg2) {
		this.cousreImg2 = cousreImg2;
	}
	public String getCousreVideo2() {
		return cousreVideo2;
	}
	public void setCousreVideo2(String cousreVideo2) {
		this.cousreVideo2 = cousreVideo2;
	}
	public MultipartFile getUploadimg() {
		return uploadimg;
	}
	public void setUploadimg(MultipartFile uploadimg) {
		this.uploadimg = uploadimg;
		String img = uploadimg.getOriginalFilename();
		this.cousreImg = img;
	}
	public MultipartFile getUploadvideo() {
		return uploadvideo;
	}
	public void setUploadvideo(MultipartFile uploadvideo) {
		this.uploadvideo = uploadvideo;
		String video = uploadvideo.getOriginalFilename();
		this.cousreVideo = video;
	}
	
	

	public CourseBean(String courseCode, String categoryCode, String cousreName, int cousrePrice, String cousreTeacher,
			String cousreImg, String cousreVideo, int cousreTerm, MultipartFile uploadimg, MultipartFile uploadvideo) {
		super();
		this.courseCode = courseCode;
		this.categoryCode = categoryCode;
		this.cousreName = cousreName;
		this.cousrePrice = cousrePrice;
		this.cousreTeacher = cousreTeacher;
		this.cousreImg = cousreImg;
		this.cousreVideo = cousreVideo;
		this.cousreTerm = cousreTerm;
		this.uploadimg = uploadimg;
		this.uploadvideo = uploadvideo;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCousreName() {
		return cousreName;
	}
	public void setCousreName(String cousreName) {
		this.cousreName = cousreName;
	}
	public int getCousrePrice() {
		return cousrePrice;
	}
	public void setCousrePrice(int cousrePrice) {
		this.cousrePrice = cousrePrice;
	}
	public String getCousreTeacher() {
		return cousreTeacher;
	}
	public void setCousreTeacher(String cousreTeacher) {
		this.cousreTeacher = cousreTeacher;
	}
	public String getCousreImg() {
		return cousreImg;
	}
	public void setCousreImg(String cousreImg) {
		this.cousreImg = cousreImg;
	}
	public String getCousreVideo() {
		return cousreVideo;
	}
	public void setCousreVideo(String cousreVideo) {
		this.cousreVideo = cousreVideo;
	}
	public int getCousreTerm() {
		return cousreTerm;
	}
	public void setCousreTerm(int cousreTerm) {
		this.cousreTerm = cousreTerm;
	}
	

	public CourseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
