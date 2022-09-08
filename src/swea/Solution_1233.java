package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_1233 {
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 	
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st; 
		
		for(int testCase=1; testCase<=10; testCase++) {
		
			st = new StringTokenizer(br.readLine()); 
			int n = Integer.parseInt(st.nextToken()); 
			String []arr = new String[n+2]; 
			int index =0;	
			int ans =1; 
			
			for(int j=0; j<n; j++) {
				st = new StringTokenizer(br.readLine()); 
				index = Integer.parseInt(st.nextToken()); 		
				
				arr[index] = st.nextToken(); 		
			
				
			}
			
			int mid = n/2; 
			
	
			for(int i=1; i<=n; i++) {
				if(arr[i].charAt(0)>='0'&&arr[i].charAt(0)<='9') {
					if(i<=mid) {
						ans=0; 
						break; 
					}
				}
				else {
					if(i>mid) {
						ans=0; 
						break; 
					}
				
				}
			}
			
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
