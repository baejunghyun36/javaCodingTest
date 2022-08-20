package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.List;
import java.util.StringTokenizer;

public class Main_17135 {
	static int m, n; 
	static int dis;
	static int [][]map; 
	static List <int []> enemy; 
	static int result; 

	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuffer sb = new StringBuffer(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		m = Integer.parseInt(st.nextToken()); 
		n = Integer.parseInt(st.nextToken()); 
		dis = Integer.parseInt(st.nextToken()); 
		map = new int [m+1][n];
		enemy = new ArrayList<>(); 
		result = 0; 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<n; j++) {		
				map[i][j]= Integer.parseInt(st.nextToken()); 
				if(map[i][j]==1) {				
					enemy.add(new int [] {i, j}); 				
				}				
			}
		}	
		comb(0, 0); 
		System.out.println(result);
	}
	
	
	static void comb(int cnt, int start) {
		
		if(cnt==3) {
		    List <int []> army = new ArrayList<>(); 
			for(int i =0; i<n; i++) {
				if(map[m][i]==2)army.add(new int [] {m, i}); 
			}
	
			int [][]mmap = new int [m+1][n]; 
			for(int i=0; i<m+1; i++) {
				mmap[i] = map[i].clone(); 
			}
			
			attack(army, mmap); 			
			return; 
		}
		
		for(int i=start; i<n; i++) {
			
			map[m][i]=2; 
			comb(cnt+1, i+1); 
			map[m][i]=0; 			
		}
	}

	static void attack(List<int[]>army, int [][]mmap){
		
		int level = m-1; 
		int cnt = 0; 
		List <int []> removeEnemy = new ArrayList<>(); 
		while(level>=0) {	
			for(int i=0; i<3; i++) {
		
				int ay = army.get(i)[0];
				int ax = army.get(i)[1]; 
				
				out:for(int d = 1; d<=dis; d++) {	
					
					int offset = d-1; 			
					for(int y = ay-1; y>=ay-d; y--) {
						
						int x = ax-offset; 			
						
						if(y<0||y>level||x<0||x>=n) {
							offset--; 						
							continue; 							
						}			
				
						if(mmap[y][x]==1) {					 
							removeEnemy.add(new int [] {y,x}); 						
							break out; 
						}
						offset--; 
					}
					offset+=2; 
					
					for(int y = ay-d+1; y<=ay-1;  y++) {
						int x = ax+offset; 			
						if(y<0||y>level||x<0||x>=n) {
							offset++; 
							continue;							
						}
						if(mmap[y][ax+offset]==1) {
							removeEnemy.add(new int [] {y,x}); 
							break out; 			
						}
						offset++; 
					}
				}
			}			
			
			for(int i =0; i<removeEnemy.size(); i++) {
				int y= removeEnemy.get(i)[0]; 
				int x = removeEnemy.get(i)[1]; 			
				if(mmap[y][x]==1) {
					cnt++; 
					mmap[y][x] =0; 
				}
			}
			result = Math.max(cnt, result); 			
			for(int i=0; i<3; i++)army.get(i)[0] = level; 
			level--; 			
		}		
	}	
}
