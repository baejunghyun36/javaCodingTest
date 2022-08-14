
package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_11286 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		 StringBuilder sb = new StringBuilder(); 
		
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	
		 
		 
		 PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.number==o2.number) { 
					//return 값이 음수면 o1 앞에 정렬, 양수면 o2 가 앞에 정렬
					return o1.number*o1.isPositive - o2.number*o2.isPositive ; 
				}
				return o1.number - o2.number; 
			}
		 });  
		 
		 Scanner sc = new Scanner(System.in); 
		 int n= sc.nextInt(); 
		 
		 for(int i=0; i<n; i++) {
		
			 int a = sc.nextInt(); 
			 if(a==0) {
				 // pop
		
				 if(!pq.isEmpty())
				 sb.append(pq.peek().number*pq.peek().isPositive).append("\n");
				 else  sb.append(0).append("\n");
				 pq.poll(); 
			 }
			 else if(a<0){

				 Node node = new Node(a*(-1), -1); 
				 pq.add(node); 
			 }
			 else {
	
				 Node node = new Node(a, 1); 
				 pq.add(node); 
			 }
		 }
		
		 bw.write(sb.toString());
		 bw.flush();
	 
		 bw.close(); 
		
	}

}

class Node{
	
	int number; 
	int isPositive; 
	
	public Node() {
		
	}
	
	public Node(int number, int isPositive) {
		this.number = number; 
		this.isPositive = isPositive; 
	}
	
	
}

