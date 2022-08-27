package sw_ability_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2105_swAbility {

	static int testCase; 
	static int N; 
	static int [] dx = {1,1,-1,-1}; 
	static int [] dy = {-1, 1, 1, -1}; 
	static int [][] map; 
	static int [][] visited; 
	static int [] food; 
	static int [] visitedDir; 
	static int answer; 
	static int startY, startX; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		testCase = Integer.parseInt(st.nextToken()); 
		for(int t = 1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine()); 
			N = Integer.parseInt(st.nextToken()); 
			map = new int [N][N]; 
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			answer =-1; 
	
	
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					food = new int [101]; 
					startY = i; startX = j; 
					visitedDir = new int [4]; 
					food[map[i][j]]++; 
					dfs(i, j, 0, 1); 
					food[map[i][j]]--; 
				}
				
			}
		
			sb.append("#").append(t).append(" ").append(answer).append("\n"); 
		}
		System.out.println(sb.toString());

	}
	static void dfs(int y, int x, int prevDir, int cnt ) {
		
		
		for(int i=prevDir; i<4;i++) {
			int nx = dx[i]+x; 
			int ny = dy[i]+y; 
			if( ny == startY && nx == startX && cnt>2) {
				answer = Math.max(answer, cnt);
				return; 
			}
			if(ny<0||ny>=N||nx<0||nx>=N)continue; 
			if(food[map[ny][nx]]==1)continue; 
		
			food[map[ny][nx]]=1;
			visitedDir[i] = 1; 	
			dfs(ny, nx, i, cnt+1); 
			food[map[ny][nx]]=0; 
			visitedDir[i] = 0; 
		}
		
		
	}

}


//
//1
//4
//1 5 1 7
//6 1 4 6
//4 8 4 7
//6 2 4 2