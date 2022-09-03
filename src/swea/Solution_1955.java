package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_1955 {
	static int [][]map; 
	static int [] dx = {1, 0, -1, 0}; 
	static int [] dy = {0, 1, 0, -1}; 
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input/input.txt"));
		StringBuilder sb = new StringBuilder(); 
		Scanner sc = new Scanner(System.in); 
		int testCase = sc.nextInt(); 
		for(int i=1; i<=testCase; i++) {
			int N = sc.nextInt(); 
			map = new int[N][N];
			int x, y, index; 
			x=y=index=0; 
			int cnt =1;
			while(cnt<=N*N) {
				map[y][x]=cnt++; 
				int nx = x+dx[index]; 
				int ny = y+dy[index]; 
				if(nx<0||nx>=N||ny<0||ny>=N||map[ny][nx]>=1) index = (index == 3) ? 0 : index+1; 
				x+=dx[index]; 
				y+=dy[index]; 
			}
			sb.append("#"); 
			sb.append(i);
			sb.append("\n"); 
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					sb.append(map[j][k]); 
					sb.append(" "); 
				}sb.append("\n"); 
			}
		}
		System.out.println(sb.toString());
	}
}
