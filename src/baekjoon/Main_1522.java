package gitRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1522 {
	
	static int bcnt; 
	static int answer = 987654321; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String s = br.readLine();
		int sliding = 0; 
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='b')sliding++; 
		}
		
		for(int i=0; i<s.length(); i++) {
			int cnt = 0; 
			for(int j=i; j<i+sliding; j++) {
				if(s.charAt(j%s.length())=='a')cnt++; 
			}
			answer = Math.min(cnt,  answer); 
			
		}
		System.out.println(answer);
	}

}
