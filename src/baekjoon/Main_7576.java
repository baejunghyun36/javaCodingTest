package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {

	static int M, N; 
	static int [][] map; 
	static int [][] visited; 
	static Queue <int []> q; 
	static int [] dx = {0,0,-1,1}; 
	static int [] dy = {1,-1,0,0}; 
	static int totalRaw; 
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 

		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		q = new LinkedList<>(); 
		
		map = new int[M][N]; 
		visited = new int[M][N]; 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {	
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					visited[i][j] = 1; 
					q.offer(new int [] {i,j});					
				}
				if(map[i][j]==0)totalRaw++; 
			}
		}
		sb.append(bfs());		
		bw.write(sb.toString());		
		bw.flush();
		bw.close();
		br.close();
		
	}
	static int bfs() {
		int cnt =0; 
		while(!q.isEmpty()) {
			int size = q.size(); 
			cnt++; 
			while(0<size--) {			
				int [] yx = q.poll(); 	
				for(int i=0; i<4; i++) {
					int ny = yx[0]+dy[i]; 
					int nx = yx[1]+dx[i]; 
					if(ny<0||ny>=M||nx<0||nx>=N)continue; 
					if(map[ny][nx]==-1||visited[ny][nx]==1)continue; 
					
					totalRaw--; 
					visited[ny][nx] = 1; 
					map[ny][nx] = 1; 
					q.offer(new int [] {ny, nx}); 
				}
			}
		}
		if(totalRaw==0)return cnt-1; 
		return -1; 
	}
}
