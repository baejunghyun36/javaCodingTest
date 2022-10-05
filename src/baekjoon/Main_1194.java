package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194 {

	static Queue <int []> q; 
	static char [][] map; 
	static int [][] bMap; 
	static int [][] visited; 
	static int M; 
	static int N; 
	static int []dx = {0,0,-1,1}; 
	static int []dy = {1,-1,0,0}; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		
		q = new LinkedList<>(); 
		map = new char [M][N]; //지도 
		visited = new int [M][N]; //방문했는지
		bMap = new int [M][N]; //비트마스킹 맵
		for(int i=0; i<M; i++) {			
			map[i] = br.readLine().toCharArray();  
			for(int j=0; j<N; j++) {
				if(map[i][j]=='0') {//시작지점
					map[i][j] = '.'	; //갈수 있는 길로 바꿈
					q.add(new int[] {i, j, 0, 0}); //행, 열, 비트마스킹, 거리 
					visited[i][j] = 1; 
				}
			}
		}
		bfs(); 		
	}
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			int [] yxb = q.poll(); 			
			int y = yxb[0];  // 현재 행
			int x = yxb[1];  // 현재 열
			int dis = yxb[3]; // 지금 현재 위치가 어떤 거리값을 가지는지 
						
			for(int i=0; i<4; i++) {
				int nx = x + dx[i]; 
				int ny = y + dy[i];
				int bit = yxb[2]; //현재 비트 마스킹 
				
				if(ny<0||ny>=M||nx<0||nx>=N)continue; 	//맵 초과일 때 	
				if(map[ny][nx] == '#')continue;  // 막혀있을 때 
				if(visited[ny][nx]==1&&((bMap[ny][nx]|bit)==bMap[ny][nx])) continue; //방문을 한적이 있는데 현재 열쇠를 가져왔는지를 체크 	
				if(map[ny][nx]>='A'&&map[ny][nx]<='Z') { // A~Z 일 때 a~z 의 열쇠가 있는지 체크 
					int bitLoc = 1 <<(map[ny][nx]-'A'); 
					if((bitLoc&bit)!=bitLoc) continue; 					
				}
				if(map[ny][nx] >= 'a' && map[ny][nx]<='z') { //a~z 열쇠를 주었다면 현재 bit 업데이트 
					int bitLoc = 1 <<(map[ny][nx]-'a');				
					bit|=bitLoc; 						
				}
				if(map[ny][nx]=='1') { // 나와
					System.out.println(dis+1);
					return; 
				}
				bMap[ny][nx] = bit; 
				visited[ny][nx] =1 ; 				
				q.add(new int [] {ny, nx, bit, dis+1}); 				
			}
		}
		System.out.println(-1);
		return; 
	}
}
