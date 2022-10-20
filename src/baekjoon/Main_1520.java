package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1520 {
	
	static int M,N; 
	static int [][] map; 
	static int [][] dp; 
	static int [] dx = {0,0,1,-1}; 
	static int [] dy = {1,-1,0,0}; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//input
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		
		//init
		map = new int [M][N]; 
		dp = new int [M][N]; 
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer (br.readLine()); 
			for(int j= 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		//recursive
		sb.append(dfs(0,0));
		for(int i=0; i<M; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static int dfs(int y, int x) {
		
		if(y==M-1&&x==N-1)return 1; 
		if(dp[y][x]!=0)return dp[y][x]; 
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i]; 
			int ny = y + dy[i]; 
			if(nx<0||nx>=N||ny<0||ny>=M)continue; 
			if(map[y][x]<=map[ny][nx])continue; 
			dp[y][x] += dfs(ny,nx); 
		}
		
		return dp[y][x]; 
		
	}

}
