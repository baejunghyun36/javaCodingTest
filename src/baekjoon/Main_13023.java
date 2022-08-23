package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13023 {
	static Queue <Integer> q; 
	static int m, n; 
	static int [] visited; 
	static List <ArrayList<Integer>> node;  
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); 
		int edge = Integer.parseInt(st.nextToken()); 
		
		 node = new ArrayList<ArrayList<Integer>>(); 
		 for(int i=0; i<n; i++)node.add(new ArrayList<Integer>()); 
		

		 
		for(int i=0; i<edge; i++) {
			st = new StringTokenizer(br.readLine()); 
			int a,b; 
			a = Integer.parseInt(st.nextToken()); 
			b = Integer.parseInt(st.nextToken()); 
			node.get(a).add(b); 
			node.get(b).add(a); 
		}
		
		
		for(int i=0; i<n; i++) {
			visited = new int [n]; 
			visited[i] = 1; 
			dfs(i, 0); 
		}
		sb.append(0); 
		System.out.println(sb.toString());
	}
	
	static void dfs(int num, int level) {
		
	   if(level==4) {
		   System.out.println(1);
		   System.exit(0);
     	}
	   
	   for(int i=0; i<node.get(num).size(); i++) {
		   int index = node.get(num).get(i); 
		   if(visited[index]==1)continue; 
		   visited[index]=1; 
		   dfs(index, level+1);
		   visited[index] =0; 
	   }

	}
}
