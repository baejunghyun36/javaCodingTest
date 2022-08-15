package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1010 {

	static BufferedReader br; 
	static BufferedWriter bw; 
	static StringBuilder sb; 
	static StringTokenizer st; 
	static int[][]arr; 
	static int testCase; 
	static int west, east; 
	static long answer; 

	public static void main(String[] args) throws IOException {
		input(); 	
		ouput(); 
	}
	
	static int logic(int e, int w) {
		if(arr[e][w]>0)return arr[e][w]; 
		if(e==w||w==0)return arr[e][w] =1; 
		return arr[e][w] = logic(e-1,w)+ logic(e-1,w-1); 
		
	}

	static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in)); 
		bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		st = new StringTokenizer(br.readLine()); 
		sb = new StringBuilder(); 	
		arr = new int[30][30]; 
		testCase = Integer.parseInt(st.nextToken()); 
		
		for(int i=0; i<testCase; i++) {
			answer=1; 
			st = new StringTokenizer(br.readLine()); 
			west = Integer.parseInt(st.nextToken()); 
			east = Integer.parseInt(st.nextToken()); 
			arr = new int[30][30]; 
			sb.append(logic(east, west)).append("\n"); 
		}
	}
	
	static void ouput() throws IOException {
		bw.write(sb.toString()); 
		bw.flush();
		bw.close();
	}
}
