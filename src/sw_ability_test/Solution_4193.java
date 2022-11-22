package sw_ability_test;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4193 {

	static int [][] map; 
	static int [][] dist; 
	static int [] dx = {0,0,-1,1}; 
	static int [] dy = {1,-1,0,0}; 
	static int N; 
	static int [] start, end; 
	static Queue <int []> q; 
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		int testCase = Integer.parseInt(br.readLine()); 
		
		for(int t = 1; t<=testCase; t++) {
			
			N = Integer.parseInt(br.readLine()); 
			map = new int[N][N]; 
			dist = new int[N][N]; 
			q = new LinkedList<>(); 
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
					dist[i][j] = 987654321; 
				}
			}
			start = new int [2]; 
			end = new int [2]; 
			st = new StringTokenizer(br.readLine()); 
			start[0] = Integer.parseInt(st.nextToken()); 
			start[1] = Integer.parseInt(st.nextToken()); 
			st = new StringTokenizer(br.readLine()); 
			end[0] = Integer.parseInt(st.nextToken()); 
			end[1] = Integer.parseInt(st.nextToken()); 
			
			dist[start[0]][start[1]] = 0; 
			
			q.add(new int[] {start[0], start[1], 0}); 
			
			bfs(); 
            if(dist[end[0]][end[1]]==987654321){
               sb.append("#").append(t).append(" ").append(-1).append("\n"); 
            }
            else{
               sb.append("#").append(t).append(" ").append(dist[end[0]][end[1]]).append("\n"); 
            }
	
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(){
		
		while(!q.isEmpty()) {
			
			int [] yx = q.poll(); 
			int y = yx[0]; 
			int x = yx[1]; 
		
			if(y==end[0]&&x==end[1]) return; 
			

			for(int i=0; i <4; i++) {
				int nx = x+dx[i]; 
				int ny = y+dy[i]; 
				int second = yx[2]; 
				if(ny<0||ny>=N||nx<0||nx>=N)continue; 
				if(dist[ny][nx]<=second+1)continue; 
				if(map[ny][nx]==1)continue; 
				second++; 
				if(map[ny][nx]==2) {
					while(!(second%3==0)) second++; 
				}
				dist[ny][nx] = second; 
				q.add(new int[] {ny, nx, second}); 
			}
		}
	}

}
