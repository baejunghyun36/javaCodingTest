package swea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution_1208
{
	public static void main(String args[]) throws Exception
	{
		int T=10;
		int [] arr = new int[101]; 
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
	for(int test_case = 1; test_case <= T; test_case++)
	{
		int n= Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<100; i++) {
			arr[i+1] = Integer.parseInt(st.nextToken()); 
		}
		for(int i=0; i<n ; i++) {
			Arrays.sort(arr);
			if(arr[100]==arr[1])break; 
			arr[1]++; 
			arr[100]--; 
		}
		Arrays.sort(arr);
		System.out.printf("#%d %d%n", test_case, arr[100]-arr[1]);
	}
  }
}