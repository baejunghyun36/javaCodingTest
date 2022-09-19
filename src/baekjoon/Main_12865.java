package baekjoon;

import java.util.*; 
public class Main_12865 {

	static int N, K; 
	static int [][] info; 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); //물품의 수
		K = sc.nextInt(); //버틸 수 있는 무게
		info = new int [N+1][2]; 
		
		for(int i=1; i<=N; i++) {
			
			int w = sc.nextInt(); 
			int v = sc.nextInt(); 
			info[i][0] = w; //무게
			info[i][1] = v; //가치
			
		}
		
		int [][] dp = new int [N+1][K+1]; 
		
		for(int i=1; i<=N; i++) {//물품 1부터 N까지
			for(int j=1; j<=K; j++	 ) {
				dp[i][j] = dp[i-1][j]; 
				if(j-info[i][0]>=0) {
					dp[i][j] = Math.max(dp[i-1][j], info[i][1]+dp[i-1][j-info[i][0]]); 
				}
			}
		}
		System.out.println(dp[N][K]);

		StringBuilder sb= new StringBuilder(); 
		sb.toString(); 
	}

}
