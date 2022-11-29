package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_5648_swAbility {
	static int [] dx = {0,0,-1,1}; 
	static int [] dy = {1,-1,0,0}; 
	static int testCase; 
	static int N; 
	static List <Atomic> atomicList; 
	static Map <Integer[], List<Integer>> map;  
	static int result; 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		testCase = Integer.parseInt(st.nextToken()); 
		for(int t = 1; t<=testCase; t++) {
			result = 0; 
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); 
			atomicList = new LinkedList<>(); 
			int number = 0; 
			for(int i=0; i<N; i++) {
				st =new StringTokenizer(br.readLine()); 

				int x = Integer.parseInt(st.nextToken())*2;
				int y = Integer.parseInt(st.nextToken())*2;
				int dir = Integer.parseInt(st.nextToken());
				int energy = Integer.parseInt(st.nextToken());
				atomicList.add(new Atomic(x,y,dir,energy, number)); 
			
			}
				
			moveAtomic(); 
			sb.append("#").append(t).append(" ").append(result).append("\n"); 
		}		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static void moveAtomic() {
		
		while(!atomicList.isEmpty()) {
			List <Atomic> list = new LinkedList<>(); 
			for(int i=0; i<atomicList.size(); i++) {
				
				Atomic a = atomicList.get(i); 
				int x = a.x + dx[a.dir]; 
				int y = a.y + dy[a.dir]; 
				a.x = x; 
				a.y = y; 
				a.number = i; 				
				if(a.y<-2000||a.y>2000||a.x<-2000||a.x>2000) {
				
					atomicList.remove(i);
					i--; 
					continue; 
					
				} 
				list.add(a); 	
			}
			Collections.sort(list);
	
			int sum =0; 
			boolean flag = false; 
			for(int i=0; i<list.size()-1; i++) {	
				Atomic a1 = list.get(i); 
				Atomic a2 = list.get(i+1); 
				if(a1.y==a2.y&&a1.x==a2.x) {
					flag = true; 
					sum+=a1.energy; 
					if(i+1==list.size()-1) {
						sum+=a2.energy; 
						list.remove(i+1);						
					}
					list.remove(i); 
					i--; 
			
			
				}
				else {
					if(flag==true) {
						sum+=a1.energy; 
						list.remove(i); 					
						i--; 
					}
					flag = false; 
				}
		
			}
			
			
			result+=sum; 
			atomicList = list; 			
		}		
	}
	
	
	static class Atomic implements Comparable<Atomic> {
		int x; 
		int y; 
		int dir; 
		int energy; 
		int number; 
		
		public Atomic(int x, int y, int dir, int energy, int number) {
			
			this.x = x; 
			this.y = y; 
			this.dir = dir; 
			this.energy = energy; 	
			this.number = number; 
			
		}

		@Override
		public int compareTo(Atomic o) {
			if(this.y==o.y)return this.x-o.x; 
			return this.y - o.y; 
		}

	
	}

}
