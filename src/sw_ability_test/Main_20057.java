package sw_ability_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20057 {

	static Tornado tornado; 
	static int N; 
	static int [] dy = {0, 1, 0, -1}; 
	static int [] dx = {-1, 0, 1, 0}; 
	static int [][] map; 
	static int sum; 
	static int answer; 
	static int in, out; 
	static double [][] left = {
			{0,0, 0.02, 0, 0},
			{0,0.1,0.07, 0.01,0},
			{0.05, 0, 0, 0, 0},
			{0,0.1, 0.07, 0.01, 0},
			{0,0,0.02, 0, 0}
	}; 
	static double [][] down = {
			{0, 0,0, 0, 0},
			{0, 0.01, 0, 0.01, 0},
			{0.02, 0.07, 0, 0.07, 0.02},
			{0, 0.1, 0, 0.1, 0},
			{0, 0, 0.05, 0, 0}
	}; 
	static double [][] right = {
			{0, 0, 0.02, 0,0 },
			{0, 0.01, 0.07, 0.1, 0}, 
			{0, 0, 0, 0, 0.05}, 
			{0, 0.01, 0.07, 0.1, 0}, 
			{0,0,0.02, 0, 0}			
	}; 
	static double [][] up = {
			{0, 0,0.05, 0, 0},
			{0, 0.1, 0, 0.1, 0},
			{0.02, 0.07, 0, 0.07, 0.02},
			{0, 0.01, 0, 0.01, 0},
			{0, 0, 0, 0, 0}
	};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st; 
		N = Integer.parseInt(br.readLine()); 
		map = new int [N+1][N+1]; 
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		tornado = new Tornado(N/2+1, N/2+1, 0, 1, 0); 
		sum = 0; 
		while(true) {
			
		
			for(int i=0; i<tornado.dis; i++) {
				int ny = dy[tornado.dir]+tornado.y; 
				int nx = dx[tornado.dir]+tornado.x; 
				//System.out.println(ny+ " "+ nx);
				moveDust(tornado.dir, ny, nx, map[ny][nx]); 
				tornado.y = ny; 
				tornado.x = nx; 	
				if(tornado.y==1&&tornado.x==1)break; 
			}
			if(tornado.y==1&&tornado.x==1)break; 
			tornado.dir++; 
			tornado.dir = tornado.dir%4; 			
			tornado.cnt++; 
			if(tornado.cnt==2) {
				tornado.cnt=0; 
				tornado.dis++; 
			}
	
		}
		System.out.println(answer);

	}

	
	static void moveDust(int dir, int y, int x, int size) {	
		in =0; 
		out = 0; 
		int [][]temp = new int [5][5]; 
		if(dir==0) {
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					temp[i][j] = (int)(left[i][j] *size); 
				}
			}
			calc(y, x, temp); 
			if(x-1>=1)map[y][x-1]+=size-in-out; 
			else out+=size-in-out; 
 

		}
		else if(dir==1) {
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					temp[i][j] = (int)(down[i][j] *size); 
				}
			}
			calc(y, x, temp); 
			if(y+1<=N)map[y+1][x]+=size-in-out; 
			else out+=size-in-out; 
		}
		else if(dir==2) {
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					temp[i][j] = (int)(right[i][j] *size); 
				}
			}
			calc(y, x, temp); 
			if(x+1<=N)map[y][x+1]+=size-in-out; 
			else out+=size-in-out; 
		}
		else {
			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					temp[i][j] = (int)(up[i][j] *size); 
				}
			}
			calc(y, x, temp); 
			if(y-1>=1)map[y-1][x]+=size-in-out; 
			else out+=size-in-out; 
		}
		answer+=out;
		
	}
	
	static void calc(int y, int x, int [][]temp) {
		for(int i=y-2; i<=y+2; i++) {
			for(int j=x-2; j<=x+2; j++) {
				if(i>=1&&i<=N&&j>=1&&j<=N) {
					map[i][j]+=temp[i-(y-2)][j-(x-2)]; 
					in +=temp[i-(y-2)][j-(x-2)]; 
				}
				else {
					out+=temp[i-(y-2)][j-(x-2)]; 
				}
			}
		}
	}
	
	static class Tornado{
		
		int y; 
		int x; 
		int dir; 
		int dis; 
		int cnt;
		
		public Tornado(int y, int x, int dir, int dis, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.dis = dis;
			this.cnt = cnt;
		} 
	}
	
}
