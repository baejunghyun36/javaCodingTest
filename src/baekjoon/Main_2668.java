package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2668 {

	static int N; 
	static int [] visited; 
	static int [] map; 
	static boolean flag; 
	static ArrayList<Integer> answer; 
	static Set <Integer>set; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		set = new HashSet<>(); 
		N = Integer.parseInt(br.readLine()); 
		answer = new ArrayList<>(); 
		map = new int[N+1]; 
		for(int i=1; i<=N; i++) {
			map[i] = Integer.parseInt(br.readLine()); 
		}
		int cnt = 0; 
		for(int i=1; i<=N; i++) {
			visited = new int[N+1]; 
			flag = false; 
			visited[i] = 1; 
			check(i, i); 
			if(flag==true) {
				for(int j=1; j<=N; j++) {
					if(visited[j]==1)set.add(j); 
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>(); 
		for(int x : set)list.add(x); 
		Collections.sort(list);

		sb.append(list.size()).append("\n"); 
		for(int x : list)sb.append(x).append("\n"); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void check(int start, int cur) {
		
		if(start == map[cur]) {
			flag = true; 
			return; 
		}
		
		int next = map[cur]; 
		if(visited[next]!=1) {
			visited[next] = 1; 
			check(start, next); 
		}
		
	}
	


}
