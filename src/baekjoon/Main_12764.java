package gitRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_12764 {

	static PriorityQueue <Computer> endQueue; 
	static PriorityQueue <Integer> seatQueue; 
	static int computerCount;
	static Map <Integer,Integer> map; 
	static ArrayList <Computer> list; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		
		int n = Integer.parseInt(br.readLine()); 
		list = new ArrayList<>(); 
		endQueue = new PriorityQueue<>(); 
		seatQueue = new PriorityQueue<>(); 
		map = new HashMap<>(); 
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); 
			int e = Integer.parseInt(st.nextToken()); 
			Computer cpt = new Computer(s, e, 0); 
			list.add(cpt); 
		}
		
		Collections.sort(list);
		
		for(int i=0; i<n; i++) {
			
			Computer cpt = list.get(i); 
			int start = cpt.start; 
			
			
			while(!endQueue.isEmpty()&&endQueue.peek().end<=start) {
				seatQueue.add(endQueue.poll().seatNumber); 
			}
			
			if(!seatQueue.isEmpty()) {
				cpt.seatNumber = seatQueue.poll(); 
			}
			
			else {
				cpt.seatNumber = ++computerCount;
			}
			//System.out.println(cpt.start+" "+cpt.end+" "+cpt.seatNumber);
			cpt.start = 0; 
			endQueue.add(cpt); 
			map.put(cpt.seatNumber, map.getOrDefault(cpt.seatNumber,0)+1); 
				
		}
		sb.append(computerCount).append("\n"); 
		for(int i=0; i<map.size(); i++) {
			sb.append(map.get(i+1)).append(" "); 
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static class Computer implements Comparable<Computer>{
		
		int start; 
		int end; 
		int seatNumber;
		
		public Computer(int start, int end, int seatNumber) {
			super();
			this.start = start;
			this.end = end;
			this.seatNumber = seatNumber;
		} 
		
		public int compareTo(Computer computer) {
			if(this.start == computer.start)return this.end - computer.end; 
			return this.start - computer.start; 
		}
		
		
	}
	

}
