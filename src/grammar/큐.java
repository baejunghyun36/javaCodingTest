package grammar;

import java.util.LinkedList;
import java.util.Queue;

public class 큐 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Queue <Integer> q = new LinkedList <>(); 
		
		q.offer(1); 
		q.offer(2); 
		
		q.peek(); 
		
		int x= q.poll(); 
		int y = q.poll(); 
		
		q.size(); 
		if(q.isEmpty()) {
			System.out.println("비었음");
		}
		
		
	}

}
