package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 {

	static int M; 
	static int N; 
	static int [][] map; 
	static int callCnt; 
	static Queue <int[]> q; 
	static int [] dx = {0,0,-1,1}; 
	static int [] dy = {1,-1,0,0}; 
	static int lastErase; 
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
	
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		map = new int[M][N]; 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++)	{
				map[i][j] = Integer.parseInt(st.nextToken()); 				
			}
		}
		q = new LinkedList<>(); 
		
		while(true) {			
			//가장 바깥쪽 0 하나 집어넣고 bfs 돌린다. 			
			q.add(new int [] {0,0}); 
			callCnt++; 
			if(!bfs()) break;  			
		}
		StringBuilder sb = new StringBuilder(); 
		sb.append(callCnt-1).append("\n").append(lastErase); 
		System.out.println(sb.toString());	
		
	}
	static boolean bfs(){
		int [][] visited = new int [M][N]; 
		visited[0][0] = 1; 
		ArrayList <int []> eraseList = new ArrayList<>(); 
		while(!q.isEmpty()) {
			int [] yx = q.poll(); 
			int y = yx[0]; 
			int x = yx[1] ; 
			for(int i=0; i<4; i++) {
				int nx = x + dx[i]; 
				int ny = y + dy[i]; 
				if(ny<0||ny>=M||nx<0||nx>=N)continue; 
				if(visited[ny][nx] == 1) continue; 		
				if(map[ny][nx]==1) {
					eraseList.add(new int [] {ny, nx}); 
					continue; 
				}
				visited[ny][nx] = 1; 
				q.add(new int [] {ny,nx}); 				
			}			
		}		
		if(erase(eraseList))return true ; 		
		return false;  
	}
	
	static boolean erase(ArrayList <int[]> eraseList) {
		int cnt = 0; 
		for(int[] yx : eraseList) {
			int y = yx[0]; 
			int x = yx[1]; 
			if(map[y][x]==0)continue; 
			cnt++; 
			map[y][x] = 0; 
		}
		if(cnt==0)return false; // 지운적 없어 
		lastErase = cnt ; //마지막으로 지운 개수가 남은거. 
		return true; 		
	}	
}
