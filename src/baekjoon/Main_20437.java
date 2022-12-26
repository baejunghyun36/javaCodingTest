package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main_20437 {

	static int testCase; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		testCase = Integer.parseInt(br.readLine()); 
		while(testCase-->0) {
			int minLen = 987654321; 
			int maxLen = -1; 
			int [] alpa = new int[26]; 
			LinkedList<Integer> list[] = new LinkedList[26]; 
			for(int i=0; i<26; i++) list[i] = new LinkedList<>(); 
		 
			char[] s = br.readLine().toCharArray();
			int k = Integer.parseInt(br.readLine()); 
			for(int i=0; i<s.length; i++) {
				alpa[s[i]-'a']++;
				list[s[i]-'a'].add(i); 
			} 
			for(int i=0; i<26; i++) {
				if(alpa[i]>=k) {
					for(int j=0; j<=list[i].size()-k; j++) {
						minLen = Math.min(list[i].get(j+k-1)-list[i].get(j)+1, minLen); 
						maxLen = Math.max(list[i].get(j+k-1)-list[i].get(j)+1, maxLen);
					}
				}
			}
			if(minLen==987654321)System.out.println(-1);
			else System.out.println(minLen+" "+maxLen);
		}
	}
}
