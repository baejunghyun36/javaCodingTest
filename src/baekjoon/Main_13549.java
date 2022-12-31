package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13549 {

	static int [] map; 
	static final int maxNumber = 100000; 
	static int [] visited; 
	static int start; 
	static int destination; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		map = new int [maxNumber+1];
		visited = new int[maxNumber+1]; 
		Arrays.fill(visited, 987654321);
		start = Integer.parseInt(st.nextToken()); 
		destination = Integer.parseInt(st.nextToken()); 
		
		sb.append(visit()); 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int visit(){
		Queue <Integer> q = new LinkedList<>(); 
		q.add(start);
		visited[start] = 0; 
		while(!q.isEmpty()) {
			int x = q.poll(); 
			
			
			if(x==destination) {
				return visited[x]; 
			}
			if(x-1>=0&&visited[x]+1<visited[x-1]) {
				visited[x-1] = visited[x]+1; 
				q.add(x-1); 
			}
			if(x+1<=maxNumber&&visited[x]+1<visited[x+1]) {
				visited[x+1] = visited[x]+1; 
				q.add(x+1); 
			}
			if(x*2<=maxNumber&&visited[x]<visited[x*2]) {
				visited[x*2] = visited[x]; 
				q.add(x*2); 
			}
		}
		
		return destination;
		
	}
	
}
