package baekjoon;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_22866 {
	static int [] buildingCount; 
	static int [] buildingNumber; 
	static int [] height; 
	static Stack <int []> stack; 
	static int N; 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
	
		N = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		buildingCount = new int [N+2]; 
		buildingNumber = new int[N+2]; 
		height = new int [N+2]; 
		stack = new Stack <>(); 
		
		for(int i=1; i<=N; i++) height [i] = Integer.parseInt(st.nextToken()); 
		
		for(int i=1; i<=N; i++) {
			int [] node = new int [4]; 
			node[0] = height[i]; 
			node[1] = i; 
			
			while(!stack.isEmpty()&& stack.peek()[0]<=node[0]) {
				stack.pop(); 
			}
			if(stack.isEmpty()) stack.add(node); 
			else {
				int [] top = stack.peek(); 
				node[2] = top[1] - node[1]; 
				node[3] = top[3]+1;
				buildingCount[i]+=node[3]; 
				buildingNumber[i] = node[2]; 
				stack.add(node); 
			}
		}

		stack.clear();

		for(int i=N; i>=1; i--) {
			int [] node = new int [4]; 
			node[0] = height[i]; 
			node[1] = i; 
			
			while(!stack.isEmpty()&& stack.peek()[0]<=node[0]) {
				stack.pop(); 
			}
			if(stack.isEmpty()) {
				stack.add(node); 
			}
			else {
				int [] top = stack.peek(); 
				node[2] = top[1] - node[1];  
				node[3] = top[3]+1;
				buildingCount[i]+=node[3]; 
				if(buildingNumber[i] == 0) buildingNumber[i]= top[1] - node[1];
				else if(buildingNumber[i]!=0&&Math.abs(buildingNumber[i])>node[2]) {
					buildingNumber[i]= node[2]; 	
				}
				
				stack.add(node); 
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(buildingCount[i]==0)sb.append(0).append("\n"); 
			else {
				sb.append(buildingCount[i]).append(" ").append(i+buildingNumber[i]).append("\n"); 
			}
		}
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}

}
