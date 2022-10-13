package programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_징검다리 {

	static int []stones; 
	static int k;
	
	
	static PriorityQueue <Info> q; 
	static List <Integer> removeList; 
	static int [] removeCnt; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		stones = new int []{2,4,5,3,2,1,4,2,5,1}; 
		k = 3; 
	
		int cnt = 1; 
		
		q = new PriorityQueue<>(); 
		
		for(int i=0; i<stones.length; i++) {
			q.add(new Info(i+1, stones[i])); 
		}
		removeCnt = new int [200003]; 
		boolean flag = false; 
		while(true) {
			if(q.peek().num==cnt) {
				while(q.peek().num==cnt) {
					int idx = q.poll().index; 
					removeCnt[idx] = removeCnt[idx-1]+ removeCnt[idx+1]+1; 
					if(removeCnt[idx-1]<=removeCnt[idx+1]) {
						int i = idx - 1; 
					
						while(i>=1&&removeCnt[i]!=0) {
							removeCnt[i] = removeCnt[i+1]; 
							i--; 
						}
					}
					else {
						int i = idx + 1; 						
						while(i<=stones.length&&removeCnt[i]!=0) {
							removeCnt[i] = removeCnt[i-1]; 
							i++; 
						}
					}
					if(removeCnt[idx]>=k) {
						flag = true; 
						break; 
					}
				}
			}
			if(flag == true)break; 
			cnt ++; 			
		}
		System.out.println(cnt);
		
		
	}

	static class Info implements Comparable <Info>{
		
		int index ; 
		int num;
		public Info(int index, int num) {
			super();
			this.index = index;
			this.num = num;
		}
		
		@Override
		public int compareTo(Info o) {
			// TODO Auto-generated method stub
			return this.num - o.num;
		} 
	}
}
