package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808 {
	static int winCnt; 
	static int loseCnt; 
	static int []a; 
	static int []b; 
	static int []visited; 
	
	static void dfs(int sumA, int sumB, int index) {
		
		if(index==9) {
			if(sumA<sumB) loseCnt++;
			else if(sumA>sumB) winCnt++;
			return; 
		}
		
		for(int i=0; i<9; i++) {
		
			if(visited[i]==1)continue; 
			visited[i] = 1; 
			if(a[index]>b[i]) dfs(sumA+a[index]+b[i], sumB, index+1);		
			else if(a[index]<b[i]) dfs(sumA, a[index]+b[i]+sumB, index+1); 
			visited[i]=0; 
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("input.txt")); 
		StringBuilder sb = new StringBuilder(); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken()); 
		
		for(int t = 1; t<=testCase; t++) {
			
			a = new int[9]; 
			b = new int[9]; 
			visited = new int[9]; 
			int []check = new int[20]; 
			
			st = new StringTokenizer(br.readLine()); 
			
			for(int i=0; i<9; i++) {
				a[i] = Integer.parseInt(st.nextToken()); 
				check[a[i]] =1;  
			}
			int index=0; 				
			for(int i=1; i<=18; i++) if(check[i]==0) b[index++]=i; 
				
			dfs(0,0,0); 
			sb.append("#").append(t).append(" ").append(winCnt).append(" ").append(loseCnt).append("\n");
			winCnt=loseCnt =0; 
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}