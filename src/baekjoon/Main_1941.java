package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1941 {

	static char [][] map; 
	static int [][] visited; 
	static int [] dx = {0,0,-1,1}; 
	static int [] dy = {1,-1,0,0}; 
	static int [] order; 
	static int result ; 
	static int [][] temp; 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		map = new char [5][5]; 
		visited = new int [5][5]; 
		order = new int[7]; 
		result = 0; 
		for(int i=0; i<5; i++) {
			String s = br.readLine(); 
			for(int j=0; j<5; j++) {
				map[i][j] = s.charAt(j); 
			}
		}
		comb(0, 0); 
		System.out.println(result);
	}
	
	


	static void check() {
		
		int cnt = 0; 
		int row = 0; 
		int col = 0; 
		temp = new int[5][5]; 
		visited = new int[5][5]; 
		
		for(int i=0; i<7; i++) {
			int num = order[i]; 
			row = num/5; 
			col = num%5; 
			temp[row][col] = 1; 
			if(map[row][col]=='S')cnt++; 
		}
		
		Queue<int []> q = new LinkedList<>(); 
		q.add(new int[] {row, col}); 
		visited[row][col] = 1; 
		int x = 1; 
		
		while(!q.isEmpty()) {
			int [] yx = q.poll();
			for(int i=0; i<4; i++) {
				int nx = dx[i] + yx[1]; 
				int ny = dy[i] + yx[0]; 
				if(ny<0||ny>=5||nx<0||nx>=5)continue; 
				if(visited[ny][nx]==1||temp[ny][nx]==0)continue;
				visited[ny][nx] = 1; 
				q.add(new int [] {ny,nx});
				x++; 
			}
		}
		
		if(x!=7)return; 	
		if(cnt>=4) result ++; 
	}
	
	
	static void comb(int num, int index ) {

		if(index==7) {
			check(); 
			return; 
		}
		if(num==25)return; 
	
		//추가안할 때 
		comb(num+1, index); 

		
		//추가할 때 
		order[index] = num; 
		comb(num+1, index+1); 

	}
}
