package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9935 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		

		
		String[] word = br.readLine().split(""); 
		String boom = br.readLine(); 


		for(String c : word) {
			sb.append(c);
			if(sb.length()>=boom.length()) {
				sb.toString().substring(sb.length()-boom.length()).equals(boom);
			}
			if(sb.toString().indexOf(boom)!=-1) {
				sb.delete(sb.toString().indexOf(boom), sb.toString().indexOf(boom)+boom.length()); 
			}
		}

		if(sb.length()==0)sb.append("FRULA"); 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
