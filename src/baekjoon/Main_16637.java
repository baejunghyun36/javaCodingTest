package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16637 {

	static int [] order; 
	static int length; 
	static int opCnt; 
	static char [] op; 
	static int [] number; 
	static int maxNumber; 
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		length = Integer.parseInt(br.readLine()); 
		String s = br.readLine(); 
		opCnt = length/2;
		op = new char[opCnt+1]; 
		int numIndex = 0; 
		int opIndex = 1; 
		maxNumber = Integer.MIN_VALUE;
		number = new int [length/2+1]; 
		order = new int[opCnt+1]; 
		for(int i=0; i<length; i++) {
			if(i%2==0) number[numIndex++] = s.charAt(i)-'0'; 		
			else op[opIndex++] = s.charAt(i); 			
		}
		dfs(number[0], 1); 
		System.out.println(maxNumber);
	}
	

	static void dfs(int sum, int index) {
		
		if(index>=opCnt+1) {
			maxNumber = Math.max(maxNumber, sum); 
			return; 
		}
		//괄호 추가 x 
		int x = calMethod(index, sum, number[index]);
		dfs(x, index+1); 
		
		//괄호 추가 o
		if(index+1<=opCnt) {
			x = calMethod(index+1, number[index], number[index+1]); 
			int result = calMethod(index, sum, x); 
			dfs(result, index+2); 
		}
	}
	
	static int calMethod(int opIndex, int a, int b) {
		int c = op[opIndex]; 
		if(c=='+')return a+b; 
		else if(c=='-')return a-b; 
		else return a*b; 
	}
}
