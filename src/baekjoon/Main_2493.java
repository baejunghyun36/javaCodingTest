package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		Stack <int []> stack = new Stack<>(); 
		int N = Integer.parseInt(br.readLine()); 
		st = new StringTokenizer(br.readLine()); 
		int [] answer = new int[N]; 
		for(int i=0; i<N; i++) {
			int a  = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()&&stack.peek()[0]<=a) {
				stack.pop(); 
			}
			if(stack.isEmpty())sb.append(0).append(" "); 
			else sb.append(stack.peek()[1]).append(" ");
			stack.add(new int [] {a, i+1}); 
			
		}		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
