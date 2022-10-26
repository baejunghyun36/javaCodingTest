package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution_1차뉴스클러스터링 {

	static Map <String, Integer> aMap; 
	static Map <String, Integer> bMap; 
	static Set <String> set; 
	
	
	public static void main(String[] args) {
		
		String s1 = "FRANCE"; 
		String s2 = "french"; 
		s1 = s1.toUpperCase(); 
		s2 = s2.toUpperCase();
		
		//16384
		
	
		
		
		aMap = new HashMap <>(); 
		bMap = new HashMap <>(); 		
		set = new HashSet <>(); 
		ArrayList <String> aList = new ArrayList<>(); 
		ArrayList <String> bList = new ArrayList<>(); 
		for(int i=0; i<s1.length()-1; i++) {
			String temp = ""; 
			if(s1.charAt(i)>='A'&&s1.charAt(i)<='Z'&&s1.charAt(i+1)>='A'&&s1.charAt(i+1)<='Z') {
				temp+=s1.substring(i, i+2);
				aMap.put(temp, aMap.getOrDefault(temp, 0)+1); 
				set.add(temp); 
				aList.add(temp); 
			}
		}
		for(int i=0; i<s2.length()-1; i++) {
			String temp = ""; 
			if(s2.charAt(i)>='A'&&s2.charAt(i)<='Z'&&s2.charAt(i+1)>='A'&&s2.charAt(i+1)<='Z') {
				temp+=s2.substring(i, i+2); 
				bMap.put(temp, bMap.getOrDefault(temp, 0)+1); 
				set.add(temp); 
				bList.add(temp); 
			}
		}
		
		for(String s  : aList) {
			System.out.print(s+ " ");
		}
		System.out.println();
		for(String s : bList) {
			System.out.print(s+" ");
		}
		System.out.println();
		for(String s : set) {
			System.out.print(s+" ");
		}System.out.println();

		
		double union = 0; //합집합 전체 개수
		double insect = 0 ; //교집합 전체 개수 ..  
		
		for(String s : set) {
			if(aMap.get(s)==null && bMap.get(s)==null) { 
				continue; 
			}
			else if (aMap.get(s)==null && bMap.get(s)!=null) {
			//	System.out.println(bMap.get(s));
				union += bMap.get(s); 
			}
			else if (aMap.get(s)!=null && bMap.get(s)==null) {
				union += aMap.get(s); 
			}
			else {// 둘 다 단어가 존재할 때 
				insect += Math.min(aMap.get(s), bMap.get(s)); 
				union += Math.max(aMap.get(s), bMap.get(s)); 				
			}
		}
		System.out.println("insect : "+ insect + " union : " + union);
		double answer  = (double)(insect / union); 
		answer = answer * 65536; 
		System.out.println((int)answer);
		
		// 합집합 / 교집합 
		
		// 다중집합일 때 
		// min(a,b) 교집합 
		// max(a,b) 합집합 더해 
		
		
		// 두 집합 모두 공집합일 때 
	}
}
