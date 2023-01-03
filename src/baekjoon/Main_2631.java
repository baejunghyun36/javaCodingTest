package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2631 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		
		int n = Integer.parseInt(br.readLine()); 
		int [] info = new int[n]; 
		int [] dp = new int[n]; 
		for(int i=0; i<n; i++) {
			info[i] = Integer.parseInt(br.readLine()); 
		}
		Arrays.fill(dp,  1);

		for(int i=1; i<n; i++) {
			for(int j=i-1; j>=0; j--) {
				if(info[i]>info[j]) {
					dp[i] = Math.max(dp[j]+1, dp[i]); 
					
				}
			}
		}
		//System.out.println(Arrays.toString(dp));
		int answer = 0; 
		for(int i=0; i<n; i++) {
			answer = Math.max(answer, dp[i]); 
		}
		sb.append(n-answer); 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		

	}

}
