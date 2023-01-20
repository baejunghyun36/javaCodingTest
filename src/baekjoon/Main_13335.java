package gitRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335 {
	static int n, l, w; 
	static int []truck; 
	static Queue <int[]> q; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		n = Integer.parseInt(st.nextToken()); 
		l = Integer.parseInt(st.nextToken()); 
		w = Integer.parseInt(st.nextToken()); 
		truck = new int[n]; 
		
		st = new StringTokenizer(br.readLine()); 
		q = new LinkedList<>(); 
		for(int i=0; i<n; i++) truck[i] = Integer.parseInt(st.nextToken()); 
		
		int second = 0; 
		int index  = 0; 
		int weight = 0;  

		while(true) {
			second++; 
			
			if(second!=1) {
				int []info = q.peek(); 
				if(second == info[0]) {
					q.poll(); 				
					weight-=info[1]; 
				}
			}
		
			if(index<n&&truck[index]+weight<=w) {
				weight +=truck[index]; 
				q.add(new int[] {second+l, truck[index++]}); 
			}
			
			if(q.isEmpty())break;
		
		}
		System.out.println(second);
		
	}

}
