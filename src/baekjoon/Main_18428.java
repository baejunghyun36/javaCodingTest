package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18428 {

	static int N; 
	static ArrayList<int []> oracleList; 
	static ArrayList<int []> teacherList; 
	static char[][] map; 
	static boolean flag; 
	static int [] dx = {0,0,1,-1}; 
	static int [] dy = {1,-1,0,0}; 
	static int totalStudent; 
	static int ch; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine()); 
		map = new char[N][N]; 
		StringTokenizer st = null; 
		oracleList = new ArrayList<>(); 
		teacherList = new ArrayList<>(); 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {	
				map[i][j] = st.nextToken().charAt(0); 
				if(map[i][j] == 'X') oracleList.add(new int[] {i, j}); 
				else if(map[i][j] == 'T') teacherList.add(new int[] {i,j}); 
				else totalStudent++; 
			}	
		}
		comb(0, 0); 
		if(flag)System.out.println("YES");
		else System.out.println("NO");
		
	}
	
	static void check() {
		ch++; 
		int [][] visited = new int [N][N]; 
		int cnt = 0; //student count
		for(int i=0; i<teacherList.size(); i++) {
			int [] yx = teacherList.get(i); 
		 

			for(int j = 0; j<4; j++) {
				int ty = yx[0]; 
				int tx = yx[1]; 
				while(true) {
					ty+=dy[j]; 
					tx+=dx[j]; 
					if(ty<0||ty>=N||tx<0||tx>=N)break; 
					if(map[ty][tx]=='O')break; 
					if(visited[ty][tx]==1)continue; 
					if(map[ty][tx]=='S')cnt++; 	
					visited[ty][tx] = 1; 
				}
			}			
		}
		if(cnt==0) flag = true; 
			
		
	}

	static void comb(int start, int level) {
		
		if(level==3) {
			check(); 
			return; 
		}
		for(int i=start; i<oracleList.size(); i++) {
			int [] yx = oracleList.get(i); 
			map[yx[0]][yx[1]] = 'O'; 
			if(!flag)comb(i+1, level+1); 
			map[yx[0]][yx[1]] = 'X'; 
		}
	}
}
