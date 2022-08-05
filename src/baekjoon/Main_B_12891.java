package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException; 

public class Main_B_12891 {

	static Map <Character, Integer> m = new HashMap<>(); 
	static int[] arr = new int[4]; 
	static int [] temp = new int[4];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
	
		int length = Integer.parseInt(st.nextToken()); 
		int subStringLength = Integer.parseInt(st.nextToken());
		int cnt= 0; 
		
		String s= br.readLine(); 
		
		st = new StringTokenizer(br.readLine(), " "); 		 
		for(int i=0; i<4; i++) arr[i] = Integer.parseInt(st.nextToken()); 
		
		m.put('A', 0); 
		m.put('C', 1); 
		m.put('G', 2); 
		m.put('T', 3); 
		
		for(int i=0; i<subStringLength; i++) temp[m.get(s.charAt(i))]++;		
		if(check()) cnt++; 
		
		for(int i=1; i<=s.length()-subStringLength; i++) {
			temp[m.get(s.charAt(i-1))]--; 
			temp[m.get(s.charAt(i+subStringLength-1))]++;
			if(check()) cnt++; 			
		}
		
		System.out.println(cnt);
	}
	

	
	
	
	
	
	static boolean check() {
		if (temp[0]>=arr[0]&&temp[1]>=arr[1]&&temp[2]>=arr[2]&&temp[3]>=arr[3])return true; 
		return false; 
	}

}













