package sw_ability_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1949 {

	static int N; 
	static int [][] map; 
	static int [][]	visited; 
	static int K; 
	static int maxNumber; 
	static List<int []> pointList; 
	static Queue<int []> q; 
	static int [] dx = {0, 0, 1,-1}; 
	static int [] dy = {1,-1, 0, 0}; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		int testCase = Integer.parseInt(st.nextToken()); 
		
		for(int t = 1; t<=testCase; t++) {
			
			st = new StringTokenizer(br.readLine()); 
			
			N = Integer.parseInt(st.nextToken()); 
			K = Integer.parseInt(st.nextToken()); 
			map = new int[N][N]; 
			maxNumber =0; 
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
					if(maxNumber<map[i][j])maxNumber = map[i][j]; 
				}
			}
			
			pointList = new ArrayList <>(); 
			
			initMaxPoint(); 
			
			q = new LinkedList<>(); 
			int maxResult  =0; 
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					for(int k=1; k<=K; k++) {
						map[i][j]-=k; 									
						
						for(int l=0; l<pointList.size(); l++) {	
							int [] yx = pointList.get(l); 
							if(i==yx[0]&&j==yx[1])continue; 
							visited = new int[N][N]; 
							visited[yx[0]][yx[1]]= 1; 
							maxResult = Math.max(maxResult, dfs(yx[0], yx[1])); 
					
						}					
						
						map[i][j]+=k; 
					}
			
				
				}
			}
			sb.append("#").append(t).append(" ").append(maxResult).append("\n"); 
		}
		System.out.println(sb.toString());
	}
	
	
	static void initMaxPoint() {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==maxNumber) {				
					pointList.add(new int [] {i,j}); 
				}
			}
		}		
	}
	
	static int dfs(int y, int x) {
		
		int cnt = 1; 
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i]; 
			int ny = y + dy[i]; 
			
			if(ny<0||ny>=N||nx<0||nx>=N)continue; 
			if(visited[ny][nx] ==1 || map[ny][nx]>=map[y][x])continue; 
			
			visited[ny][nx] = 1; 
			cnt = Math.max(cnt, dfs(ny,nx)+1); 
			visited[ny][nx] = 0; 
		}
				
		return cnt; 

	}
}
