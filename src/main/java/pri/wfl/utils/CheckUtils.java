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

public class CheckUtils {
	
	public String checkUrl;
	public String username;
	public String password;
	public String statCode;
	
	public CloseableHttpClient chttpClient;
	public CookieStore cookieStore;
	
	public void init() {
		chttpClient = HttpClients.createDefault();
		cookieStore = new BasicCookieStore();
	}
	
	//读取配置
	public int loadConfig() {
		return 1;
	}
	
	
	public int createConnect() {
		return 1;
	}
	
	//签到
	public int checkIn() {
		return 1;
	}
	
	public int close() {
		return 1;
	}
	
	public String test() throws IOException {
		String result="123";
		String autoCheckURL = "https://rainkmc.com/plugin.php?id=u179_qdgj&action=punch";
		HttpClient httpClient = HttpClients.createDefault();
		CloseableHttpClient chttpClient = HttpClients.createDefault();
		
		//Creating the CookieStore object
		CookieStore cookieStore = new BasicCookieStore();		
		//Creating client cookie
		//BasicClientCookie clientCookie = new BasicClientCookie("name","aabbccufo");
		BasicClientCookie clientCookie = new BasicClientCookie("ihFD_2132_auth","385fnr0LpkLS%2BGDigo12ypvoCWKz9EAJW9ADXQTKwLRGd5Fek3uYBeC43tC6Ca245aVuuDY%2Fj3Sj4RgnKl8Osd0HDw");
		BasicClientCookie clientCookie2 = new BasicClientCookie("ihFD_2132_saltkey","LIUuqUfj");
		//  Set values to the cookie  
//		Calendar myCal = new GregorianCalendar(2019, 11, 26);
//		Date expiryDate = myCal.getTime();
//		clientCookie.setExpiryDate(expiryDate);
		clientCookie.setPath("/");
		clientCookie2.setPath("/");
//		clientCookie.setSecure(true);
//		clientCookie.setValue("25");
//		clientCookie.setVersion(5);
		clientCookie.setDomain("rainkmc.com");
		clientCookie2.setDomain("rainkmc.com");
		//clientCookie.setDomain("jdownloads.aubfco.ga");

		cookieStore.addCookie(clientCookie);
		cookieStore.addCookie(clientCookie2);

		HttpClientContext httpContext = new HttpClientContext();
		httpContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
		try {
			for(int i=1;i<=1;i++) {  //load autoCheckURL
				HttpGet httpGet = new HttpGet(autoCheckURL);
				HttpPost httpPost = new HttpPost(autoCheckURL);
				CloseableHttpResponse response=chttpClient.execute(httpGet, httpContext);
				//打印结果(测试用
				System.out.println("Status:"+response.getStatusLine().getStatusCode());
				HttpEntity entity=response.getEntity();//获取返回实体
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
