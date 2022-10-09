package baekjoon;

import java.util.Scanner;

public class Main_17069 {

	static int N; 
	static long [][] map; 
	static long [][] dp; 
	static long [][][] pipeMap; 
	static long answer; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); 
		
		map = new long [N+1][N+1]; 
		dp = new long [N+1][N+1]; 
		pipeMap = new long[4][N+1][N+1]; 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = sc.nextInt(); 
			}
		}		
	
		System.out.println(dfs(1,1,2));  
		

	}
	
	static long dfs(int prev, int y, int x) {
	
		if(y<=0||y>N||x<=0||x>N)return 0; 
		if(prev==2) {
			if(map[y-1][x]==1||map[y][x-1]==1) return 0; 
		}
		
		if(map[y][x]==1) return 0; 		
		
		if(y==N && x==N) return 1; 
		
		
		if(pipeMap[prev][y][x]!=0) return pipeMap[prev][y][x]; 

		if(prev==1) {
			pipeMap[prev][y][x] +=dfs(1, y, x+1);
			pipeMap[prev][y][x] +=dfs(2, y+1, x+1); 
		 
		}
		
		else if(prev==2) {
			pipeMap[prev][y][x]+=dfs(1, y, x+1); 
			pipeMap[prev][y][x]+=dfs(2, y+1, x+1); 
			pipeMap[prev][y][x]+=dfs(3, y+1, x); 
		}
		
		else {
			pipeMap[prev][y][x]+=dfs(2, y+1, x+1); 
			pipeMap[prev][y][x]+=dfs(3, y+1, x); 			
		}
		
		return pipeMap[prev][y][x]; 
	}
}
