package sw_ability_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656 {

	static int N;
	static int W, H; 
	static int [][] map; 
	static int [] order; 
	static int result; 
	static int [] top; 
	static int [] tempTop; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st; 
		int testCase = Integer.parseInt(br.readLine()); 
		for(int t = 1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine()); 
			N = Integer.parseInt(st.nextToken()); 
			W = Integer.parseInt(st.nextToken()); 
			H = Integer.parseInt(st.nextToken()); 
			
			order = new int [N+1]; 		
			top = new int [W+1];
			tempTop = new int [W+1]; 
			result = 987654321; 
			map = new int [H+1][W+1]; 
			for(int i=1; i<=H; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=1; j<=W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 	
					if(tempTop[j]==0 && map[i][j]!=0 )tempTop[j] = H+1-i; 
				}
			}

			bruteForce(1); 
			sb.append("#").append(t).append(" ").append(result).append("\n"); 
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void attack(int [][] tempMap) {

		
		for(int i=1; i<=N; i++) {
			
			//tempMap
			
			Queue <int []> q = new LinkedList<>(); 
			int lineNumber = order[i]; 
	
			int j; 
			
			if(tempMap[lineNumber][top[lineNumber]]==1) {
				tempMap[lineNumber][top[lineNumber]]=0; 	
				top[lineNumber]--; 
				continue; 
			}
			else if(tempMap[lineNumber][top[lineNumber]]>1) {
				q.offer(new int [] {lineNumber, top[lineNumber]}); 
			}
	
			
			while(!q.isEmpty()) {
				
				int [] yx = q.poll(); 
		
				int y = yx[0]; 
				int x = yx[1]; 
				if(tempMap[y][x]==0)continue; 
				
				int m = W; 
				int n = H; 
				int dis = tempMap[y][x]-1; 
				for(j = y-1; j>=y-dis; j--) {
					if(j<1)break; 
					if(tempMap[j][x]<=1)tempMap[j][x]=0; 
					else q.offer(new int [] {j, x} ); 
				}
				for(j = y+1; j<=y+dis; j++) {
					if(j>m)break; 
					if(tempMap[j][x]<=1)tempMap[j][x]=0; 
					else q.offer(new int [] {j, x} ); 
				}
				for(j = x-1; j>=x-dis; j--) {
					if(j<1)break; 			
					if(tempMap[y][j]<=1)tempMap[y][j]=0; 
					else q.offer(new int [] {y, j}); 
				}
				for(j = x+1; j<=x+dis; j++) {
					if(j>n)break; 
					if(tempMap[y][j]<=1)tempMap[y][j]=0; 
					else q.offer(new int [] {y, j}); 
				}
				tempMap[y][x] = 0; 
			}

			for(j=1; j<=W; j++) {
				int index = 1; 
				for(int k = 1; k<=H; k++) {
					if(tempMap[j][k]!=0) {
						tempMap[j][index++]= tempMap[j][k]; 
					}
				}
				top[j] = index-1; 
				for(int k = index; k<=H; k++)tempMap[j][k] = 0; 
			}
		}
		int cnt =0; 
		for(int i = 1; i<=W; i++	) {
			for(int j=1; j<=H; j++) {
				if(tempMap[i][j]==0)break; 
				cnt++; 
			}
		}
		result = Math.min(result, cnt); 
	}
	
	static void bruteForce(int cnt ) {	
		if(cnt==N+1) {
			int [][] tempMap = new int [W+1][H+1]; 
			for(int i=1; i<=W; i++) {
				top[i] = tempTop[i]; 
				for(int j = H; j>=1; j-- ) {
					tempMap[i][H-j+1] = map[j][i]; 	
				}
			}
			attack(tempMap); 
			return; 
			
		}
		for(int i=1; i<=W; i++) {
			order[cnt] = i; 
			bruteForce(cnt+1); 
			
		}		
	}


}
