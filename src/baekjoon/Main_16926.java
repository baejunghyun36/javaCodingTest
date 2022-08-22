package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16926 {

	static int m; 
	static int n; 
	static int rotate; 
	static int [][] map; 
	static int [][] visited; 
	static BufferedReader br; 
	static BufferedWriter bw; 
	static StringBuilder sb ; 
	
	public static void main(String[] args) throws IOException {
	
		
		
		input(); 
		
		
		
		for(int i=0; i<rotate; i++) leftRotate(0,0, m-1, n-1);
		
		outPut(); 
		
	}
	
	
	
	static void leftRotate(int y, int x, int yy, int xx) {
		
		if(y>=yy||x>=xx)return; 
		int temp = map[y][x] ; 
		int dx = x; 
		int dy = y; 
		
		for(int i=x+1; i<=xx; i++) map[y][i-1]=map[y][i]; 
		for(int i=y+1; i<=yy; i++) map[i-1][xx]= map[i][xx]; 
		for(int i=xx-1; i>=x; i--) map[yy][i+1] = map[yy][i]; 
		for(int i=yy; i>y; i--) map[i][x] = map[i-1][x]; 
		
		map[y+1][x]= temp; 
		leftRotate(y+1, x+1, yy-1, xx-1); 
	}
	
	

	
	static void input() throws IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in)); 
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		sb = new StringBuilder(); 
		
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		m = Integer.parseInt(st.nextToken()); 
		n = Integer.parseInt(st.nextToken()); 
	    rotate = Integer.parseInt(st.nextToken()); 
		map = new int[m][n];  
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	
	static void outPut() throws IOException {		
		for(int i=0; i<m; i++) {		
			for(int j=0; j<n; j++) {
				sb.append(map[i][j]).append(" "); 
			}sb.append("\n"); 
		}		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}


