package gitRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_12919 {

	static String start; 
	static String end; 
	static int result;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		
		start = br.readLine(); 
		end = br.readLine(); 			

		check(end); 
		sb.append(result); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	
	static void check(String s) {
		
		//System.out.println(s);
		if(s.equals(start)) {
			result = 1; 
			return; 
		}
		if(s.length()==1) {
			return; 
		}
		if(s.charAt(s.length()-1)=='A') {
			check(s.substring(0, s.length()-1)); 
		}
		if(s.charAt(0)=='B') {
			StringBuffer sb = new StringBuffer(s.substring(1)); 
			check(sb.reverse().toString()); 
			
		}
	
	
		
		
	}

}
