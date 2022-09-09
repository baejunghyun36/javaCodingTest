package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_문자열압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abcdefgabcdefg"; 
	
		int minNumber = s.length(); 
		for(int fixLength = 1; fixLength<= s.length()/2; fixLength++) {
			Map <String, Integer> map = new HashMap <>(); 
			String [] subStringArray = s.split("(?<=\\G.{" + fixLength+ "})"); 
			System.out.println(Arrays.toString(subStringArray));
			int sum = 0; 
			StringBuilder sb = new StringBuilder(); 
			for(int i=0; i<subStringArray.length; i++) {		
				
				String ss= subStringArray[i]; 
				if(map.containsKey(ss))map.put(ss, map.get(ss)+1); 
				else {
					for(String key : map.keySet()) {
						if(map.get(key)>1) {sb.append(map.get(key)).append(key);}
						else sb.append(key); 
					}
					map.clear();
					map.put(ss, 1); 
				}	
			}
			for(String key : map.keySet()) {
				if(map.get(key)>1) {sb.append(map.get(key)).append(key);}
				else sb.append(key); 
			}
			System.out.println(sb.toString());
			minNumber = Math.min(minNumber, sb.length()); 
		}
		System.out.println(minNumber);
	}
}
