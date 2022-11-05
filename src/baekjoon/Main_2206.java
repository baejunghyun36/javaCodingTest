package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {

	static int M, N; 
	static int [][] map; 
	static int [][][] visited; 
	static Queue <int []> q; 
	static int [] dx = {0,0,-1,1}; 
	static int [] dy = {-1,1,0,0}; 
	static int result; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		map = new int [M][N]; 
		q = new LinkedList<>(); 
		result = 987654321 ;
		visited = new int[M][N][2]; 
		for(int i=0; i<M; i++) {
			String s = br.readLine(); 
			for(int j=0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';		
			}
		}
		
		q = new LinkedList<>(); 
		q.add(new int[] {0,0,1,1}); 
		visited[0][0][1] = 1; 
		bfs(); 
		
		if(result == 987654321) result = -1; 
		System.out.println(result);
		
	}
	static void bfs() {
	
		while(!q.isEmpty()) {
			int []yx = q.poll();
			int y = yx[0]; 
			int x = yx[1]; 
			int possible = yx[2]; //1이면 벽 부술수 있어 
			int dis = yx[3]; 
			if(y==M-1&&x==N-1) {
				result = dis; 
				return; 
			}				
			for(int i=0; i<4; i++) {
				int nx = dx[i]+x; 
				int ny = dy[i]+y; 
				if(ny<0||ny>=M||nx<0||nx>=N)continue; 
				if(map[ny][nx]==1&& possible==0)continue;				
				if(map[ny][nx]==1 && possible==1) {
					q.add(new int[] {ny, nx, 0, dis+1});
					visited[ny][nx][0] = 1; 
				}
				else if(map[ny][nx]==0&&visited[ny][nx][possible]==0) {
					q.add(new int [] {ny, nx, possible, dis+1});
					visited[ny][nx][possible] = 1;	
				}			
			}
		}
	}
}
