package baekjoon;

import java.util.Scanner;

public class Main_1074 {
	
	static int N; 
	static int r, c; 
	static int number; 
	static int [] dx= {0,1,0,1}; 
	static int [] dy= {0,0,1,1}; 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); 
		r = sc.nextInt(); 
		c = sc.nextInt(); 
		
		number = 1; 
		for(int i=0; i<N; i++) number*=2; 
		func(number, 0, 0, 0 ); 

	}
	static void func(int n, int y, int x, int startNumber) {
		
		if(n==2) {			
			for(int i=0; i<4; i++) {
				if(dx[i]+x==c&&dy[i]+y==r) System.out.println(startNumber);
				startNumber++; 
			}
		}
		
		int sz = n/2; 
		
		//1사분면
		if((y<=r&&y+(n/2)-1>=r)&&(x<=c&&x+(n/2)-1>=c)) func(n/2, y, x, startNumber); 		
		//2사분면 
		else if(x+n/2<=c&&x+n-1>=c&&y<=r&&r<=y+(n/2-1)) func(n/2, y, x+n/2, startNumber+(sz*sz)); 	
		//3사분면
		else if(x<=c&&x+(n/2)-1>=c&& y+n/2<=r&&r<=y+n-1) func(n/2, y+n/2, x, startNumber+(sz*sz)*2); 		
		//4사분면
		else if(x+n/2<=c&&x+n-1>=c&&y+n/2<=r&&r<=y+n-1) func(n/2, y+n/2, x+n/2, startNumber+(sz*sz)*3); 
		
	}
}
