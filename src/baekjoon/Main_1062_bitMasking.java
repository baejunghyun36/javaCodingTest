package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1062_bitMasking {

	static int N, K; 
	static ArrayList<String> list; 
	static int answer, visited; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		visited |= 1; 
		visited |= 1<<('n'-'a'); 
		visited |= 1<<('t'-'a'); 
		visited |= 1<<('i'-'a'); 
		visited |= 1<<('c'-'a'); 
		 
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());
		
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
			int temp = 0; 
			for(int j = 0; j<s.length(); j++) temp |= 1<<s.charAt(j)-'a'; 
			if((visited&temp)==temp)cnt++; 
		}
		answer = Math.max(answer,  cnt); 
	}
	
	
	static void comb(int start, int level) {
		
		if(level == K-5) {
			check();
			return; 
		}
		
		for(int i=start; i<26; i++) {
			if((visited&(1<<i))!=0)continue; 
			visited|=1<<i; 
			comb(i+1, level+1); 
			visited^=1<<i;  
		}
	}
}
