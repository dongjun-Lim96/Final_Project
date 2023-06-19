package cart.model;

public class CartBean {
	private int cartNumber;
	private String courseCode;
	private String userId;
	private String categoryCode;
	private String cousreName;
	private int cousrePrice;
	
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
	public int getCartNumber() {
		return cartNumber;
	}
	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
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
	
}
