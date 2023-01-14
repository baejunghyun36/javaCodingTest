package gitRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1253 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 

		
		int n = Integer.parseInt(br.readLine()); 
		ArrayList<Integer> list = new ArrayList<>(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		for(int i=0; i<n; i++) {			
			list.add(Integer.parseInt(st.nextToken())); 			
		}
		Collections.sort(list);
		int cnt= 0; 
		for(int i=0; i<list.size(); i++) {
			
			
			int start = 0; 
			int end = list.size()-1;  
			int x = list.get(i); 
			
			while(start<end) {
				if(start==i) {
					start++; 
					continue; 
				}
				if(end==i) {
					end--; 
					continue; 
				}
				
				if(list.get(start)+list.get(end)==x) {
					//System.out.println(list.get(i));
					
					cnt++; 
					break;
				}
				if(list.get(start)+list.get(end)<x) {
					start++; 
				}
				else if(list.get(start)+list.get(end)>x) {
					end--; 
				}
			}
		}
		sb.append(cnt); 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static class Node implements Comparable<Node>{
		int x;

		public Node(int x) {
			super();
			this.x = x;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.x - o.x; 
		} 
		
		
	}

}
