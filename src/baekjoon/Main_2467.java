package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2467 {

	static int n; 
	static int [] info;
	static int minusEnd; 
	public static void main(String[] args) throws IOException {
	
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		
	
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		info = new int[n]; 
		
		for(int i=0; i<n; i++) {
			info[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int sum = Integer.MAX_VALUE; 
		int [] answer = new int[2]; 
		
		int start = 0; 
		int end = n-1; 
		while(start < end) {
			
			int s = info[start] +info[end]; 
			
			if(sum>Math.abs(s)) {
				answer[0] = info[start]; 
				answer[1] = info[end];
				sum = Math.abs(s); 				
			}
			if(sum==0)break; 
			if(s<0) start++; 			
			else end--; 	
		}
		
		sb.append(answer[0]).append(" ").append(answer[1]); 
 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
}
