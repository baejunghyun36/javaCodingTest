package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643 {
	static int stCount; 
	static int M; 
	static int [][] map; 
	static Queue <Integer> q; 
	static int [] visited; 
	static int answer; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int testCase = Integer.parseInt(br.readLine()); 
		
		for(int t=1; t<=testCase; t++) {
			
			StringTokenizer st = null; 
			stCount = Integer.parseInt(br.readLine()); 
			M = Integer.parseInt(br.readLine()); 
			map = new int [stCount+1][stCount+1]; 
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine()); 				
				int a = Integer.parseInt(st.nextToken()); 
				int b = Integer.parseInt(st.nextToken()); 
				map[a][b] = 1; 				
			}
			
			answer =0; 
			
			//학생 수 만큼 돌려 
			for(int i=1; i<=stCount; i++) {
				q = new LinkedList<>(); 
				q.add(i); 
				int cnt = 0; 
				cnt+=bigSmallCheck(i,0); // 자신보다 큰 사람 인원 수 
				
				q = new LinkedList<>();  
				q.add(i); 
				cnt+=bigSmallCheck(i,1); // 자신보다 작은 사람 인원 수
				
				if(cnt==stCount-1)answer++; // 큰 사람 인원 수 + 작은 사람 인원 수  = 전체 인원 수 -1
			
			}			
			sb.append("#").append(t).append(" ").append(answer).append("\n"); 
		}
		System.out.println(sb.toString());
	}
	static int bigSmallCheck(int l, int check) {
		visited = new int[stCount+1]; 
		visited[l] = 1; 
		int cnt = 0; 
		while(!q.isEmpty()) {
			int x = q.poll();		
			for(int i=1; i<=stCount; i++) {		
				if(check==0) { //큰 사람 체크 하는 구문
					if(map[x][i]==1&&visited[i]==0) {
						visited[i] = 1; 
						cnt++; 
						q.add(i); 
					}
				}
				else {//작은 사람 체크하는 구문
					if(map[i][x]==1&&visited[i]==0) {
						visited[i] = 1; 
						cnt++; 
						q.add(i);				
					}
				}
			}			
		}
		return cnt; 
	}

}
