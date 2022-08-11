package baekjoon;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_3040 {

	static int [] hat;
	static int [] number; 
	static boolean flag; 
	static StringTokenizer st; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		Scanner sc = new Scanner(System.in); 
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		hat = new int[9]; 
		number = new int[9]; 
		for(int i=0; i<9; i++) hat[i] = sc.nextInt(); 
		comb(0, 0, 0); 
		

	}
	
	static void comb(int cnt, int sum, int index) {
		
		if(sum==100 && index==7)
		{
			if(flag==false) {
				for(int i=0; i<index; i++) {
					System.out.println(number[i]);
				}
				flag=true; 
			}
		
		}
		if(cnt==9||sum>100) return; 
		if(hat[cnt]>0) {
			number[index] = hat[cnt]; 
			comb(cnt+1, sum+hat[cnt], index+1); 
		}
		comb(cnt+1, sum, index); 
	}

}
