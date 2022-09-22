package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_주차요금계산 {
	   static Map <String, Integer> fee; 
	   static Map <String, Integer> map; 
	   static ArrayList <Integer> list; 
	   static Set <String> set; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] fees = {180, 5000, 10, 600}; 
		String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", 
				"19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}; 
	
	    fee = new HashMap<>(); 
	    map = new HashMap<>(); 
	    set = new HashSet<>(); 
	    list = new ArrayList<>(); 
	    for(int i=0; i<records.length; i++) {
	    	String []record = records[i].split(" "); 
	    	int h = Integer.parseInt(record[0].substring(0,2)); 
	    	int m = Integer.parseInt(record[0].substring(3,5)); 
	    	String number = record[1]; 
	    	set.add(number); 
	    	int time = h*60+m; 
	    	if(record[2].equals("IN")) {
	    	//	System.out.println(number +" "+ time);
	    		fee.put(number, time); 
	    	}
	    	else {
	    		time = time - fee.get(number); 	  	        
	     		fee.remove(number); 
	    		map.put(number, map.getOrDefault(number, 0)+time); 	 
	    		System.out.println(number +" " + map.get(number));
	    	}
	    }
	    for(String key : fee.keySet()) {
	    	int time = 23*60+59; 
	    	time = time - fee.get(key); 	  	        
     		fee.remove(key); 
    		map.put(key, map.getOrDefault(key, 0)+time); 	  
	    }
	    List <String >num = new ArrayList(set); 
	    Collections.sort(num);
	    for(String key : num) {
	    	int time = map.get(key);  
	    	System.out.println("시간" + time);
	    	time = time-fees[0]; 
			int cost = 0; 
			if(time<0)cost = fees[1]; 
			else {
				cost = fees[1]; 
				int x = time/fees[2]; 
				int y = time%fees[2]; 
				cost+=x*fees[3]; 
				if(y!=0)cost+=fees[3]; 
			}	            
			list.add(cost); 
	 	        	
	    }
	    int[] answer = new int[list.size()];
	    
	    for(int i=0; i<list.size(); i++) {
	    	answer[i] = list.get(i); 
	    }
	    System.out.println(Arrays.toString(answer));
	}
}

