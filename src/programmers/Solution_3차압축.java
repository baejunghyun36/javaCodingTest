package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_3차압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String msg = "KAKAO"; 
		Map <String, Integer> map = new HashMap <>(); 
		int index = 1; 
		for(int i=0; i<26; i++) {
			char c = (char)('A'+ i); 
			//System.out.println(c);
			map.put(c+"", index++); 
		}
		int start = 0; 
		boolean isEmpty = true; 
		String s = msg.charAt(start)+"";
		String temp = ""; 
		int tempIndex = 0; 
		List <Integer> answer = new ArrayList<>();
		
		while(true) {			
			
			if(map.get(s)!=null) {
				temp += s.charAt(tempIndex++); 
				if(start==msg.length()-1)break; 
				s+=msg.charAt(++start); 
			}
			else {				
				map.put(s, index++); 
				answer.add(map.get(temp)); 
				s = msg.charAt(start)+"";
				temp = ""; 	
				tempIndex = 0; 
			}
						
			if(start ==msg.length()) break; 
			
		}
		if(temp!="") {
			System.out.println(map.get(temp));
			answer.add(map.get(temp)); 
		}
		System.out.println(answer);
		
		
		

	}

}
