package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805 {

	static int [][] map;
	static int down, up, rowSize, index, sum; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int testCase = Integer.parseInt(br.readLine());
		for(int x=1; x <= testCase; x++	) {
			int sz = Integer.parseInt(br.readLine());
			map = new int[sz+1][sz+1]; 
			for(int i=1; i<=sz; i++) {
				String s= br.readLine(); 
				for(int j=0; j<sz; j++) {
					map[i][j+1] = s.charAt(j)-'0'; 
				}
			}
			sum=0; 
			rowSize = down =1; 
			up = sz; 
			index = sz/2+1; 
			while(up>down) {
				for(int i= index ; i<index + rowSize; i++) {
					sum+=map[down][i]; 					
					sum+=map[up][i]; 
				}
				down++; up--; index--; rowSize+=2; 
			}
			for(int i=1; i<=sz; i++) sum+=map[up][i];			
			System.out.printf("#%d %d%n", x, sum);
		}
	}
}



