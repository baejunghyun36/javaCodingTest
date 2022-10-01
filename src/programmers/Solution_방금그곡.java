package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_방금그곡 {
	static int num; 
	static ArrayList <Music> list; 
	public static void main(String[] args) {
		String m = "CC#BCC#BCC#BCC#B"; 
		String temp = ""; 
		num = 0; 
	  	for(int j =0; j<m.length()-1; j++) {
    		if(m.charAt(j+1)=='#') {
    			temp += (char)(m.charAt(j)+32); 
    			j++; 
    		}
    		else {
    			temp += m.charAt(j); 
    		}
    	}    
		if(m.charAt(m.length()-1)!='#')temp+=m.charAt(m.length()-1); 

		m = temp; 
		String[] musicinfos= 
			{"03:00,03:30,FOO,CC#B", 
				"04:00,04:08,BAR,CC#BCC#BCC#B"};
	
        String answer = "";
        StringTokenizer st = null; 
        
        list = new ArrayList<>(); 
        
        for(int i =0; i<musicinfos.length; i++  ){
            st = new StringTokenizer(musicinfos[i], ","); 
          	String s = st.nextToken(); 
        	String e  = st.nextToken(); 
        	String title = st.nextToken(); 
        	String info = st.nextToken();
        	
        	st = new StringTokenizer(s, ":"); 
        	int  sm =Integer.parseInt(st.nextToken())*60; 
        	sm+= Integer.parseInt(st.nextToken()); 
        	st = new StringTokenizer(e, ":"); 
        	int em = Integer.parseInt(st.nextToken())*60; 
        	em += Integer.parseInt(st.nextToken()); 
        	int time = em-sm; 
        	
        	String tempInfo  = ""; 
        	for(int j =0; j<info.length()-1; j++) {
        		if(info.charAt(j+1)=='#') {
        			tempInfo += (char)(info.charAt(j)+32); 
        			j++; 
        		}
        		else {
        			tempInfo += info.charAt(j); 
        		}
        	}        
        	if(info.charAt(info.length()-1)!='#')tempInfo+=info.charAt(info.length()-1); 
        	
        	int length = tempInfo.length(); 
        	int cnt = time/ length; // 몫
        	String tempString = ""; 
        	for(int j = 0; j<cnt; j++) {
        		tempString += tempInfo; 
        	}
        	cnt = time %length; 
        	tempString+= tempInfo.substring(0, cnt); 
        	
        	list.add(new Music(time, title, tempString, num++)); 
 
        }
        
        List <Music> result= new ArrayList<>(); 
        
        for(int i=0; i<list.size(); i++) {
        	Music mm = list.get(i); 
        	if(mm.info.contains(m)) {
        		result.add(mm); 
        	}
        	
        	System.out.println(m);
        	System.out.println( mm.title + " "+ mm.title + " "+ mm.info);
        }
        if(result.size()==0) {
        	System.out.println("(None)");
        }
        else {
            Collections.sort(result);
            System.out.println(result.get(0).title);
        }
        
    
        
        
	}
	static class Music implements Comparable<Music>{
		int time; 
		String title; 
		String info ;
		int number; 
		public Music(int time, String title, String info, int number) {
			super();
			this.time = time;
			this.title = title;
			this.info = info;
		}

		@Override
		public int compareTo(Music o) {
			// TODO Auto-generated method stub
			
			if(o.time==this.time) {
				return this.number - o.number; 
			}
			
			return o.time - this.time;
		} 
		
	}
    	      

}
