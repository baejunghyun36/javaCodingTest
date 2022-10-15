package programmers;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Solution_징검다리 {

	static int k; 
	static int [] stones; 

	public static void main(String[] args) {
	
		int min = 0; 
		int max = Integer.MAX_VALUE; 
		int result = 0; 
		
		while(min<=max) {
			
			int mid = (min+max)/2; 
			if(check(mid, k, stones)) {
				min = mid + 1; 
				result = mid; 
			}
			else {
				max = mid - 1; 
			}
		}
	}
	static boolean check (int mid, int k, int[] stones) {
		int count  = 0; 
		for(int i=0; i<stones.length; i++) {
			if(mid>stones[i]){
                count++; 
                if(count >=k) return false; 
            }
            else count = 0; 
			
		}
		return true; 
	}
}
