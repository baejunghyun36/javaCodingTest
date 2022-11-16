package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_5427 {
	
	static int N, M; 
	static int [][] map; 
	static int [][] visited; 
	static Queue <int []> sangbum; 
	static Queue <int []> fire; 
	static boolean flag; 
	static int second; 
	static int [] dx = {0,0,-1,1}; 
	static int [] dy = {1,-1,0,0}; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		int testCase = Integer.parseInt(br.readLine()); 
		while(testCase-->0) {
			flag = false; 
			second = 0; 
			st = new StringTokenizer(br.readLine()); 
			N = Integer.parseInt(st.nextToken()); 
			M = Integer.parseInt(st.nextToken()); 
			map = new int[M][N]; 
			visited = new int[M][N]; 
			sangbum = new LinkedList<>(); 
			fire = new LinkedList<>(); 
			for(int i=0; i<M; i++) {
				String s= br.readLine(); 
				for(int j=0; j<N; j++) {
					char c = s.charAt(j); 
					if(c=='.')map[i][j] = 0; 
					else if(c=='#')map[i][j] = 1; 
					else if(c=='@') {
						sangbum.add(new int[] {i,j}); 
						visited[i][j] = 1; 
						map[i][j] = 0; 
					}
					else if(c=='*') {
						fire.add(new int[] {i, j}); 
						map[i][j] = 2; 
					}
				}
			}
			while(true) {
				second++; 
				bfsFire(); 
				if(bfsSangbum()||!flag) break; 		
			}
			
			if(flag==false) sb.append("IMPOSSIBLE\n"); 			
			else sb.append(second).append("\n"); 		
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean bfsSangbum() {
		
		int size = sangbum.size(); 
		flag = false; 
		while(size-->0) {
			int [] yx = sangbum.poll(); 
			int x = yx[1]; 
			int y = yx[0]; 
			
			for(int i=0; i<4; i++) {
				int nx = x+ dx[i]; 
				int ny = y+ dy[i]; 
				if(ny<0||ny>=M||nx<0||nx>=N) { 
					flag= true; 
					return true;	}
				if(map[ny][nx] == 1 || map[ny][nx] == 2)continue; 
				if(visited[ny][nx] ==1)continue; 
				flag = true; 		
				visited[ny][nx] = 1; 
				sangbum.add(new int [] {ny, nx}); 			
			}
		}
		return false; 
	}
	
	static void bfsFire() {
		
		int size = fire.size(); 
		while(size-->0) {
			int [] yx = fire.poll(); 
			int x = yx[1]; 
			int y = yx[0]; 			
			for(int i=0; i<4; i++) {
				int nx = x+ dx[i]; 
				int ny = y+ dy[i]; 
				if(ny<0||ny>=M||nx<0||nx>=N)continue;
				if(map[ny][nx] == 1 || map[ny][nx] == 2)continue; 				 
				map[ny][nx] = 2; 
				fire.add(new int [] {ny, nx}); 			
			}
		}
	}
}
