package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken());
		int [][] info = new int [N+1][N+1]; 
		int [][] dp = new int [N+1][N+1]; 
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " "); 
			
			for(int j=1; j<=N; j++) {
				if(st.hasMoreTokens()) {
					info[i][j] = Integer.parseInt(st.nextToken()); 
				}
			
				if(i==1)dp[i][j] = info[i][j]; 
			}
			//System.out.println(Arrays.toString(info[i]));
		}
		
		for(int i=2; i<=N; i++) {
			
			for(int j=1; j<=3; j++) {
				if(j==1)dp[i][j] = Math.min(dp[i-1][2], dp[i-1][3])+info[i][j]; 
				else if(j==2)dp[i][j] = Math.min(dp[i-1][1], dp[i-1][3])+info[i][j]; 
				else dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2])+info[i][j]; 
			}
			
			
		}
		int answer = Integer.MAX_VALUE; 
		for(int j = 1; j<=3; j++) {
			answer = Math.min(answer, dp[N][j]); 
		}
		System.out.println(answer);
		
		
	}

}
