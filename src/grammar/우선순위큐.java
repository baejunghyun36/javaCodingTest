package grammar;

import java.util.Collections;
import java.util.PriorityQueue;

public class 우선순위큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(); 
		
		//offer, poll, peek 는 값이 없으면 null 또는 false 값 반환 
		
		pq1.offer(3); 
		pq1.offer(2);
		
		
		while(!pq1.isEmpty()) {
			System.out.println(pq1.poll());
		}		
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); 
		
		pq2.offer(3); 
		pq2.offer(2);
		
		System.out.println();
		
		
		while(!pq2.isEmpty()) {
			System.out.println(pq2.poll());
		}		
		
	
		
		
	}

}
