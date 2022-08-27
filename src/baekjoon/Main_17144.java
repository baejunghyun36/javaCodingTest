package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17144 {
	static int [][] map; 
	static int [] dx = {0,1,0,-1}; 
	static int [] dy = {-1,0,1,0}; 
	static int m, n, t; 
	static List <Dust> dustList; 
	static Machine machine; 
	public static void main(String[] args) throws IOException {
	    //확산되는 양은 Ar,c/5이고 소수점은 버린다.
		// Ar,c - (Ar,c/5)×(확산된 방향의 개수)
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		m = Integer.parseInt(st.nextToken()); 
		n = Integer.parseInt(st.nextToken()); 
		t = Integer.parseInt(st.nextToken()); 
		
		map = new int [m+1][n+1]; 		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 				
				if(map[i][j] == -1) machine = new Machine(i-1, j); 	
			}
		}
		
		movingForTime(); 
		int result =0; 
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j]!=-1)result+=map[i][j]; 
			}
		}
		System.out.println(result);
	}
	
	
	
	
	static void movingForTime() {
		
		
		while(0<t--) {
			

			
			
			dustList = new LinkedList<>(); 
		    //확산되는 양은 Arc/5이고 소수점은 버린다.
			// Ar,c - (Ar,c/5)×(확산된 방향의 개수)
			for(int i=1; i<=m; i++) {
				for(int j=1; j<=n; j++) {				
					 if(map[i][j] > 0) dustList.add(new Dust(0,0,0,0,map[i][j], i, j));
					 if(map[i][j] !=-1) map[i][j] = 0; 
			
				}
			}

			//먼지 확산 
			for(Dust d : dustList) {
				int y = d.y; 
				int x = d.x; 
				int cnt =0; 
				for(int i=0; i<4; i++) {
					int nx = x+dx[i]; 
					int ny = y+dy[i]; 
					if(nx<=0||nx>n||ny<=0||ny>m)continue;
					if(map[ny][nx]==-1)continue; 
					cnt++; 
					map[ny][nx] += d.mid/5;				
				}
				d.mid = d.mid - (d.mid/5)*cnt; 
				map[y][x]+=d.mid; 
			}

			
			//바람 이동 
			
			for(int i=machine.y-1; i>=2; i--) map[i][machine.x] = map[i-1][machine.x]; 			
			for(int j=machine.x; j<=n-1; j++) map[1][j]= map[1][j+1]; 			
			for(int i=1; i<=machine.y-1; i++) map[i][n] = map[i+1][n]; 			
			for(int j=n; j>=3; j--) map[machine.y][j] = map[machine.y][j-1]; 
			map[machine.y][2]=0; 
			
			int y = machine.y+1; 
			int x = machine.x; 
			for(int i=y+1; i<m; i++) map[i][x] = map[i+1][x]; 
			for(int j=1; j<n; j++)map[m][j] = map[m][j+1];
			for(int i=m; i>y; i--) map[i][n] = map[i-1][n];
			for(int j=n; j>=3; j-- ) map[y][j] = map[y][j-1]; 
			
			map[y][2] = 0; 
		}
	}
	

	static class Machine {
		
		int y; 
		int x;
		
		public Machine(int y, int x) {

			this.y = y;
			this.x = x;			
		} 
	}
	
	static class Dust{
		
		int right; 
		int up; 
		int down;
		int left;
		int mid;
		int y, x; 
		
		public Dust(int right, int up, int down, int left, int mid, int y, int x) {
			super();
			this.right = right;
			this.up = up;
			this.down = down;
			this.left = left;
			this.mid = mid;
			this.y = y; 
			this.x = x; 
		}

	}
}

