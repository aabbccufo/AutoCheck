package pri.wfl.obj;


public class CheckInInfo {
	public int checkID;
	public String checkname;
	public String username;
	public String password;
	public String checkinUrl;
	public String cookie;
	
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
	public String getCheckinUrl() {
		return checkinUrl;
	}
	public void setCheckinUrl(String checkinUrl) {
		this.checkinUrl = checkinUrl;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public int getCheckID() {
		return checkID;
	}
	public void setCheckID(int checkID) {
		this.checkID = checkID;
	}

	public String getCheckname() {
		return checkname;
	}
	public void setCheckname(String checkname) {
		this.checkname = checkname;
	}
	public void print() {
		System.out.println("checkID:"+getCheckID());
		System.out.println("checkname:"+getCheckname());
		System.out.println("username:"+getUsername());
		System.out.println("password:"+getPassword());
		System.out.println("checkinUrl:"+getCheckinUrl());
		System.out.println("cookie:"+getCookie());
	}
}
