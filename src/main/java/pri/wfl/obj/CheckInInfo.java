package pri.wfl.obj;

import java.util.ArrayList;

public class CheckInInfo {
	public String checkname;
	public String checkinUrl;
	public String domain;
	public String path;
	public ArrayList<Cookie> cookies = new ArrayList<Cookie>();
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public ArrayList<Cookie> getCookies() {
		return cookies;
	}
	public void setCookies(ArrayList<Cookie> cookies) {
		this.cookies = cookies;
	}
	public String getCheckinUrl() {
		return checkinUrl;
	}
	public void setCheckinUrl(String checkinUrl) {
		this.checkinUrl = checkinUrl;
	}
	public String getCheckname() {
		return checkname;
	}
	public void setCheckname(String checkname) {
		this.checkname = checkname;
	}
	
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public void print() {
		System.out.println("checkname:"+getCheckname());
		System.out.println("checkinUrl:"+getCheckinUrl());
		System.out.println("domain:"+getDomain());
		System.out.println("path:"+getPath());
		System.out.println("cookies:");
		for(Cookie i : cookies)
			System.out.println("cookiename:"+i.cookiename+"\tvalue:"+i.value);
	}
}
