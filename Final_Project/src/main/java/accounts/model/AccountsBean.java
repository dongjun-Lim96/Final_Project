package accounts.model;

import java.sql.Timestamp;

public class AccountsBean {
	private String userId;
	private String userName;
	private String userPw;
	private String userBirth;
	private String userEmail;
	private String userPhone;
	//private String userAddr; 주소 빼기로 함
	private int userPoint;
	private int userChkEmail;
	private int userChkPhone;
	private int userSubscribe;
	private Timestamp userJoinDate;
	private int userOut;
	private int adminCheck;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	/*
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	} 주소 빼기로 함
	*/
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public int getUserChkEmail() {
		return userChkEmail;
	}
	public void setUserChkEmail(int userChkEmail) {
		this.userChkEmail = userChkEmail;
	}
	public int getUserChkPhone() {
		return userChkPhone;
	}
	public void setUserChkPhone(int userChkPhone) {
		this.userChkPhone = userChkPhone;
	}
	public int getUserSubscribe() {
		return userSubscribe;
	}
	public void setUserSubscribe(int userSubscribe) {
		this.userSubscribe = userSubscribe;
	}
	public Timestamp getUserJoinDate() {
		return userJoinDate;
	}
	public void setUserJoinDate(Timestamp userJoinDate) {
		this.userJoinDate = userJoinDate;
	}
	public int getUserOut() {
		return userOut;
	}
	public void setUserOut(int userOut) {
		this.userOut = userOut;
	}
	public int getAdminCheck() {
		return adminCheck;
	}
	public void setAdminCheck(int adminCheck) {
		this.adminCheck = adminCheck;
	}
	
}
