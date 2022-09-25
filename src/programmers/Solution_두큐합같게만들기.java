package programmers;

import java.util.LinkedList;

public class Solution_두큐합같게만들기 {
	
	static LinkedList <Integer> list1; 
	static LinkedList <Integer> list2;
	
	public static void main(String[] args) {
		
		
		int[] queue1 = {1, 2, 1, 2}; 
		int[] queue2 = {1, 10, 1, 2}; 
		
		list1 = new LinkedList<>(); 
		list2 = new LinkedList<>(); 
		
		
		long sum1 = 0; 
		long sum2 = 0;
		
		for(int i=0; i<queue1.length; i++) {
			sum1+=queue1[i]; 
			list1.add(queue1[i]); 
		}
		for(int i=0; i<queue2.length; i++) {
			sum2+=queue2[i]; 
			list2.add(queue2[i]); 
		}
		
	
		
		int cnt = 0; 
		
		while(list1.size()!=0&&list2.size()!=0) {
			System.out.println(sum1+" "+sum2);
			if(sum1==sum2) {
				System.out.println(cnt);
				break; 
				//return cnt; 
			}
			else if(sum1<sum2) {
				
				sum2-=list2.get(0); 
				sum1+=list2.get(0);
				list1.add(list2.get(0)); 
				list2.remove(0); 
			}
			else {
				sum1-=list1.get(0); 
				sum2+=list1.get(0);
				list2.add(list1.get(0)); 
				list1.remove(0); 
			}
			cnt++; 
		}
		System.out.println(-1);
		
	}

}
