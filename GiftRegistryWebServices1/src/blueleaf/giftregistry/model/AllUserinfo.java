package blueleaf.giftregistry.model;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class AllUserinfo {
	
	long userID;
	String username;
	String password;
	String email;
	int userType;
    long phoneNum;
	
	public AllUserinfo() {
		
	
	}
	
public AllUserinfo(long userID,String username, String password, String email, int userType,long phoneNum) {
		
		this.userID=userID;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userType = userType;
		this.phoneNum=phoneNum;
	}

public long getUserID() {
	return userID;
}
public void setUserID(long userID) {
	this.userID = userID;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getUserType() {
	return userType;
}
public void setUserType(int userType) {
	this.userType = userType;
}
public long getPhoneNum() {
	return phoneNum;
}
public void setPhoneNum(int phoneNum) {
	this.phoneNum = phoneNum;
}

}
