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
		int result = load();
		System.out.println("=====initInfo=====");
		print();
		System.out.println("=====End=====");
		return result;
	}
	public int load() {
		String jsonStr;
		FileUtils fu = new FileUtils();
		//jsonStr = "{\"CheckInInfos\":[{\"checkID\":123,\"checkname\":\"rainkmc\",\"username\":\"testuser\",\"password\":\"password1\",\"checkinUrl\":\"checkinurl\",\"cookie\":\"1234567890\"},{\"checkID\":456,\"checkname\":\"rainkmc2\",\"username\":\"testuser2\",\"password\":\"password2\",\"checkinUrl\":\"checkinurl2\",\"cookie\":\"0123456789\"}]}\r\n";
		jsonStr = fu.readFile("");
		//先转JsonObject
	    JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();
	    //再转JsonArray 加上数据头
	    JsonArray jsonArray = jsonObject.getAsJsonArray("CheckInInfos");

	    CheckInInfos = new  ArrayList<CheckInInfo>();
		Gson gson = new Gson();
		
		//循环遍历
	    for (JsonElement user : jsonArray) {
	        //通过反射 得到UserBean.class
	    	CheckInInfo checkInfo = gson.fromJson(user, new TypeToken<CheckInInfo>() {}.getType());
	    	CheckInInfos.add(checkInfo);
	    }
		//gson.
		return 1;
	}
	public void print() {
		CheckInInfos.get(0).print();
		CheckInInfos.get(1).print();
	}
}
