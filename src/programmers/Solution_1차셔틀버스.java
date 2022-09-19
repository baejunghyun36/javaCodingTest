package programmers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution_1차셔틀버스 {

	static int N,T,M; 
	static String[] timeTable;
	static List<Person> person; 
	static int busH, busM; 
	static List<Bus> bus; 
	static StringBuilder sb; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1; 
		int t = 1; 
		int m = 5; 
		person = new LinkedList<>(); 
		bus = new LinkedList<>(); 
		timeTable = new String[]{"08:00", "08:01", "08:02", "08:03"}; 
		N = n; //셔틀 운행 횟수
		T = t; //셔틀 운행 간격
		M = m; //최대 크루 수 
		busH = 9; 
		busM = 0; 
		
		for(int i=0; i<N; i++) {
			bus.add(new Bus(busH, busM)); 
			busM+=t; 
			if(busM>60) {
				busH++; 
				busM = busM-60; 
			}
		}
		
		for(int i=0; i<timeTable.length; i++) {
			String s = timeTable[i]; 
			int hh = Integer.parseInt(s.substring(0, 2)); 
			int mm = Integer.parseInt(s.substring(3, 5));
			person.add(new Person(hh, mm)); 
		}
		Collections.sort(person);
		for(int i=0; i<person.size(); i++) {
			System.out.println(person.get(i).h+" "+person.get(i).m);
		}
		for(int i=0; i<bus.size(); i++) {
			System.out.println(bus.get(i).h +" "+ bus.get(i).m);
		}
		
		sb= new StringBuilder(); 
		
		for(int i=0; i<bus.size(); i++) {
			int cnt = 0; 
		
			while(true && person.size()>0) {
				if(person.get(0).h>bus.get(i).h)break; 
				if(person.get(0).h == bus.get(i).h && person.get(0).m >bus.get(i).m)break; 
				
				if(i==bus.size()-1&&cnt==M-1) {
					timeCal(0, 1);
				}
				person.remove(0); 
				cnt++; 
				if(cnt==M)break; 
			}
			if(i==bus.size()-1&&person.size()==0) {
				timeCal(i, 0); 
			}
			
		}
		System.out.println(sb.toString());
	}
	
	static void timeCal(int i, int who) {
		int hh=0;  
		int mm=0; 
		if(who ==0) {
			hh = bus.get(i).h; 
			mm = bus.get(i).m; 
		}
		else{
			hh = person.get(0).h; 
			mm = person.get(0).m; 
			mm--; 
		}

	
		if(mm<0) {
			hh--; 
			mm = 59; 
		}
		if(hh<10)sb.append(0); 
		sb.append(hh).append(":");
		if(mm<10)sb.append(0); 
		sb.append(mm); 
	}
	
	
	
	static class Bus{
		int h; 
		int m;
		
		public Bus(int h, int m) {
			super();
			this.h = h;
			this.m = m;
		} 
		
	}

	static class Person implements Comparable<Person>{
		
		int h; 
		int m;
		
		public Person(int h, int m) {
			super();
			this.h = h;
			this.m = m;
		}

		@Override
		public int compareTo(Person o) {
			// TODO Auto-generated method stub
			if(this.h ==o.h) {
				return this.m - o.m; 
			}
			return this.h - o.h; 
		}
	}
}
