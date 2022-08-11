package baekjoon;

import java.util.Scanner;

public class Main_2961 {

	static int[][] arr; 
	static int n;
	static int minNumber; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Scanner sc = new Scanner (System.in); 
		n = sc.nextInt(); 
		arr = new int[n][2]; 
		minNumber = Integer.MAX_VALUE; 
		for(int i=0; i<n; i++) {	
			arr[i][0] = sc.nextInt(); 
			arr[i][1] = sc.nextInt(); 
		}
		
		comb(0, 1, 0); 
		System.out.println(minNumber);
	}
	
	
	static void comb(int i, int aSum, int bSum) {
		
		if(bSum!=0) {
			if(minNumber>Math.abs(aSum-bSum)) {
				minNumber = Math.min(Math.abs(aSum-bSum), minNumber); 
			}
		}
	
		if(i==n) {
			return; 
		}
		
		comb(i+1,aSum*arr[i][0], bSum+arr[i][1]); 
		comb(i+1, aSum, bSum); 
	}
	
	
	
	

}
