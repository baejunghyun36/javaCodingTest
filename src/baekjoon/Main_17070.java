package baekjoon;

import java.util.Scanner;

public class Main_17070 {

	static int N; 
	static int [][] map; 
	static int [][] dp; 
	static int answer; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); 
		
		map = new int [N+1][N+1]; 
		dp = new int [N+1][N+1]; 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt(); 
			}
		}
		
		dfs(1, 1,2); 
		System.out.println(dp[N][N]);
	
	}
	
	static void dfs(int prev, int y, int x) {
		
		
		//1 가로 
		//2 대각선
		//3 세로 
		
		if(y<=0||y>N||x<=0||x>N)return; 
		if(prev==2) {
			if(map[y-1][x]==1||map[y][x-1]==1)return; 
		}
		if(map[y][x]==1)return; 
		dp[y][x]++; 
		
		if(y==N&&x==N) return; 			
		
		
		if(prev==1) {
			
			dfs(1, y, x+1); 
			dfs(2, y+1, x+1); 
		}
		else if(prev==2) {
			dfs(1, y, x+1); 
			dfs(2, y+1, x+1); 
			dfs(3, y+1, x); 
		}
		else {
			dfs(2, y+1, x+1); 
			dfs(3, y+1, x); 
		}		
	}
	static boolean check(int y, int x) {
		
		if(y<=0||y>N||x<=0||x>N)return false; 
		return true; 
	}

}
