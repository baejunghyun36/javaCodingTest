package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

public class Solution_메뉴리뉴얼 {

	static Map <String, Integer> m; 
	static int maxNumber; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] orders = {"ABCFG", "AC", "CDE", "BCFG","ACDE",  "ACDEH"}; 
		int[] course = {2,3,4}; 
		System.out.println(Arrays.toString(orders));		
		for(int i=0; i<orders.length; i++) {
			char[] s = orders[i].toCharArray(); 
			Arrays.sort(s);
			String ss = new String(s); 
			orders[i] = ss; 			
		}
		
		Arrays.sort(orders, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				return 1; 
			}			
		});
		
		
		
		Arrays.sort(orders, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return -1;  
				}
				return s1.length() - s2.length(); 
			}
		});
		
		List <String> list = new ArrayList<>(); 
		
		for(int i=0; i<course.length; i++) {
			m = new HashMap<>(); 
			maxNumber = 0; 
			int courseCnt = course[i]; 
			for(int j=0;j<orders.length; j++) {
				char [] temp = new char[courseCnt]; 
				comb(orders[j], 0, 0, courseCnt, temp); 
			}
		
			for(String key : m.keySet() ){
				
				if(maxNumber==m.get(key)) {
					list.add(key); 
				}
			}
			
		}
		Collections.sort(list);
		String [] answer = new String [list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i); 
		}
		System.out.println(Arrays.toString(answer));
	}
	
	static void comb(String s, int start, int cnt, int complete, char[] temp) {
		
		if(complete==cnt) {
			System.out.println(complete + " "+ cnt);
			StringBuilder sb = new StringBuilder(); 
			for(int i=0; i<temp.length; i++) {
				sb.append(temp[i]); 
			}
			
			m.put(sb.toString(), m.getOrDefault(sb.toString(), 0) + 1);
			if(maxNumber<m.get(sb.toString()))maxNumber= m.get(sb.toString()); 
		
			return; 
		}
	
		for(int i=start; i<s.length(); i++) {			
			temp[cnt] = s.charAt(i); 			
			comb(s, i+1, cnt+1, complete, temp); 			
		}
	}


}
