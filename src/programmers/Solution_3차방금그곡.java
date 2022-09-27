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
		String m = "ABCDEFG"; 
		musicList = new ArrayList <>();  
		String	[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		
		StringTokenizer st = null;  
		for(int i=0; i<musicinfos.length; i++) {			
			String title = st.nextToken(); 
			String info = st.nextToken();
			int cnt = 0; 
			for(int j=0; j<info.length(); j++) {
				if(info.charAt(j)=='#')cnt++; 
			}
			
			String ss = ""; 
			int length = info.length(); 
			for(int j=0; j<(em-sm)/(length-cnt); j++) {
				
				ss+=info;
				
			} 
			for(int j=0; j<(em-sm)%(length-cnt); j++) {
				ss+=info.charAt(j);
				if(info.charAt(j+1)=='#') {
					ss+=info.charAt(j); 
					j++; 
				}
				
			} 
			
			//System.out.println(ss);
			
			Music music = new Music (em -sm, num++, title, ss); 
			musicList.add(music); 
			
		}
		ArrayList <Music> ans = new ArrayList<>(); 
		for(Music music : musicList) {
			String s = music.info; 
			if(s.contains(m))ans.add(music); 
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
