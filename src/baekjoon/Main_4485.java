package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4485 {

	static int n; 
	static int [][] map; 
	static int [][] dis; 
	static int [] dx = {0,0,1,-1}; 
	static int [] dy = {1,-1,0,0}; 
	static Queue<int []>q; 
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in); 
		int t = 1; 
		while(true) {
		
			n = sc.nextInt(); 
			if(n==0)break; 
			map = new int [n][n]; 
			dis = new int [n][n]; 
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.nextInt(); 
					dis[i][j] = 987654321; 
				}
			}
			q = new LinkedList<>(); 
			dis[0][0] = map[0][0]; 
			q.add(new int [] {0,0}); 
			bfs(); 
			System.out.println("Problem "+t+++": "+dis[n-1][n-1]);
		}		
		
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			
			int [] yx = q.poll(); 
			int y = yx[0]; 
			int x = yx[1]; 
			
			for(int i=0; i<4; i++) {
				int nx = dx[i]+x; 
				int ny = dy[i]+y; 
				
				if(ny<0||ny>=n||nx<0||nx>=n)continue; 
				if(map[ny][nx]+dis[y][x]<dis[ny][nx]) {
				    dis[ny][nx] = map[ny][nx]+dis[y][x]; 
				    q.offer(new int [] {ny, nx}); 
				}
			}
		}
	}

}
