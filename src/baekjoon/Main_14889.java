package baekjoon;


import java.util.Scanner;

public class Main_14889 {
	static int[][] map; 
	static int m; 
	static int [] teamA; 
	static int [] teamB; 
	static int ans; 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		m = sc.nextInt(); 
		map = new int[m][m]; 
		teamA = new int[m/2]; 
		teamB = new int[m/2]; 
		ans = Integer.MAX_VALUE; 
		for(int i=0; i<m; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt(); 
			}
		}
		comb(0,0); 

		System.out.println(ans/2);
	
	}
	static void comb(int start, int cnt) {
		
		if(cnt==m/2) {
			int sum =0; 
			int []check = new int [m]; 
			for(int i=0; i<m/2; i++)check[teamA[i]]= 1; 
			int index =0; 
	
			for(int i=0; i<m; i++) {
				if(check[i]==0) {
					teamB[index++] =i; 
				}
			}
			
			for(int i=0; i<m/2; i++) {
				for(int j=0; j<m/2; j++) {
					sum+=( map[teamA[i]][teamA[j]]+  map[teamA[j]][teamA[i]]); 
				}
			}
			
			
			for(int i=0; i<m/2; i++) {
				for(int j=0; j<m/2; j++) {
					sum-=( map[teamB[i]][teamB[j]]+  map[teamB[j]][teamB[i]]);  
				}
			}
			ans = Math.min(Math.abs(sum),  ans); 
	
			return; 

		}
		
		for(int i=start; i<m; i++) {
			
			teamA[cnt]=i; 
			comb(i+1, cnt+1); 
					
		}
		
		
		
	}
}

