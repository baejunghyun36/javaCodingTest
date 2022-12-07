package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1759 {
	static int level; 
	static int alpaCnt; 
	static char [] alpa; 
	static char [] temp; 
	static StringBuilder sb ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder(); 
		level = sc.nextInt(); 
		alpaCnt = sc.nextInt(); 		
		alpa = new char[alpaCnt]; 
		temp = new char[level]; 
		for(int i=0; i<alpaCnt; i++) {
			alpa[i] = sc.next().charAt(0); 
		}
	
		Arrays.sort(alpa);	
	    dfs(0, 0, 0, 0); 		
	    
		System.out.println(sb.toString());
		
		sc.close();
	}
	
	static void dfs(int start, int cnt,  int a, int b) {
		
		if(cnt==level) {	
			if(a>=1&&b>=2) {
				for(int i=0; i<level; i++) sb.append(temp[i]); 				
				sb.append("\n");				
			}
			return; 
		}		
		
		for(int i=start; i<alpaCnt; i++) {
			char c= alpa[i]; 
			temp[cnt] = c; 
			if(c=='a'||c=='i'||c=='e'||c=='o'||c=='u') dfs(i+1, cnt+1, a+1, b); 
			else dfs(i+1, cnt+1, a, b+1); 
		}
	}
	

}
