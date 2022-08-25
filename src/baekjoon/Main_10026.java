package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10026 {

	static char [][]map; 
	static int N; 
	static int [] dx = {0,0,-1,1}; 
	static int [] dy = {1,-1,0,0}; 
	static int [][] visited; 
	static Queue <int []> q ; 
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder(); 
		N = Integer.parseInt(st.nextToken()); 
		map = new char [N][N] ; 
		for(int i=0; i<N; i++) {
			String s= br.readLine(); 			
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j); 
			}
		}
		visited = new int[N][N]; 
		int cnt =0; 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]==0) {
					cnt++; 
					q = new LinkedList<>(); 
					q.offer(new int [] {i,j}); 
					visited[i][j] = 1; 
					bfs(map[i][j]); 
				}
			}
		}
		sb.append(cnt).append(" "); 

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] =='G')map[i][j] = 'R'; 
			}
		}
		cnt =0; 
		visited = new int [N][N]; 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visited[i][j]==0) {
					cnt++; 
					q = new LinkedList<>(); 
					q.offer(new int [] {i,j}); 
					visited[i][j] = 1; 
					bfs(map[i][j]); 
				}
			}
		}	
		sb.append(cnt); 
		System.out.println(sb.toString());
		
	}
	
	static void bfs(char c) {
		

		while(!q.isEmpty()) {
			
			int [] yx = q.poll(); 
			
			
			for(int i=0; i<4; i++) {
				int ny = dy[i] + yx[0]; 
				int nx = dx[i] + yx[1]; 
				
				if(ny<0||ny>=N||nx<0||nx>=N)continue; 
				if(visited[ny][nx]==1||map[ny][nx]!=c)continue; 
				
				
				visited[ny][nx] = 1; 
				q.offer(new int [] {ny, nx}); 
			}
		}
	}

}
