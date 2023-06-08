package category.model;

public class CategoryBean {
	private String categoryCode;
	private String categoryName;
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public CategoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryBean(String categoryCode, String categoryName) {
		super();
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
	}
	
}
