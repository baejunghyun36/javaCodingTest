package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1600 {
	

	static int K; 
	static int M, N;
	static int [][]	map; 
	static int [][] dis; 
	static int [] h_dy = {-2, -1, 1, 2, 2, 1, -1, -2}; 
	static int [] h_dx = {1, 2, 2, 1, -1, -2, -2, -1}; 
	static int [] dy = {0, 0, 1,-1}; 
	static int [] dx = {1,-1, 0, 0}; 
	static Queue <int[]> q; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in); 
		
		K = sc.nextInt(); 
		N = sc.nextInt(); 
		M = sc.nextInt(); 
		
		map = new int[M][N]; 
		dis = new int[M][N]; 
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt(); 
			}
		}
		for(int i=0; i<M; i++) Arrays.fill(dis[i], 987654321);
		dis[0][0] = 0; 
		q = new LinkedList<>(); 
		q.add(new int [] {K, 0, 0});

		bfs(); 
		if(dis[M-1][N-1]==987654321)System.out.println(-1);
		else System.out.println(dis[M-1][N-1]);
//		for(int i=0; i<M; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(dis[i][j]+" ");
//			}System.out.println();
//		}
	}
	
	static void bfs () {
		int k = 0; 
		int y = 0; 
		int x = 0; 
		int ny = 0; 
		int nx = 0; 
		int [] info = new int[3]; 
		int cnt = 0; 
		while(!q.isEmpty()) {
	
			cnt++; 
			info = q.poll(); 
			x = info[2]; 
			y = info[1]; 
			if(y==N-1&&x==N-1)break; 
				
			if(info[0]==0) {
 
				for(int i=0; i<4; i++) {
					nx = dx[i]+x ;
					ny = dy[i]+y ;
					if(ny<0||ny>=M||nx<0||nx>=N)continue;
					if(map[ny][nx]==1)continue; 
					if(dis[ny][nx]<dis[y][x]+1)continue; 
					dis[ny][nx] = dis[y][x]+1; 
					q.offer(new int[] {0, ny, nx}); 				 
				}
			}
			
			else {					
			    k = info[0]; 	
				x = info[2]; 
				y = info[1]; 
				for(int i=0; i<8; i++) {
					 nx = h_dx[i] + x;
					 ny = h_dy[i] + y;
					if(ny<0||ny>=M||nx<0||nx>=N)continue;
					if(map[ny][nx]==1)continue; 
					if(dis[ny][nx]<dis[y][x]+1)continue;
					dis[ny][nx] =dis[y][x]+1; 
					q.offer(new int[] {k-1, ny, nx}); 	
				}
				
				for(int i=0; i<4; i++) {
					nx = dx[i]+x; 
				    ny = dy[i]+y; 
					if(ny<0||ny>=M||nx<0||nx>=N)continue;
					if(map[ny][nx]==1)continue; 
					if(dis[ny][nx]<dis[y][x]+1)continue;
					dis[ny][nx] = dis[y][x]+1; 
					q.offer(new int[] {k, ny, nx}); 						
				}
			}
			if(dis[M-1][N-1]!=987654321)break; 
			
		}
		//System.out.println(cnt);
	
	}

}

//1
//3 3
//0 0 0
//0 0 0
//0 0 0



