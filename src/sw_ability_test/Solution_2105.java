package sw_ability_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2105 {

	static int n; 
	static int testCase; 
	static int [][]map; 
	static int [][]visited; 
	static int []visitedDir; 
	static int [] dx = {1,1, -1,-1}; 
	static int [] dy = {-1,1,1,-1}; 
	static int []food ; 
	static int startY, startX; 
	static int maxNumber; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		testCase = Integer.parseInt(st.nextToken());
		for(int t=1; t<=testCase; t++) {
			
			st = new StringTokenizer(br.readLine()); 
			n = Integer.parseInt(st.nextToken()); 
			
			map = new int[n][n]; 
			visitedDir = new int[4] ; 
			food = new int [101]; 
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
	
			visited = new int [n][n]; 
			
	 
			maxNumber = -1; 
			for(int i=0; i<n; i++	) {
				for(int j=0; j<n; j++) {			
					startY = i; 
					startX = j; 		

					food[map[i][j]]=1; 	
					
					dfs(i, j, 0, 1); 					

					food[map[i][j]]=0; 
				}
			}

			sb.append("#").append(t).append(" ").append(maxNumber).append("\n"); 

		}		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	
	static void dfs(int y, int x, int prevDir, int cnt) {
		
		
		
		
		for(int i=0; i<4; i++) {
			
			int nx = dx[i] + x; 
			int ny = dy[i] + y; 
			
			if(ny==startY&&nx==startX) {
				int count=0; 
				int index = 0; 
				for(int j=0; j<4; j++) {
					if(visitedDir[j]==0) {
						count++; 
						index=j; 				
					}
				}
				if(count==1&&index==i) {
					maxNumber = Math.max(maxNumber, cnt); 
					return; 
				}	
			}
			
			if(ny<0||ny>=n||nx<0||nx>=n)continue;
			if(visitedDir[i]==1&&prevDir!=i)continue; 
			if(food[map[ny][nx]]==1)continue; 

			visitedDir[i] = 1; 
			food[map[ny][nx]]=1; 
	        dfs(ny, nx, i, cnt+1);

	        visitedDir[i] = 0; 
	        food[map[ny][nx]]=0; 
		}
		
		
		
		
		
		
		
		
		
	}
}
