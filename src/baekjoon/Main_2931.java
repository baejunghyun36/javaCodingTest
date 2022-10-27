package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2931 {

	static int [] dx = {0,0,0,-1,1}; 
	static int [] dy = {0,-1,1,0,0}; 
	static int [][] map; 
	static int [][] dir; 
	static int M,N; 
	static boolean flag; 
	static int [] yx; 
	static char result; 
	static int cnt;  
	static int [][] possible = {{0},{1,3,4,7}, {1,3,5,6},{2,3,4,5}, {2,3,6,7}}; 
	static char [] cmp; 
	public static void main(String[] args) throws IOException {
		 
		dir = new int[5][10];
		
		dir[1][1] = dir[1][3] = dir[3][5] = dir[4][6] = 1; 
		dir[2][1] = dir[2][3] = dir[3][4] = dir[4][7] = 2; 
		dir[1][7] = dir[2][6] = dir[3][2] = dir[3][3] = 3; 
		dir[1][4] = dir[2][5] = dir[4][2] = dir[4][3] = 4; 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		cmp = new char [] {' ','|','-','+','1','2','3','4'};
	
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		
		map = new int[M][N]; 
		
		flag = false; 
		yx = new int[2]; 
		int hy = 0; 
		int hx = 0; 
		
		for(int i=0; i<M; i++) {
			String s = br.readLine(); 
			for(int j=0; j<N; j++) {
				char c = s.charAt(j); 
				if(c=='.')map[i][j] = 0; 
				else if(c=='|')map[i][j] = 1; 
				else if(c=='-')map[i][j] = 2; 
				else if(c=='+')map[i][j] = 3; 
				else if(c=='1')map[i][j] = 4; 
				else if(c=='2')map[i][j] = 5; 
				else if(c=='3')map[i][j] = 6; 
				else if(c=='4')map[i][j] = 7; 
				else if(c=='Z')map[i][j] = 9; 				
				else {
					hy = i; 
					hx = j; 
					map[i][j] = 8; 
				}				
			}
		}
		
		out:for(int i=1; i<=4; i++) {
			int nx = hx + dx[i]; 
			int ny = hy + dy[i]; 
			if(nx<0||nx>=N||ny<0||ny>=M)continue; 
			if(map[ny][nx]==0)continue; 
			for(int j=0; j<4; j++) {
				if(possible[i][j]==map[ny][nx]) {
					dfs(ny, nx, i); 
					break out; 
				}
			}
		}		
		sb.append(yx[0]+1).append(" ").append(yx[1]+1).append(" ").append(cmp[map[yx[0]][yx[1]]]); 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int y, int x, int d) {
		
		int nextDir = dir[d][map[y][x]]; 
		int ny = y+dy[nextDir];
		int nx = x+dx[nextDir];
	
		if(ny<0||ny>=M||nx<0||nx>=N) return;	
		if(map[ny][nx]==0&&cnt==1) return;
		
		if(map[ny][nx]==9) {
			flag = true; 
			return;					
		}
		for(int i=1; i<=4; i++) {
			if(map[ny][nx]==0) {
				yx[0] = ny;
				yx[1] = nx;
				cnt = 1; 
				for(int j=0; j<4; j++) {
					if(flag == false) {
						map[ny][nx] = possible[nextDir][j]; 
						dfs(ny,nx,nextDir); 
					}
				}
			}
			else if(map[ny][nx]==possible[nextDir][i-1]&&flag == false) dfs(ny,nx,nextDir); 
		}
	}
}
