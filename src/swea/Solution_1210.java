package swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210 {
	
	static int [][] map; 
	static int [][] visited; 
	

	 public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		for(int testCase = 1; testCase<=10; testCase++) {
			int num = Integer.parseInt(br.readLine()); 
			map = new int[100][100]; 
			visited = new int[100][100]; 
			int startX = 0, startY=98; 
			for(int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
					if(map[i][j] == 2)startX = j; 
				}
			}
			while(startY>0) {
				if(startX-1>=0 && map[startY][startX-1]==1&&visited[startY][startX-1]==0) {
					visited[startY][startX--]=1; 
				}
				else if(startX+1<=99&&map[startY][startX+1]==1&&visited[startY][startX+1]==0) {
					visited[startY][startX++]=1; 
				}
				else startY--; 
			}
			System.out.printf("%d %d%n", num, startX);
		}
	}
}
