package programmers;

public class Solution_리트플렌즈사천성 {

	public static void main(String[] args) {
		
		int m = 4; 
		int n = 4; 
		
		String []board = {".ZI.", "M.**", "MZU.", ".IU."}; 
		
		char [][] map = new char[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {			
				map[i] = board[i].toCharArray(); 
			}
		}
		
		

	}

}
