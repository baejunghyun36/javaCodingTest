package swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1249 {

	static int testCase; 
	static int N; 
	static int [][] map; 
	static int [] dx = {0,0,1,-1}; 
	static int [] dy = {1, -1, 0,0}; 
	static Queue <int []> q; 
	static int [][] dis;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		testCase = Integer.parseInt(br.readLine()); 
		StringBuilder sb = new StringBuilder(); 
		for(int t = 1; t<=testCase; t++) {
			
			N = Integer.parseInt(br.readLine()); 
			map = new int [N][N]; 
			dis = new int [N][N]; 
			q = new LinkedList<>(); 
			for(int i=0; i<N; i++) {
				Arrays.fill(dis[i], 987654321);
				String s = br.readLine(); 
				for(int j=0; j<s.length(); j++) {
					map[i][j] = s.charAt(j)-'0'; 
				}
			}
			dis[0][0] = 0; 
			q.add(new int [] {0,0});
			bfs(); 
			sb.append("#").append(t).append(" ").append(dis[N-1][N-1]).append("\n"); 
		}
		System.out.println(sb.toString());
		
	}
	static void bfs() {
		
		while(!q.isEmpty()) {
			
			int []yx = q.poll(); 
			int y = yx[0]; 
			int x = yx[1]; 
			
			for(int i=0; i<4; i++) {
				int nx = x+dx[i]; 
				int ny = y+dy[i]; 				
				if(ny<0||ny>=N||nx<0||nx>=N)continue; 
				if(dis[ny][nx]>dis[y][x]+map[ny][nx]) {
					dis[ny][nx] = dis[y][x]+map[ny][nx]; 
					q.add(new int[] {ny,nx}); 
				}
			}
		}

	}

}
