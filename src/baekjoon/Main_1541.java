package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1541 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String s= br.readLine(); 
		StringTokenizer st = new StringTokenizer(s, "-+"); 
		ArrayList<Integer> number = new ArrayList<>(); 
		ArrayList<Character> op = new ArrayList<>(); 
		
		while(st.hasMoreElements()) number.add(Integer.parseInt(st.nextToken())); 
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='-'||s.charAt(i)=='+') op.add(s.charAt(i));		
		}
		for(int i=0; i<op.size(); i++) {
			if(op.get(i)=='-') {
				for(int j=i+1; j<=op.size(); j++) {
					number.set(j, number.get(j)*-1); 
				}
			}
		}
		int sum =0; 
		for(int i=0; i<number.size(); i++)sum+=number.get(i); 
		System.out.println(sum);
	}

}
