package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_16935 {

	static int [][] map; 
	static int m;
	static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder(); 
		
		m = Integer.parseInt(st.nextToken()); 
		n = Integer.parseInt(st.nextToken()); 
		int calCnt = Integer.parseInt(st.nextToken()); 
        map = new int[100][100]; 

		
		for(int i=0; i<m; i++) {
			 st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<n; j++) {
				map[i][j] =Integer.parseInt(st.nextToken()); 
			}
		}
		
		int [] temp = map[0]; 
		
		
		st = new StringTokenizer(br.readLine()); 
		for(int i=0; i<calCnt; i++) {
			int num= Integer.parseInt(st.nextToken());
			switch(num) {
			case 1 : function1();  break; 
			case 2 : function2();  break; 
			case 3 : function3();  break;
			case 4 : function4();  break; 
			case 5 : function5();  break; 
			case 6 : function6();  break; 
			}
		}
		
		for(int i=0; i<m; i++) {		
			for(int j=0; j<n; j++) {
				sb.append(map[i][j]).append(" "); 
			}sb.append("\n"); 
		}
		bw.write(sb.toString());
		bw.flush(); 
		bw.close(); 
		
	}

	static void function1() {
		for(int i=0; i<n; i++) {
			int s =0; 
			int e = m-1; 
			while(s<e) {
				int temp = map[s][i]; 
				map[s++][i] = map[e][i]; 
				map[e--][i] = temp; 	
			}
		}
	}
	
	static void function2() {
		for(int i=0; i<m; i++) {
			int s = 0; 
			int e = n-1; 
			while(s<e) {
				int temp = map[i][s]; 
				map[i][s++] = map[i][e]; 
				map[i][e--] = temp; 
			}
		}
	}
	static void function3() {
		int [][]temp = new int [n][m]; 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp[i][j] = map[m-j-1][i]; 
			}
		}
		int t = m; 
		m= n; 
		n= t; 
		map = temp; 		
	}
	static void function4() {
		int [][]temp = new int [n][m]; 
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp[i][j] = map[j][n-i-1]; 
			}
		}
		int t = m; 
		m = n; 
		n = t; 
		map = temp;
	}
	static void function5() {
		//1사분면 x : 0 ~ n/2-1 | y: 0 ~  m/2 -1 
		//2사분면 x : x : n/2 ~ n-1 |  y :0 ~ m/2 -1
		//3사분면 x : 0 ~ n/2-1 | y: m/2 ~ m-1 
		//4사분면 x : n/2 ~ n-1 |  y : m/2 ~ m-1; 
		int [][]temp = new int [m/2][n/2]; 
		for(int i=0; i<m/2; i++) {
			for(int j=0; j<n/2; j++) {
				temp[i][j] = map[i][j]; 
			}
		}
		//1사분면에 넣기 
		for(int i=0; i<=m/2 -1; i++) {
			for(int j=0; j<=n/2 -1; j++) {
				map[i][j] = map[i+m/2][j]; 
			}
		}
		
		//3사분면에 넣기 
		for(int i=m/2; i<=m-1; i++) {
			for(int j=0; j<=n/2-1; j++) {
				map[i][j] = map[i][j+n/2]; 
			}
		}
		
		//4사분면에 넣기 
		for(int i=m/2; i<=m-1; i++) {
			for(int j=n/2; j<=n-1; j++) {
				map[i][j] = map[i-(m/2)][j]; 
			}
		}
	
		//2사분면에 넣기 
		for(int i = 0; i<=m/2-1; i++	) {
			for(int j= n/2; j<=n-1; j++) {
				map[i][j] = temp[i][j-n/2]; 
			}
		}
	}
	static void function6() {
		int [][]temp = new int [m/2][n/2]; 
		for(int i=0; i<m/2; i++) {
			for(int j=0; j<n/2; j++) {
				temp[i][j] = map[i][j]; 
			}
		}
		//2->1
		for(int i=0; i<=m/2-1; i++) {
			for(int j=0; j<=n/2-1; j++) {
				map[i][j] = map[i][j+n/2]; 
			}
		}
		//4->2
		for(int i=0; i<=m/2-1; i++) {
			for(int j=n/2; j<=n-1; j++) {
				map[i][j] = map[i+m/2][j]; 
			}
		}
		//3->4
		for(int i=m/2; i<=m-1; i++) {
			for(int j=n/2; j<=n-1; j++) {
				map[i][j] = map[i][j-n/2]; 
			}
		}
		//temp->3
		for(int i=m/2; i<=m-1; i++	) {
			for(int j=0; j<=n/2-1; j++) {
				map[i][j] = temp[i-(m/2)][j]; 
			}
		}
	}
}
