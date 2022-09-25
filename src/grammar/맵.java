package grammar;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class 맵 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map <String, String> map = new HashMap<>(); 
		
		map.put("배정현", "27살이다"); 
		map.put("고태진", "26살이다"); 
		map.put("안영훈", "28살이다"); 
		
		System.out.println(map.get("배정현"));
		
		map.replace("배정현", "내년이면 28살이다"); 

		System.out.println(map.get("배정현"));
		
		
		for(String key : map.keySet()) {
			System.out.println("[key] : "+ key + " [Value] : "+map.get(key));
		}
		System.out.println();
		for(Entry<String, String> entry : map.entrySet()) {
			System.out.println("[key] : "+ entry.getKey() + " [Value] : "+entry.getValue());
		}
		
		System.out.println();
		map.remove("배정현"); 
		for(Entry<String, String> entry : map.entrySet()) {
			System.out.println("[key] : "+ entry.getKey() + " [Value] : "+entry.getValue());
		}
		
	}

}
