package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer; 


public class Main_2563 {

	public static void main(String[] args) throws IOException {

		StringBuilder sb = new StringBuilder(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t= Integer.parseInt(st.nextToken()); 
		int [][]map = new int[100][100]; 
		
		for(int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			
			for(int j=a; j<a+10; j++) {
				for(int k =b; k<b+10; k++ ) {
					if(map[j][k]==0)map[j][k] =1; 
				}
			}
			
		}
		int cnt=0; 
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]==1)cnt++; 
			}
		}
		sb.append(cnt); 
		bw.write(sb.toString());
		bw.flush();
		bw.close(); 
	}
}
