package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_17406 {
	static int [][] operation; 
	static int [][] map; 
	static int []visited; 
	static int testCase; 
	static int m,n; 
	static int min_num; 
	public static void main(String[] args) throws IOException  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
	
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		testCase = Integer.parseInt(st.nextToken());
		map = new int[m+1][n+1]; 
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) ;
			}
		}
		operation = new int [7][3]; 
		visited = new int[testCase+1]; 
		for(int i=1; i<=testCase; i++) {
			st = new StringTokenizer(br.readLine()); 
			int r,c,s; 
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken()); 
			s = Integer.parseInt(st.nextToken()); 
			operation[i][0]=r; 
			operation[i][1]=c; 
			operation[i][2]=s; 
			//rightRotate(r-s, c-s, r+s, c+s) ; 
		}
		min_num = Integer.MAX_VALUE; 
		perm(1); 
		

		sb.append(min_num); 
		bw.write(sb.toString()) ;
		bw.flush();
		bw.close(); 
	}
	
	static void perm(int h) {
		if(h>testCase) {
			int [][] copymap = new int[m+1][n+1]; 
			
			for(int i=1; i<=m; i++) {
				System.arraycopy(map[i], 0, copymap[i], 0, n+1);
			}
			
			for(int i=1; i<=testCase; i++) {
				int r= operation[visited[i]][0];
				int c= operation[visited[i]][1];
				int s = operation[visited[i]][2];
				rightRotate(r-s, c-s, r+s, c+s, copymap) ;
			}
			
			for(int i=1; i<=m; i++) {
				int sum =0; 
				for(int j=1; j<=n; j++) sum+=copymap[i][j]; 
				min_num = Math.min(sum,  min_num); 
			}
		}
		
		for(int i=1; i<=testCase; i++) {
			if(visited[i]!=0)continue; 
			visited[i] = h;
			perm(h+1); 
			visited[i] = 0; 			
		}		
	}
	
	static void rightRotate(int y, int x, int yy, int xx, int[][]copymap) {
		if(y>=yy||x>=xx) return; 			
		int temp = copymap[y][x] ; 
		int dx = x; 
		int dy = y;  
		for(int i = y+1; i<=yy; i++) copymap[i-1][x] = copymap[i][x]; 
		for(int i = x+1; i<=xx; i++) copymap[yy][i-1] = copymap[yy][i]; 
		for(int i = yy-1; i>=y; i--) copymap[i+1][xx] = copymap[i][xx]; 
		for(int i = xx-1; i> x; i--)copymap[y][i+1] = copymap[y][i]; 		
		copymap[y][x+1]= temp; 		
		rightRotate(y+1, x+1, yy-1, xx-1, copymap); 
	}
}




