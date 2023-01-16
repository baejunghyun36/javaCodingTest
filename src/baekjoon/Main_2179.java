package gitRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main_2179 {
	static ArrayList<String> list; 
	static int N; 
	static Map <String, Integer> map; 
	static Map <String, Integer> check; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		list =new ArrayList<>(); 
		N = Integer.parseInt(br.readLine());
		check = new HashMap<>(); 
		map = new HashMap<>(); 
		for(int i=0; i<N; i++) {
			String s = br.readLine(); 
			list.add(s); 
			if(map.get(s)!=null)continue; 
			map.put(s,  i+1); 
			check.put(s,  0); 
		}
		Collections.sort(list);
	
		int cnt = -1; 

		for(int i=0; i<list.size()-1; i++) {
			String s1 = list.get(i); 
			String s2 = list.get(i+1); 
			if(s1.equals(s2))continue; 
			int tempCnt = 0; 
			int length = Math.min(s1.length(),s2.length()); 
			for(int j=0; j<length; j++) {
				if(s1.charAt(j)==s2.charAt(j))tempCnt++; 
				else break; 
			}
			if(cnt<=tempCnt) {
				cnt = tempCnt;
				check.put(s1, cnt); 
				check.put(s2, cnt); 
			}
		}
		ArrayList <Node> result = new ArrayList<>(); 
		
		for(String key : check.keySet()) {
			if(check.get(key)==cnt) {
				Node node = new Node(key, map.get(key)); 
				result.add(node); 
				//System.out.println(node.s);
			}
		}
		Collections.sort(result);
		String s1 = result.get(0).s; 
		for(int i=1; i<result.size(); i++) {
			String s2 = result.get(i).s; 
			int c = 0; 
			for(int j=0; j<cnt; j++) {
				if(s1.charAt(j)==s2.charAt(j)) {
					c++; 
				}
				else break; 
			}
			if(c==cnt) {
				System.out.println(s1);
				System.out.println(s2);
				break; 
				
			}
		}

		
	}
	
	static class Node implements Comparable<Node>{
		
		String s; 
		int num; 		

		public Node(String s, int num) {
			this.s = s; 
			this.num = num; 
		}
		
		public int compareTo(Node node) {
			return this.num - node.num; 
		}
		
	}

}
