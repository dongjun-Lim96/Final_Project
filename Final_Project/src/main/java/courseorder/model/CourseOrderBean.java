package courseorder.model;

import java.util.Date;

public class CourseOrderBean {
	private String orderNumber;
	private String courseCode;
	private String userId;
	private int orderPoint;
	private int totalPrice;
	private Date orderDate;
	
	private String cousreName;
	
	public String getCousreName() {
		return cousreName;
	}
	public void setCousreName(String cousreName) {
		this.cousreName = cousreName;
	}
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
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
}
