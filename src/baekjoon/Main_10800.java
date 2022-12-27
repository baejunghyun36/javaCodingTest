package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10800 {

	static int [] colorMap; 
	static int [] sizeMap; 
	static int [] result; 
	static PriorityQueue <Ball> pq; 
	static int N; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = null; 
		StringBuilder sb = new StringBuilder(); 
		N = Integer.parseInt(br.readLine()); 
		pq = new PriorityQueue<>(); 
		colorMap = new int [N+1]; 
		result = new int[N+1]; 
		sizeMap = new int[2001]; 
		
		ArrayList <Ball> list = new ArrayList<>(); 
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()); 
			int color = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken()); 
			Ball ball = new Ball(i, color, size);
			list.add(ball); 
		 
		}
		
		Collections.sort(list);
		int j = 0; 
		int sum = 0; 
		for(int i=0; i<N; i++) {
			
			Ball a = list.get(i); 
			Ball b = list.get(j); 
			
			while(b.size<a.size) {
				sum+=b.size; 
				colorMap[b.color]+=b.size; 
				b=list.get(++j); 
			}
			result[a.number] = sum-colorMap[a.color]; 
		}
		

	
		for(int i=1; i<=N; i++) {
			sb.append(result[i]).append("\n"); 
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static class Ball implements Comparable<Ball> {
		
		int number; 
		int color; 
		int size; 
		
		public Ball (int number, int color, int size) {
			this.number = number; 
			this.color = color; 
			this.size = size; 
		}
		
		public int compareTo(Ball ball) {

			return this.size - ball.size; 
		}
		
	}
}
