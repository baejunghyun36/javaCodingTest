package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638 {
	static int M,N; 
	static int [] dx = {0,0,1,-1}; 
	static int [] dy = {1,-1,0,0}; 
	static Queue <int []> q; 
	static int [][] map; 
	static int [][] visited; 
	static int [][] weight; 
	static int airY,airX; 
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		q = new LinkedList<>(); 
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		map = new int[M][N]; 
		boolean flag = true; 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(flag&&(i==0||i==M-1||j==0||j==N-1)) {
					if(map[i][j] == 0) {
						airY = i; 
						airX = j;
						flag = false; 
					}
				}
			}
		}
		
		int second = 0; 
		while(second>=0) {
			visited = new int[M][N]; 
			weight = new int[M][N]; 		
			q.add(new int[] {airY, airX}); 	
			visited[airY][airX] = 1; 
			if(bfs())break; 			
			second++; 
		}
		sb.append(second); 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void updateMap () {
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(weight[i][j] >=2) {
					map[i][j] = 0; 
				}
			}
		}
	}
	
	static boolean bfs() {
		boolean check = true; 
		while(!q.isEmpty()) {
			int [] yx = q.poll(); 
			int y = yx[0]; 
			int x = yx[1]; 
			for(int i=0; i<4; i++) {
				int nx = x+dx[i]; 
				int ny = y+dy[i]; 
				if(ny<0||ny>=M||nx<0||nx>=N)continue; 
				if(visited[ny][nx]==1)continue;
				if(map[ny][nx]==1) {
					check = false; 
					weight[ny][nx]++;
					continue; 
				}								
				visited[ny][nx] = 1; 
				q.add(new int[] {ny,nx}); 
			}
		}
		updateMap(); 
		return check; 
	}
}
