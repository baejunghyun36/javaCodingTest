package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234 {

	static int N, L, R; 
	static Queue <Update> updateList; 
	static Queue <int []> q; 
	static int [][] visited; 
	static int [][] map; 
	static int [] dx = {0,0,1,-1}; 
	static int [] dy = {1,-1,0,0}; 
	static int result; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder(); 
		
		N = Integer.parseInt(st.nextToken()); 
		L = Integer.parseInt(st.nextToken()); 
		R = Integer.parseInt(st.nextToken()); 
		
		map = new int [N][N]; 
		visited = new int [N][N]; 
		q = new LinkedList<>(); 
		updateList = new LinkedList<>(); 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		while(true) {
			
			boolean flag = false;
			for(int i=0; i< N; i++)Arrays.fill(visited[i], 0);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]==0) {
						q.add(new int[] {i,j}); 
						updateList.add(new Update(i,j)); 
						visited[i][j] = 1; 
						if(bfs(map[i][j])) flag = true;
					}
				}
			}
			if(flag == false) break; 
			else result ++; 
		}
		System.out.println(result);
	}
	static boolean bfs(int sum) {
	
		while(!q.isEmpty()) {
			int yx[] = q.poll(); 
			int y = yx[0]; 
			int x = yx[1]; 
			for(int i=0; i<4; i++) {
				int nx = x + dx[i]; 
				int ny = y + dy[i]; 
				if(nx<0||nx>=N||ny<0||ny>=N)continue; 
				if(visited[ny][nx] == 1)continue; 
				int dif = Math.abs(map[ny][nx]-map[y][x]); 
				if(dif<L||dif>R)continue; 
				visited[ny][nx] = 1; 
				q.add(new int [] {ny,nx}); 
				 
				sum+=map[ny][nx]; 
				updateList.add(new Update(ny,nx)); 
			}
			
		}
		if(updateList.size()==1) {
			updateList.poll(); 
			return false; 
		}
		else {
			int updateValue = sum / updateList.size(); 
			while(!updateList.isEmpty()) {
				Update u = updateList.poll(); 
				map[u.y][u.x] = updateValue; 
			}
		}
		return true; 
	}
	
	
	static class Update {
		
		int y; 
		int x; 
		
		public Update(int y, int x) {
			this.y = y; 
			this.x = x; 
			
		}
		
		
	}

}
