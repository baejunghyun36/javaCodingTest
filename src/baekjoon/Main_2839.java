package baekjoon; 

import java.util.Scanner;

public class Main_2839 {

	static int n; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 	
		int result=0; 
		n = sc.nextInt(); 
		result += n/15*3; 
		n = n%15; 
	
		while(true){
			if(n==0)break; 
			else if(n%5==0) {
				result+=n/5; 
				break; 
			}
			else {
				n-=3; 
				result++; 
			}
		}
		if(n<0)System.out.println(-1);
		else System.out.println(result);
	}
}
