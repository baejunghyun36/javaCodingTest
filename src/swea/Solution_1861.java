package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1861 {

	static int [] dx = {0,0,1,-1}; 
	static int [] dy = {1,-1,0,0}; 
	
	static boolean [][]visited; 
	static int [][] dis; 
	static int [][] room; 
	static int answer; 
	static int n; 
	static int max_num; 
	
	static int dfs(int x, int y) {

		if(dis[y][x]!=0) return dis[y][x]; 
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i]; 
			int ny = y + dy[i];
			if(ny<0||ny>=n||nx<0||nx>=n)continue; 
			if(room[ny][nx]==room[y][x]+1) dis[y][x] = Math.max(dis[y][x], 1 + dfs(nx, ny)) ; 
		}
		return dis[y][x]; 
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder(); 
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine());

		int testCase = Integer.parseInt(st.nextToken()); 

		for(int t = 1; t<=testCase; t++) {

			st = new StringTokenizer(br.readLine()); 			
			n = Integer.parseInt(st.nextToken());
			room = new int[n][n]; 
			dis = new int [n][n]; 
			visited = new boolean[n][n]; 
			max_num = Integer.MIN_VALUE; 
			answer = Integer.MAX_VALUE;
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<n; j++) room[i][j] = Integer.parseInt(st.nextToken()); 
			}
			int sum = Integer.MIN_VALUE; 
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					sum = Math.max(sum, dfs(j,i)); 
				}
			}
		
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(dis[i][j] ==sum) {
						if(answer>room[i][j])answer=room[i][j]; 
					}
				}
			}
		
			sb.append("#").append(t).append(" ").append(answer).append(" ").append(sum+1).append("\n"); 
		}
		
		bw.write(sb.toString()); 
		bw.flush();
		bw.close();
		
	}
}



