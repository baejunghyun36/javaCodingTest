package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main_2179_optimal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		int n = Integer.parseInt(br.readLine()); 
		int curL = 0; 
		Set <String> words = new HashSet<>(); 
		Map <String, Integer> pre = new HashMap<>(); // index
		ArrayList <String> list = new ArrayList<>(); 
		String answer1 = ""; 
		String answer2 = ""; 
		for(int i=0; i<n; i++) {
			String s = br.readLine(); 
			if(words.contains(s))continue; 
			for(int j=curL; j<s.length(); j++) {
				String temp = s.substring(0, j+1);
				if(pre.get(temp)!=null) {
					//존재한다. 
					if(curL<j+1) {
						curL = j+1; 											
						answer1 = list.get(pre.get(temp)); 
						answer2 = s; 						
					}
					
				}
				else {					
					pre.put(temp, i); 					
				}
			}
			words.add(s); 
			list.add(s); 
		}
		sb.append(answer1).append("\n").append(answer2); 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
		
	}

}
