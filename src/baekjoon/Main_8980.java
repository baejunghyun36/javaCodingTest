package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_8980 {
	static PriorityQueue<Box> pq; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int N = Integer.parseInt(st.nextToken()); 
		Truck t = new Truck(Integer.parseInt(st.nextToken()), 0, new LinkedList<>());
		int n = Integer.parseInt(br.readLine()); 
		pq = new PriorityQueue<>(); 
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()); 
			int from = Integer.parseInt(st.nextToken()); 
			int to = Integer.parseInt(st.nextToken()); 
			int cnt = Integer.parseInt(st.nextToken()); 
			pq.add(new Box(from, to, cnt)); 
		}
		
		int cur = 1; 
		int answer = 0; 
		while(cur<N) {
			//System.out.println(pq.peek().from+" "+ pq.peek().to);
			//System.out.println("현재 트럭 위치 : "+ cur);
			Box box1 = pq.peek(); 
			
			while(t.q.size()>0&&t.q.peek().to==box1.from) {
				Box b = t.q.poll(); 
				//System.out.println(b.cnt+"빼라 ");
				t.cur-=b.cnt; 
				answer+=b.cnt; 
			}
			while(!pq.isEmpty()&&cur==pq.peek().from&&t.cur<t.capacity) {
				Box box = pq.poll(); 
				Box b = null; 
				if(t.cur+box.cnt<=t.capacity) {
					b = new Box(0, box.to, box.cnt); 
					t.q.add(b); 
					t.cur +=box.cnt; 
				}
				else {
					b = new Box(0, box.to, t.capacity-t.cur);
					t.q.add(b); 
					t.cur = t.capacity; 
				}	
				//System.out.println(b.to+"한테 "+b.cnt+"만큼 보내는거 담아");
			}
			while(!pq.isEmpty()&&pq.peek().from==cur) {
				pq.poll(); 
			}
	
			cur++; 
		}
		answer+=t.cur; 
		sb.append(answer); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	
	static class Box implements Comparable<Box>{
		
		int from,to, cnt;

		public Box(int from, int to, int cnt) {
			super();
			this.from = from;
			this.to = to;
			this.cnt = cnt;
		} 
		
		public int compareTo(Box box) {
			if(this.to==box.to) {
				return this.from-box.from; 
			}
			return this.to-box.to; 
		}
	}
	
	
	
	static class Truck{
		int capacity;
		int cur; 
		Queue <Box> q;
		public Truck(int capacity, int cur, Queue<Box> q) {
			super();
			this.capacity = capacity;
			this.cur = cur;
			this.q = q;
		} 
	}
}
