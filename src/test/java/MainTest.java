import pri.wfl.src.InitParameter;
import pri.wfl.utils.*;

public class MainTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String testString;
		System.out.println("testworld");
		InitParameter init = new InitParameter();
		init.init();
		
		CheckUtils checkUtils = new CheckUtils();
		checkUtils.test();
	}

}
