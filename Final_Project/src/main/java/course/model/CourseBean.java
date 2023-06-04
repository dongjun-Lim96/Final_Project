package course.model;


public class CourseBean {
	private String courseCode;
	private String categoryCode;
	private String cousreName;
	private int cousrePrice;
	private String cousreTeacher;
	private String cousreImg;
	private String cousreVideo;
	private String cousreTerm;
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
	public String getCousreTerm() {
		return cousreTerm;
	}
	public void setCousreTerm(String cousreTerm) {
		this.cousreTerm = cousreTerm;
	}
	public CourseBean(String courseCode, String categoryCode, String cousreName, int cousrePrice, String cousreTeacher,
			String cousreImg, String cousreVideo, String cousreTerm) {
		super();
		this.courseCode = courseCode;
		this.categoryCode = categoryCode;
		this.cousreName = cousreName;
		this.cousrePrice = cousrePrice;
		this.cousreTeacher = cousreTeacher;
		this.cousreImg = cousreImg;
		this.cousreVideo = cousreVideo;
		this.cousreTerm = cousreTerm;
	}
	public CourseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
