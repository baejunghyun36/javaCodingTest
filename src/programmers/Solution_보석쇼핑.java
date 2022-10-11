package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_보석쇼핑 {
	
	static Map <String, Integer> map; 
	static int start, end; 
	static Set <String> set; 
	public static void main(String[] args) {
	
		map = new HashMap<>(); 
		set = new HashSet<>(); 
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}; 
		
		for(int i=0; i<gems.length; i++) set.add(gems[i]); 
	
		start = 0; 
		end = 0; 
		int [] answer = new int [2]; 
		
		int minNumber = Integer.MAX_VALUE; 
		while(true) {
		
			while(start<gems.length) {
				map.put(gems[start], map.getOrDefault(gems[start], 0)+1);
				if(map.size()==set.size())break; 
				start ++; 
			}
            if(start>=gems.length)break; 
			while(end<=start) {
				map.put(gems[end], map.getOrDefault(gems[end], 0)-1); 
				if(map.get(gems[end])==0) {
					map.remove(gems[end]);
					if(minNumber > start - end +1 ) {
						answer[1] = start+1; 
						answer[0] = end+1;
						minNumber = Math.min(minNumber, start - end +1 ); 
					}
					break; 
				}				
				end++; 
			}			
			start++; 
			end++; 

		}
		
		System.out.println(Arrays.toString(answer));
	}

}
