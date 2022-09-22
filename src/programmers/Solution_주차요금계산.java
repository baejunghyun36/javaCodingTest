package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_주차요금계산 {
	   static Map <String, Integer> fee; 
	   static Map <String, Integer> map; 
	   static ArrayList <Integer> list; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] fees = {180, 5000, 10, 600}; 
		String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", 
				"19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}; 
	
	    fee = new HashMap<>(); 
	    map = new HashMap<>(); 
	    list = new ArrayList<>(); 
	    for(int i=0; i<records.length; i++) {
	    	String []record = records[i].split(" "); 
	    	int h = Integer.parseInt(record[0].substring(0,2)); 
	    	int m = Integer.parseInt(record[0].substring(3,5)); 
	    	String number = record[1]; 
	    	int time = h*60+m; 
	    	if(record[2].equals("IN")) {
	    		fee.put(number, time); 
	    	}
	    	else {
	    		time = time - fee.get(number); 	       
	    		time = time-fees[0]; 
	    		int cost = 0; 
	    		if(time<0)cost = fees[1]; 
	    		else {
	    			int x = time/fees[2]; 
	    			int y = time%fees[2]; 
	    			cost+=x*fees[3]; 
	    			if(y!=0)cost+=fees[3]; 
	    		}	        
	     		fee.remove(number); 
	    		map.put(number, map.getOrDefault(number, 0)+cost); 	        		
	    	}
	    }
	    for(String key : fee.keySet()) {
	    	int time = 23*60+59; 	    
	    	time = time-fees[0]; 
			int cost = 0; 
			if(time<0)cost = fees[1]; 
			else {
				int x = time/fees[2]; 
				int y = time%fees[2]; 
				cost+=x*fees[3]; 
				if(y!=0)cost+=fees[3]; 
			}	            
			map.put(key, map.get(key)+cost); 	  	        	
	    }
	    for(String key : map.keySet()) {
	    	list.add(map.get(key)); 
	    }
	    
	    int[] answer = new int[list.size()];
	
	    for(int i=0; i<list.size(); i++) {
	    	answer[i] = list.get(i); 
	    }
	    System.out.println(Arrays.toString(answer));
	}
}

