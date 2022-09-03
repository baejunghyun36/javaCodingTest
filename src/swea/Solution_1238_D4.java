package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_D4 {
	static int n; 
	static int startNumber; 
	static List <ArrayList<Integer>> node; 
	static Queue <Integer> q; 
	static int [] visited; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		for(int t = 1; t<=10; t++) {			
			
			st = new StringTokenizer(br.readLine()); 
			n = Integer.parseInt(st.nextToken()); 
			startNumber = Integer.parseInt(st.nextToken()); 			
			node = new ArrayList<ArrayList<Integer>>(); 
			q = new LinkedList<>(); 
			visited = new int [n+1]; 
			for(int i=0; i<=100; i++) {
				node.add(new ArrayList<>()); 
			}
			
			st = new StringTokenizer(br.readLine()); 
			for(int i=0; i<n/2; i++) {
				int number, to; 
				number = Integer.parseInt(st.nextToken()); 
				to = Integer.parseInt(st.nextToken()); 
				node.get(number).add(to); 
			}
			visited[startNumber]++; 
			q.offer(startNumber); 
			sb.append("#").append(t).append(" ").append(bfs()).append("\n"); 
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	static int bfs() {
		
		
		while(true) {
			
			int size = q.size(); 
			List <Integer> temp = new ArrayList<>(); 
			
			while(size-->0) {
				
				int number = q.poll(); 
				temp.add(number); 
				
				for(int i=0; i<node.get(number).size(); i++) {
					int nn = node.get(number).get(i); 
					if(visited[nn]==1)continue; 
					visited[nn] = 1; 
					q.offer(nn); 
				}
			}
			
			if(q.isEmpty()) {	
				Collections.sort(temp);
				return temp.get(temp.size()-1); 				
			}			
		}
	}
	

	

}
