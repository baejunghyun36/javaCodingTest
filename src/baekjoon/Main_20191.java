package baekjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_20191 {

	static String T; 
	static String S; 
	static int [][] alpa; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in); 
		
		S = sc.next(); 
		T = sc.next(); 
		int index = 0; 
		int cnt = 1; 
		
		boolean flag = false; 
		for(int i=0; i<S.length(); i++) {
			char c = S.charAt(i); 
			
			if(T.indexOf(c,index)!=-1) { // 찾고자 하는 문자가 있다면 
				index = T.indexOf(c,index)+1; 
			}
			else {//찾고자 하는 문자가 없다면 
				index = 0; 
				cnt++; 			
				if(T.indexOf(c, index)==-1) {
					flag = true; 
					break; 
				}
				else {
					index = T.indexOf(c,index)+1; 
				}
			}
			if(index==S.length()) {
				cnt++;
				index = 0;
			} 
		}
		//if(index==S.length())cnt++; 
		if(flag)System.out.println(-1);
		else System.out.println(cnt);
		 
		

	}
	

}
