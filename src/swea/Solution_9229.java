package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_9229 {

	public static void main(String[] args) throws IOException {

		System.setIn(new FileInputStream("input.txt"));
		
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter   bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer  st = new StringTokenizer(br.readLine()); 
		StringBuilder    sb = new StringBuilder(); 
		int              tc = Integer.parseInt(st.nextToken()); 
		
			
		
		for(int testCase = 1; testCase<=tc; testCase++) {
			
			st = new StringTokenizer(br.readLine()); 
			int n = Integer.parseInt(st.nextToken()); 
			int sum = Integer.parseInt(st.nextToken()); 
			
			int [] arr = new int[n];			
			st = new StringTokenizer(br.readLine()); 
			
			for(int i=0; i<n; i++)arr[i] = Integer.parseInt(st.nextToken()); 
			
			Arrays.sort(arr); 
			
			int s =0; 
			int e = n-1; 
			int check = Integer.MAX_VALUE; 
			int ans =-1; 
			
			while(s<e) {				
				if(arr[s]+arr[e] == sum) {
					ans = sum; 
					break; 	
				}
				else if(arr[s]+arr[e]>sum) e--;					
				else { 
					if(check> Math.abs(sum-(arr[s]+arr[e]))) {						
						check = Math.abs(sum-(arr[s]+arr[e])); 
						ans = arr[s]+arr[e]; 
					}
					s++; 
				}
			}
			
			if(ans==0) ans = -1; 
			
			sb.append("#"); 
			sb.append(testCase); 
			sb.append(" "); 
			sb.append(ans); 
			sb.append("\n"); 
			
		}
		
		bw.write(sb.toString());
		bw.flush(); 
		bw.close(); 
	}
}
