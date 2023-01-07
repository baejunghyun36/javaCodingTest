package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2195 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		
		String s1 = br.readLine(); 
		String s2 = br.readLine(); 
		
		int answer = 0; 
		int index = 0; 
		for(int i=0; i<s2.length(); i++) {
			if(s1.indexOf(s2.substring(index,i+1))==-1) {
				answer++; 
				index=i; 
			}			
		}	
		sb.append(answer+1); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
