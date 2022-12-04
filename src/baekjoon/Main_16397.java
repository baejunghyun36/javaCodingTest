package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16397 {

	static int overNumber; 
	static int N ,T, G; 
	static Queue <int []> q; 
	static int [] visited; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		T = Integer.parseInt(st.nextToken()); 
		G = Integer.parseInt(st.nextToken()); 
		overNumber = 99999; 
		q = new LinkedList<>(); 
		visited = new int[100000]; 
	
		q.add(new int[] {N, 0}); 
		System.out.println(bfs()); 
		
	}
	static String bfs() {
		
		while(!q.isEmpty()) {
			int [] temp = q.poll(); 
			int curNumber = temp[0]; 
			int cnt = temp[1]; 
			if(curNumber==G)return cnt+""; 
			if(cnt==T)continue; 
		
			if(curNumber+1<=overNumber&&visited[curNumber+1]!=1)buttonA(curNumber, cnt); 
			if(curNumber*2<=overNumber&&curNumber!=0)buttonB(curNumber, cnt); 
		}
		return "ANG"; 
	}
	static void buttonA(int number, int cnt) {
		q.add(new int[] {number+1, cnt+1}); 
		visited[number+1] = 1; 
		return; 
	}
	static void buttonB(int number, int cnt) {
		number *=2; 
		String s = Integer.toString(number); 
		char[] ss = s.toCharArray(); 
		ss[0] = (char) ((ss[0]-'0'-1)+'0'); 
		s = String.valueOf(ss); 
		q.add(new int[] {Integer.parseInt(s), cnt+1}); 
		visited[Integer.parseInt(s)]=1; 
		return; 
	}
}

