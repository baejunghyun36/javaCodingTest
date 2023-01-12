package gitRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1927 {
	
	static PriorityQueue <Integer> pq; 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		pq = new PriorityQueue <>(); 
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine()); 
		for(int i=0; i<n; i++) {
			int a = Integer.parseInt(br.readLine()); 
			if(a==0&&!pq.isEmpty())System.out.println(pq.poll());
			else if(a==0&&pq.isEmpty())System.out.println(0);
			else pq.add(a); 
		}
		
	}

}
