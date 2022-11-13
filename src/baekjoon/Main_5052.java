package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class Main_5052 {
	static ArrayList <String> list; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringBuilder sb = new StringBuilder(); 
		int testCase = Integer.parseInt(br.readLine()); 
		for(int t = 1; t<=testCase; t++) {
			int n = Integer.parseInt(br.readLine()); 
			list = new ArrayList<>(); 
			for(int i=0; i<n; i++) list.add(br.readLine()); 
			Collections.sort(list); 
			boolean flag = false;
			for(int i=1; i<n; i++) {
				String s1 = list.get(i-1); 
				String s2 = list.get(i); 
				if(s2.indexOf(s1)==0) {
					flag = true; 
					break; 
				}				
			}
			if(flag) sb.append("NO").append("\n");			
			else sb.append("YES").append("\n"); 			
		}
		System.out.print(sb.toString());
	}
	
}
