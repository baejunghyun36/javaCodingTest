package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9466 {

	static int testCase; 
	static int [] a; 
	static int [] visited;
	static int N; 
	static int cnt; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st  = null; 
		testCase = Integer.parseInt(br.readLine()); 
		for(int t = 1; t<=testCase; t++) {
			N = Integer.parseInt(br.readLine()); 
			a = new int[N+1]; 
			visited = new int [N+1]; 
			cnt = 0; 
			st = new StringTokenizer(br.readLine()); 
			for(int i=1; i<=N; i++) a[i] = Integer.parseInt(st.nextToken()); 
			for(int i=1; i<=N; i++) {				
				if(visited[i]==2)continue; 
				check(i);
			}
			sb.append(N-cnt).append("\n"); 
		}
		System.out.println(sb.toString());
	}
	static void check(int curIndex) {
		visited[curIndex] = 1; 
		int next = a[curIndex]; 
		if(visited[next]==0) check(next);
		else if (visited[next] == 1) {
			int x = next; 
			while(true) {
				cnt++; 
				x = a[x]; 
				if(x==next)break; 
			}
		}
		visited[curIndex] = 2; 
	}
}
