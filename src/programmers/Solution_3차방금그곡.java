package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_3차방금그곡 {
	static int num; 
	static ArrayList <Music> musicList; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		num = 0; 
		String m = "CC#BCC#BCC#BCC#B"; 
		String mm = ""; 
		musicList = new ArrayList <>();  
		String	[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		for(int i=0; i<m.length(); i++) {
			if(m.charAt(i)=='#') {
				if(m.charAt(i-1)=='C')	mm+="c"; 
				else if(m.charAt(i-1)=='D')mm+="d"; 
				else if(m.charAt(i-1)=='F')mm+="f"; 		
				else if(m.charAt(i-1)=='G')mm+="g"; 
				else if(m.charAt(i-1)=='A')mm+="a"; 
				i++; 
			}
			else {
				
				mm+=m.charAt(i-1); 
				if(i==m.length()-1)mm+=m.charAt(i); 
			}
		}
		System.out.println("hihi : "+ mm);

		StringTokenizer st = null;  
		for(int i=0; i<musicinfos.length; i++) {	
			st = new StringTokenizer(musicinfos[i], ","); 
			String startTime = st.nextToken(); 
			int sh = Integer.parseInt(startTime.substring(0, 2)); // 시
			int sm = Integer.parseInt(startTime.substring(3, 5)); // 분
			sm = sm+ sh*60; 		
			String endTime = st.nextToken(); 
			int eh = Integer.parseInt(endTime.substring(0, 2));
			int em = Integer.parseInt(endTime.substring(3, 5));
			em = em + eh*60; 			
			
			String title = st.nextToken(); 
			String info = st.nextToken();
			
			int cnt = 0; 
			String x = ""; 
			
			for(int j=1; j<info.length(); j++) {
				if(info.charAt(i)=='#') {
					if(info.charAt(j-1)=='C')	x+="c"; 
					else if(info.charAt(j-1)=='D')x+="d"; 
					else if(info.charAt(j-1)=='F')x+="f"; 		
					else if(info.charAt(j-1)=='G')x+="g"; 
					else if(info.charAt(j-1)=='A')x+="a"; 
					j++; 
				}
				else {
					x+=info.charAt(j-1); 
					if(j==m.length()-1)x+=info.charAt(j); 
				}
			}
			
			String ss = ""; 
			int length = x.length(); 
			for(int j=0; j<(em-sm)/length; j++) {
				
				ss+=x;
				
			} 
			for(int j=0; j<(em-sm)%length; j++) {
				
				ss+=x.charAt(j);
				
			} 
			System.out.println(ss);
			//System.out.println(ss);
			
			Music music = new Music (em -sm, num++, title, ss); 
			musicList.add(music); 
			
		}
		ArrayList <Music> ans = new ArrayList<>(); 
		for(Music music : musicList) {
			String s = music.info; 
			if(s.contains(mm))ans.add(music); 
		}
		if(ans.size()==0) {
			System.out.println("none");
		}
		else {
			Collections.sort(ans);
			System.out.println(ans.get(0).title);
		}

				
	}
	
	static class Music implements Comparable<Music> {
		int time; 
		int number; 
		String title; 
		String info;
		
		@Override
		public int compareTo(Music o) {
			// TODO Auto-generated method stub
			if(o.time==this.time) {
				
				return this.number - o.number; 
			}
			
			return o.time-this.time;
		}

		public Music(int time, int number, String title, String info) {
			super();
			this.time = time;
			this.number = number;
			this.title = title;
			this.info = info;
		} 
		
		
	}

}
