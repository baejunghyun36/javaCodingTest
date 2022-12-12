package baekjoon;

import java.util.Scanner;

public class Main_3109 {
	static int m,n; 
	static char [][] map ;
	static int result; 
	static int [][]visited;
	static int [] dy = {-1,0,1}; 
	static int [] dx = {1,1,1}; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int m, n; 
		result=0; 
		m = sc.nextInt(); 
		n = sc.nextInt(); 
		map = new char[m][n];
		visited = new int [m][n]; 
		
		for(int i=0; i<m; i++) {
			String s= sc.next(); 
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j); 
			}
		}
		
		for(int i=0; i<m; i++) {
			
			visited[i][0]=1; 
			function(i,0); 
		}
		

	}
	static void function(int y, int x) {
		
		if(x==n) {
			result++; 
			return ; 
		}
		
		for(int i=0; i<3; i++) {
			int nx = x+dx[i]; 
			int ny = y+dy[i]; 
			if(ny<0||ny>=m||nx<0||nx>=n)continue; 
			if(visited[ny][nx]==1)continue; 
			visited[ny][nx]=1; 
			function(ny,nx); 
			
		}		
		
	}
}
