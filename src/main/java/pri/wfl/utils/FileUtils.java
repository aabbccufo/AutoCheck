package pri.wfl.utils;

import java.io.*;

import com.google.gson.*;

public class FileUtils {
	public void readJson() {
		
		Gson gson = new Gson();
	}
	public void readJsonArray() {
		JsonArray jsonArray = new JsonArray();
	}
	public String readFile(String filePath) {
		File file;
		if ( filePath.isEmpty() || filePath==null )
			file = new File("checkininfos.json");
		else
			file = new File(filePath);
		String fileString = "";
		
		InputStreamReader read;
		try {
			read = new InputStreamReader( new FileInputStream(file),"UTF-8" );
			// ���ǵ������ʽ
	        BufferedReader bufferedReader = new BufferedReader(read);
	        String lineTxt = null;
	
	        while ((lineTxt = bufferedReader.readLine()) != null)
	        {
	            fileString = fileString + lineTxt;
	        }
	        bufferedReader.close();
	        read.close();
	        
	        
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fileString;
	}
}
