package gitRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1715 {
	
	static int N; 
	static PriorityQueue <Integer> pq; 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		
		N = Integer.parseInt(br.readLine()); 
		pq = new PriorityQueue<>(); 
		for(int i=0; i<N; i++) pq.add(Integer.parseInt(br.readLine())); 
		int answer = 0; 
		while(pq.size()>1) {
			 int sum = pq.poll()+pq.poll(); 
			 answer+=sum; 
			 pq.add(sum); 			
		}

		sb.append(answer); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
