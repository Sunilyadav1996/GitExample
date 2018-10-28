package projectClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class JsonObject {
	public static String getJsonString(Map<String,String> map) {
		Set<String> keys = map.keySet();
		Iterator<String> i = keys.iterator();
		String str = "{";
		int count =0;
		while(i.hasNext()) {
			String key = i.next();
			if(count++<keys.size()-1) {
				str += "\""+key+"\":\""+map.get(key)+"\",";	
			}else {
				str += "\""+key+"\":\""+map.get(key)+"\"";	
		}
		str += "}";
		}
		return str;
	}	
	public static String getJsonString(ArrayList<String> l) {
		return "";
	}
	
	public static String getJsonString(String str) {
		
		return "";
	}
	
}
