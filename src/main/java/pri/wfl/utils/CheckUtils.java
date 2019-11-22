package pri.wfl.utils;

import java.io.IOException;
import java.net.HttpCookie;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

import pri.wfl.obj.CheckInInfo;
import pri.wfl.obj.Cookie;

public class CheckUtils {
	public CloseableHttpClient chttpClient;
	public CookieStore cookieStore;
	
	public void init() {
		chttpClient = HttpClients.createDefault();
		cookieStore = new BasicCookieStore();
	}
	//ǩ��
	public int checkIn(CheckInInfo checkInInfo) throws IOException {
		int result = 1;
		init();
		for(Cookie i : checkInInfo.getCookies()) {
			BasicClientCookie clientCookie = new BasicClientCookie( i.getCookiename() , i.getValue() );
			clientCookie.setPath(checkInInfo.getPath()==null?"/":checkInInfo.getPath());
			clientCookie.setDomain(checkInInfo.getDomain());
			cookieStore.addCookie(clientCookie);
		}
		HttpClientContext httpContext = new HttpClientContext();
		httpContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
		
		HttpGet httpGet = new HttpGet(checkInInfo.getCheckinUrl());
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0"); // 设置请求头消息User-Agent
		CloseableHttpResponse response=chttpClient.execute(httpGet, httpContext);
		System.out.println("Status:"+response.getStatusLine().getStatusCode());
		HttpEntity entity=response.getEntity();//��ȡ����ʵ��
		System.out.println("Content-Type:"+entity.getContentType().getValue());
		System.out.println("==================="+checkInInfo.getCheckname()+" Text===================");
		System.out.println(EntityUtils.toString(entity, "utf-8"));
		System.out.println("===================Http End===================");
		
		close();
		return result;
	}
	
	public void close() throws IOException {
		chttpClient.close();
		cookieStore.clear();
	}
	
	public String test() throws IOException {
		String result="123";
		String autoCheckURL = "https://api.live.bilibili.com/sign/doSign";
		HttpClient httpClient = HttpClients.createDefault();
		CloseableHttpClient chttpClient = HttpClients.createDefault();
		
		//Creating the CookieStore object
		CookieStore cookieStore = new BasicCookieStore();		
		//Creating client cookie
		//BasicClientCookie clientCookie = new BasicClientCookie("name","aabbccufo");
		BasicClientCookie clientCookie = new BasicClientCookie("SESSDATA","e0739577%2C1576912911%2C48ad18b1");
		//  Set values to the cookie  
//		Calendar myCal = new GregorianCalendar(2019, 11, 26);
//		Date expiryDate = myCal.getTime();
//		clientCookie.setExpiryDate(expiryDate);
		clientCookie.setPath("/");
//		clientCookie.setSecure(true);
//		clientCookie.setValue("25");
//		clientCookie.setVersion(5);
		clientCookie.setDomain("api.live.bilibili.com");
//		clientCookie.setDomain("jdownloads.aubfco.ga");

		cookieStore.addCookie(clientCookie);

		HttpClientContext httpContext = new HttpClientContext();
		httpContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
		try {
			for(int i=1;i<=1;i++) {  //load autoCheckURL
				HttpGet httpGet = new HttpGet(autoCheckURL);
				HttpPost httpPost = new HttpPost(autoCheckURL);
				/*
				httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
				httpGet.setHeader(":authority:", "api.live.bilibili.com");
				httpGet.setHeader(":method:", "GET");
				httpGet.setHeader(":authority:", "api.live.bilibili.com");
				httpGet.setHeader(":path:", "/sign/doSign");
				httpGet.setHeader(":scheme:", "https");
				*/
//				httpGet.setHeader("Host","api.live.bilibili.com");
//				httpGet.setHeader("Connection","keep-alive");
//				httpGet.setHeader("Pragma","no-cache");
//				httpGet.setHeader("Cache-Control","no-cache");
//				httpGet.setHeader("Upgrade-Insecure-Requests","1");
//				httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36");
//				httpGet.setHeader("Sec-Fetch-User","?1");
//				httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
//				httpGet.setHeader("Sec-Fetch-Site","none");
//				httpGet.setHeader("Sec-Fetch-Mode","navigate");
//				httpGet.setHeader("Accept-Encoding","gzip, deflate, br");.
//				httpGet.setHeader("Accept-Language","zh-CN,zh;q=0.9");
//				httpGet.setHeader("Cookie","SESSDATA=e0739577%2C1576912911%2C48ad18b1");
				
				CloseableHttpResponse response=chttpClient.execute(httpGet, httpContext);
				//��ӡ���(������
				System.out.println("Status:"+response.getStatusLine().getStatusCode());
				HttpEntity entity=response.getEntity();//��ȡ����ʵ��
				System.out.println("Content-Type:"+entity.getContentType().getValue());
				System.out.println("===================Http Text===================");
				System.out.println(EntityUtils.toString(entity, "utf-8"));
				System.out.println("===================Http End===================");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			chttpClient.close();
		}
		//httpClient.getParams().setParameter(name, value);
		//HttpGet httpGet = new HttpGet("https://www.baidu.com");
		
		return result;	
	}
}
