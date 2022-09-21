package programmers;

public class Solution_자물쇠와열쇠 {
	static int [][] subLock; 
	static int [][] subKey; 
	static int width, height; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] key = {{0,0,0}, {1,0,0}, {0,1,1}}; 
		int [][] lock = {{1,1,1}, {1,1,0}, {1,0,1}}; 
		
		
		int left = 21; 
		int right = -1; 
		int up = 21; 
		int down = -1; 
		for(int i=0; i<lock.length; i++) {
			for(int j=0; j<lock.length; j++) {
				if(lock[i][j] == 0) {
					if(j<left)left = j; 
					if(j>right)right = j; 
					if(i<up) up = i; 
					if(i>down) down = i; 
				}
			}
		}
		width = right-left+1; 
		height = down-up+1; 
		subLock = new int [right-left+1][down-up+1]; 
		for(int i=up; i<=down; i++) {
			for(int j=left; j<=right; j++) {
				subLock[i-up][j-left] = lock[i][j]; 
			}
		}
		int m = key.length; 
		
		for(int i=0; i<=m-height; i++	) {
			for(int j=0; j<=m-width; j++) {
				subKey = new int[height][width]; 
				for(int k=i; k<i+height; k++) {
					for(int l=j; l<j+width; l++) {
						subKey[k-i][l-j] = key[k][l]; 
					}
				}
				for(int count= 0; count<4; count++) {
					rotate(subKey); 
					if(check (subKey)) {
				
						return true; 
						
					}
				}
				
			}
		}		

		return false; 
	}
	
	static boolean check (int [][] subKey) {
		for(int i=0; i<subKey.length; i++) {
			for(int j=0; j<subKey.length; j++) {
				if(subKey[i][j] + subLock[i][j]!=1)return false; 
			}
		}
		return true; 
	}
	static void rotate(int [][] subKey) {
		
		int [][] temp = new int [height][width]; 
		for(int i=0; i<height; i++)temp[i] = subKey[i].clone(); 
		
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				subKey[j][width-1-i] = temp[i][j]; 
			}
		}
		return; 
		
	}
	

}
