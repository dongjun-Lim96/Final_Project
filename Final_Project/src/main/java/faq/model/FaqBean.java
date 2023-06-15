package faq.model;

import java.util.Date;

public class FaqBean {

	private int faqNumber;
	private String faqTitle;
	private String faqContent;

	
	
	public FaqBean() {
		super();
	}



	public FaqBean(int faqNumber, String faqTitle, String faqContent) {
		super();
		this.faqNumber = faqNumber;
		this.faqTitle = faqTitle;
		this.faqContent = faqContent;
	}



	public int getFaqNumber() {
		return faqNumber;
	}



	public void setFaqNumber(int faqNumber) {
		this.faqNumber = faqNumber;
	}



	public String getFaqTitle() {
		return faqTitle;
	}



	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}



	public String getFaqContent() {
		return faqContent;
	}



	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	
	
	
}
