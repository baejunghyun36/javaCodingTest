package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1차프렌즈4블록 {

	static int [] dx = {0, 1, 0, 1}; 
	static int [] dy = {0, 0, 1, 1}; 
	
	
	public static void main(String[] args) {
		

		String[] board = new String [] {"TTTANT", "RRFACC", "RRRFCC",
				"TRRRAA","TTMMMF", "TMMTTJ"}; 
		int m = 6; 
		int n = 6; 
		
		System.out.println(Sol(m,n, board));;
	
		
	}

	static int Sol(int m, int n , String[] board) {
		
		int [][] map = new int[m][n]; 
		Queue <int []> q ; 
		
		for(int i=0; i<m; i++) {
			String s = board[i]; 
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j)-'A'; 
			}
		}
		
		while(true) {
			q = new LinkedList<>(); 
			
			for(int i=0; i<m-1; i++) {
				for(int j=0; j<n-1; j++) {
					int num = map[i][j]; 
					if(num==-1)continue; 
					int k; 
					for(k = 0; k<=3; k++) {
						int y = i+dy[k]; 
						int x = j+dx[k]; 
						if(map[y][x]!=num)break; 
					}
					if(k==4) {
						for(k = 0; k<=3; k++) {
							int y = i+dy[k]; 
							int x = j+dx[k]; 
							q.offer(new int [] {y,x}); 
						}						
					}
				}
			}
			
			if(q.isEmpty())break ;
			while(!q.isEmpty()) {
				int [] yx = q.poll(); 
				map[yx[0]][yx[1]] = -1; 
			}
			
			
			for(int i=0; i<n; i++) {
				int index = m-1; 
				for(int j = m-1; j>=0; j--) {
					if(map[j][i]==-1)continue; 
					if(map[j][i]!=-1) {
						map[index--][i] = map[j][i]; 
					}
				}
				for(int j = index; j>=0; j--) {
					map[j][i] = -1; 
				}
			}
		}
		
		int answer =0; 
		for(int i=0; i<m; i++) {
			System.out.println(Arrays.toString(map[i]));
			for(int j=0; j<n; j++) {
			
				if(map[i][j] ==-1)answer++; 
			}
		}
		
		return answer; 
	}
}
