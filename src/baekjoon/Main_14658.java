package gitRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_14658 {

	static int N,M,L,K; 
	static ArrayList <Node>list; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		L = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		
		list = new ArrayList<>(); 
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine()); 
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken()); 
			list.add(new Node(y, x)); 
		}
		Collections.sort(list);
		
		int answer = 0; 
		
		for(int i=0; i<list.size()-1; i++) {
			Node node = list.get(i); 
			for(int y = node.y-L; y<=node.y; y++) {
				int cnt =0; 
				int yStart = y; 
				int yEnd = y+L; 
				for(int j=i+1; j<list.size(); j++) {
					if(list.get(j).x>node.x+L)break; 
					if(list.get(j).y>=yStart&&list.get(j).y<=yEnd) {
						cnt++; 
					}
				}
				answer = Math.max(answer,  cnt); 
			}
		}
		
		sb.append(K-answer-1); 	
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	
	static class Node implements Comparable<Node> {
		int y; 
		int x; 
		
		public Node(int y, int x) {
			this.y = y;
			this.x = x; 
		}
		
		public int compareTo(Node node) {
			return this.x - node.x; 
		}
	}

}
