package sw_ability_test;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_14503 {

	static int M, N; 
	static int r, c; 
	static int [][] map; 
	static int [] dy = {-1, 0, 1, 0}; 
	static int [] dx = {0, 1, 0, -1}; 
	static Robot robot; 
	static int cleanCnt; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		st = new StringTokenizer(br.readLine()); 
		int y = Integer.parseInt(st.nextToken()); 
		int x = Integer.parseInt(st.nextToken()); 
		int dir = Integer.parseInt(st.nextToken()); 
		robot = new Robot(y, x, dir); 
		cleanCnt=0; 
		map = new int [M][N]; 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		move(); 
		System.out.println(cleanCnt);
		

	}
	
	static void move() {
		
		
		while(true) {
			
			int y = robot.y; 
			int x = robot.x; 
			int dir = robot.dir; 
			if(map[y][x]==0)cleanCnt++; 
			
			map[y][x] = 2; 
			
			//회전
			
			boolean flag = false; 
			for(int i= 0; i<4; i++) {
				
				dir--; 
				if(dir==-1)dir = 3; 
				int nx = x + dx[dir]; 
				int ny = y + dy[dir]; 
				if(ny<0||ny>=M||nx<0||nx>=N)continue; 
				if(map[ny][nx]==1||map[ny][nx]==2)continue; 
				if(map[ny][nx] ==0) {
					flag = true;
					robot.y = ny; 
					robot.x = nx; 
					robot.dir = dir; 
					break; 
				}
			}
			if(flag==false) {
				robot.dir = dir;
				dir+=2; 
				dir%=4; 
				int ny = y + dy[dir]; 
				int nx = x + dx[dir]; 
				if(map[ny][nx]==1)break; 
				else {
					robot.y = ny; 
					robot.x = nx; 
				}
			}

		}

	}
	
	static class Robot{
		int y; 
		int x;
		int dir; 
		public Robot(int y, int x, int dir) {
		
			this.y = y;
			this.x = x;
			this.dir = dir; 
		} 
		
		
	}

}
