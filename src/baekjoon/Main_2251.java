package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class Main_2251 {	

	static int [] visited1 = new int[200]; 
	static int [][]visited2 = new int[200][200];  
	static int A;
	static int B;
	static int C; 
	static HashSet <Integer> s = new HashSet<Integer>() ; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 		
		A = sc.nextInt(); 
		B = sc.nextInt(); 
		C = sc.nextInt(); 	
		dfs(0,0,C,3); 
		for(Integer x : s)System.out.print(x+" ");
	}
	static void dfs(int a, int b, int c, int start) {
		
		if(a==0)s.add(c); 
		if (visited1[a]==1&& visited2[b][c]==1)return; 
		visited1[a]=1; 
		visited2[b][c]=1; 
		
		//물통 A에서 물통 B로 옮길 때
		if (b + a > B) 	dfs(a - (B - b), B, c, 2);
		else dfs(0, b + a, c, 2);
		//물통 A에서 물통 C로 옮길 때
		if (c + a > C) 	dfs(a - (C - c), b, C, 3);
		else dfs(0, b, c + a, 3);

		//물통 B에서 물통 A로 옮길 때
		if (b + a > A) 	dfs(A, b - (A - a), c, 1);
		else dfs(a + b, 0, c, 2);
		
		//물통 B에서 물통 C로 옮길 때
		if (b + c > C) 	dfs(a, b - (C - c), C, 3);
		else dfs(a, 0, c + b, 1);

		//물통 C에서 물통 A로 옮길 때
		if (a + c > A) 	dfs(A, b, c - (A - a), 1);
		else dfs(a + c, b, 0, 1);
		//물통 C에서 물통 B로 옮길 때
		if (b + c > B) 	dfs(a, B, c - (B - b), 2);
		else dfs(a, b + c, 0, 2); 
		
	}
}