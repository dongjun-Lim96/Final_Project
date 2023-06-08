package courseorder.model;

public class CourseOrderBean {
	private String orderNumber;
	private String courseCode;
	private String userId;
	private int orderPoint;
	private int TotalPrice;
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getOrderPoint() {
		return orderPoint;
	}
	public void setOrderPoint(int orderPoint) {
		this.orderPoint = orderPoint;
	}
	public int getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}
	
}
