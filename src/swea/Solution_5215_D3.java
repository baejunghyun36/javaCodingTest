package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_5215_D3 {

	static int [][] arr ; 
	static int n; 
	static int cal; 
	static int maxScore; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new  StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken()); 
		for(int t=1; t<=testCase; t++ ) {
			st = new StringTokenizer(br.readLine()); 
			n = Integer.parseInt(st.nextToken()); 
			cal = Integer.parseInt(st.nextToken()); 
			arr = new int[n][2];
			maxScore = Integer.MIN_VALUE; 
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine()); 
				arr[i][0] = Integer.parseInt(st.nextToken()); 
				arr[i][1] = Integer.parseInt(st.nextToken()); 
			}
			//dfs(0, 0, 0); 
			bitMask();
			sb.append("#").append(t).append(" ").append(maxScore).append("\n"); 

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
//	static void dfs(int start, int s, int c) {
//		
//		
//		if(c > cal)return; 
//		if(c <=cal)maxScore = Math.max(s, maxScore); 
//		if(start == n)return; 
//		
//		dfs(start+1,s+arr[start][0], c+arr[start][1] ); 
//		dfs(start+1, s, c);
//
//	}
	
	static void bitMask() {
		
		for(int i=0; i<=(1<<n)-1; i++) {
			int scoreSum=0; 
			int calSum =0; 
			boolean flag= false; 
			for(int j=0; j<n; j++) {
				if((i&(1<<j))!=0) {
					scoreSum+=arr[j][0]; 
					calSum+=arr[j][1];
					if(calSum>cal) {
						flag = true; 
						break;
					}
				}
			}
			if(flag == false)maxScore = Math.max(maxScore, scoreSum); 
		}
	}
}

















