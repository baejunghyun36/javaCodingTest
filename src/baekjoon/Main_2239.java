package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_2239 {

	static int [][] rowArray; 
	static int [][] colArray; 
	static int [][] squareArray; 
	static int [][] map; 
	static ArrayList <int []> list ; 
	public static void main(String[] args) {

		list = new ArrayList<>(); 
		Scanner sc = new Scanner(System.in); 
		
		rowArray = new int [9][10]; 
		colArray = new int [9][10]; 
		squareArray = new int[9][10]; 
		map = new int [9][9]; 
		for(int i=0; i<9; i++) {
			String s = sc.next(); 
			for(int j=0; j<9; j++) {
				map[i][j] = s.charAt(j)-'0'; 
				if(map[i][j]!=0) {					
					rowArray[i][map[i][j]] = 1;
					colArray[j][map[i][j]] = 1;
					squareArray[(i/3)*3+j/3][map[i][j]]=1; 
				}
				else list.add(new int [] {i, j}); 
			}
		}
		
		backTracking(0);		
		
		//0 1 2
		//3 4 5
		//6 7 8
	
	}
	static void backTracking(int start) {		
		// i = row, j = col
		if(start ==list.size()) {
			StringBuilder sb = new StringBuilder(); 
			for(int i=0; i<=8; i++) {
				for(int j=0; j<=8; j++) {
					sb.append(map[i][j]); 
				}sb.append("\n"); 
			}
			System.out.println(sb.toString());
			System.exit(0);
		}
		int [] yx = list.get(start); 
		int row = yx[0]; 
		int col = yx[1]; 
		for(int j=1; j<=9; j++) {
			if(rowArray[row][j]==0&&colArray[col][j]==0&&squareArray[(row/3)*3+col/3][j]==0) {
				rowArray[row][j] = colArray[col][j] = squareArray[(row/3)*3+col/3][j] = 1; 
				map[row][col] = j; 
				backTracking(start+1); 
				rowArray[row][j] = colArray[col][j] = squareArray[(row/3)*3+col/3][j] = 0; 
			}
		}
	}
}
