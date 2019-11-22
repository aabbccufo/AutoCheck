package pri.wfl.src;
import java.io.File;

import pri.wfl.obj.CheckInInfo;
import pri.wfl.src.InitParameter;
import pri.wfl.utils.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String testString;
		System.out.println("testworld");
		InitParameter parameter = new InitParameter();
		parameter.init();
		

		CheckUtils checkUtils = new CheckUtils();
		
//		checkUtils.test();
		
		for (CheckInInfo i : parameter.getCheckInInfos()) {
			checkUtils.checkIn(i);
		}
		
	}

}
