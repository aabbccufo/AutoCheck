package pri.wfl.src;

import java.util.ArrayList;

import com.alibaba.fastjson.*;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import pri.wfl.obj.CheckInInfo;
import pri.wfl.utils.FileUtils;

public class InitParameter {
	public ArrayList<CheckInInfo> CheckInInfos;
	public int init() {
		int result = reload();
		System.out.println("=====initInfo=====");
		print();
		System.out.println("=====End=====");
		return result;
	}
	public int reload() {
		String jsonStr;
		FileUtils fu = new FileUtils();
		//jsonStr = "{\"CheckInInfos\":[{\"checkID\":123,\"checkname\":\"rainkmc\",\"username\":\"testuser\",\"password\":\"password1\",\"checkinUrl\":\"checkinurl\",\"cookie\":\"1234567890\"},{\"checkID\":456,\"checkname\":\"rainkmc2\",\"username\":\"testuser2\",\"password\":\"password2\",\"checkinUrl\":\"checkinurl2\",\"cookie\":\"0123456789\"}]}\r\n";
		jsonStr = fu.readFile("checkininfos.json");
		//��תJsonObject
	    JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
	    //��תJsonArray ��������ͷ
	    JsonArray jsonArray = jsonObject.getAsJsonArray("CheckInInfos");

	    CheckInInfos = new ArrayList<CheckInInfo>();
		Gson gson = new Gson();
		
		//ѭ������
	    for (JsonElement user : jsonArray) {
	        //ͨ������ �õ�UserBean.class
	    	CheckInInfo checkInfo = gson.fromJson(user, new TypeToken<CheckInInfo>() {}.getType());
	    	CheckInInfos.add(checkInfo);
	    }
		//gson.
		return 1;
	}
	public ArrayList<CheckInInfo> getCheckInInfos() {
		return CheckInInfos;
	}
	public void print() {
		for (CheckInInfo i: CheckInInfos)
			i.print();
	}
}
