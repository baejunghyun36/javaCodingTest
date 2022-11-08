package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1043 {

	static int N, M; 
	static int truePerson; 
	static int []trueArray; 
	static ArrayList <Integer>[] list; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in))	; 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		st = new StringTokenizer(br.readLine()); 
		int check = 0; 
		trueArray = new int[N+1]; 
		while(st.hasMoreTokens()) {
			if(check == 0) {
				check = 1; 
				truePerson = Integer.parseInt(st.nextToken()); 
			}
			else {
				int num = Integer.parseInt(st.nextToken()); 
			}
		}
		list = new ArrayList[N+1]; 
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>(); 
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			int n = Integer.parseInt(st.nextToken()); 
			int [] person = new int[n]; 
			for(int j=0; j<n; j++) {
				person[j] = Integer.parseInt(st.nextToken()); 
			}
			for(int j=0; j<n; j++) {
				for(int k=0; k<n; k++) {
					if(j==k)continue; 
					list[j].add(person[k]); 
				}
			}
		}
		

	}

}
