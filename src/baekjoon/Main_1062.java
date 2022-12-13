package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1062 {

	static int N; 
	static int K; 
	static int [] visited; 
	static ArrayList<String> list; 
	static int answer; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		 
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());
		
		
		visited = new int[26]; 
		visited[0] = visited['n'-'a']= visited['t'-'a'] = visited['i'-'a'] = visited['c'-'a'] = 1; 
		list = new ArrayList<>(); 
		for(int i=0; i<N; i++) {
			String s = br.readLine(); 
			s = s.substring(4, s.length()-4); 
			list.add(s); 
		}
		comb(1, 0); 
		System.out.println(answer);

	}
	static void check() {
		int cnt = 0; 
		for(int i=0; i<N; i++) {
			String s = list.get(i); 
			boolean flag = true; 
			for(int j = 0; j<s.length(); j++) {
				if(visited[s.charAt(j)-'a']==0) {
					flag = false; 
					break;
				}
			}
			if(flag)cnt++; 
		}
		answer = Math.max(answer,  cnt); 
	}
	
	
	static void comb(int start, int level) {
		
		if(level == K-5) {
			check();
			return; 
		}
		
		for(int i=start; i<26; i++) {
			if(visited[i]==1)continue; 
			visited[i] = 1; 
			comb(i+1, level+1); 
			visited[i] = 0; 
		}
	}
}
