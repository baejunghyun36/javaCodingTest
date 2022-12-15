package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main_2138 {
	static int N; 
	static String s1, s2; 
	static int cnt1, cnt2; 
	static Queue <int []> q; 
	static int [] visited; 
	static String[] ss = {"110", "111", "011"}; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine()); 
		s1 = br.readLine(); 
		s2 = br.readLine(); 
		
		char [] a = s1.toCharArray(); 
		char [] b = s1.toCharArray(); 
		char [] c = s2.toCharArray(); 
		
		//첫번째 스위치 눌렀을 때 
		for(int j=0; j<=1; j++) {
			if(a[j]=='0')a[j] = '1'; 
			else a[j] = '0'; 
		}
		
		int cnt1 = check(a, c, 1); 
		int cnt2 = check(b, c, 0); 
		if(cnt1==-1&&cnt2==-1)System.out.println(-1);
		else {
			if(cnt1!=-1&&cnt2!=-1)System.out.println(Math.min(cnt1, cnt2));
			else if(cnt1==-1)System.out.println(cnt2);
			else if(cnt2==-1)System.out.println(cnt1);
		}
	}
	static int check(char [] a, char [] b, int cnt) {

		for(int i=0; i<s1.length()-2; i++) {
			if(a[i]!=b[i]) {
				cnt++;
				for(int j=i; j<=i+2; j++) {
					if(a[j]=='0')a[j] = '1'; 
					else a[j] = '0'; 
				}
			}
		}
		int i = s1.length()-2; 
		if(a[i]!=b[i]) {
			cnt++; 
			for(int j=i; j<=i+1; j++) {
				if(a[j]=='0')a[j] = '1'; 
				else a[j] = '0'; 
			}
		}
		if(a[s1.length()-1]==b[s1.length()-1]) return cnt; 
		else return -1; 
	}
}
