package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {
	static int M,N; 
	static char [][] map; // , -1 장애물, -2 도착, 
	static Queue <int []> water; 
	static Queue <int []> animal; 
	static int [][] visited;
	static int [] dy = {0,0,-1,1}; 
	static int [] dx = {1,-1,0,0}; 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		visited = new int [M][N]; 
		map = new char [M][N];
		animal = new LinkedList<>(); 
		water = new LinkedList<>(); 
		for(int i=0; i<M; i++) {
			String s = br.readLine(); 
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] =='S') {
					animal.offer(new int [] {i,j});
					visited[i][j] = 1; 			
					map[i][j] = '.'; 
				}
				if(map[i][j] =='*') {
					water.offer(new int [] {i,j}); 
					visited[i][j] = 1; 					
				}
			}		
		}
	
		int answer = bfs(); 	
		if(answer!=0)sb.append(answer);
		else sb.append("KAKTUS"); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int bfs() {
		
		int moveCount=0; 
		
		while(!animal.isEmpty()) {
			
			int ws = water.size(); 

			while(0<ws--) {
								
				int [] yx = water.poll(); 
				
				for(int i=0; i<4; i++) {
					int ny = yx[0]+dy[i]; 
					int nx = yx[1]+dx[i]; 
					if(ny<0||ny>=M||nx<0||nx>=N||map[ny][nx]=='X'||map[ny][nx]=='D'||visited[ny][nx]==1)continue; 					
					visited[ny][nx] =1; 
					map[ny][nx] = '*'; 
					water.offer(new int [] {ny,nx}); 
				}
			}
			
			moveCount++; 			
			int as = animal.size(); 
			
			while(0<as--) {
				
				int [] yx = animal.poll(); 
		
				for(int i=0; i<4; i++) {
					
					int ny = yx[0]+dy[i]; 
					int nx = yx[1]+dx[i]; 
					if(ny<0||ny>=M||nx<0||nx>=N||map[ny][nx]=='X'||map[ny][nx]=='*'||visited[ny][nx]==1)continue; 
			
					if(map[ny][nx]=='D') {						
						return moveCount; 
					}								
					visited[ny][nx] = 1; 
					animal.offer(new int [] {ny,nx}); 
				}				
			}
		}
		
		return 0; 
		
	}
	
}
