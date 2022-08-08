package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_1158 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		StringBuilder sb = new StringBuilder(); 
		int n= Integer.parseInt(st.nextToken()); 
		int order = Integer.parseInt(st.nextToken()); 
		
		Queue <Integer> q = new LinkedList<>(); 
		
		for(int i=0; i<n; i++) q.add(i+1); 
		
		sb.append("<"); 
		while(q.size()>1) {
			for(int j=1; j<order; j++) q.offer(q.poll());			
			sb.append(q.poll()).append(", "); 
		}
		
		sb.append(q.poll()).append(">"); 

		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
