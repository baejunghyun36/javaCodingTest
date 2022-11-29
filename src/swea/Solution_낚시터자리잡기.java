package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_낚시터자리잡기 {

	static int testCase; 
	static int dis[][]; 
	static int people; 
	static int N; 
	static Gate [] gate; 
	static int result; 
	static int []visited; 
	static int [] order; 
	static int []visitedOrder; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		testCase = Integer.parseInt(st.nextToken()); 
		Map <Integer> map = new HashMap<>(); 
		for(int t = 1; t<=testCase; t++) {
			
			
			st = new StringTokenizer(br.readLine()); 
			gate = new Gate [4]; 
			N = Integer.parseInt(st.nextToken()); 
			for(int i=1; i<=3; i++) {
				st = new StringTokenizer(br.readLine()); 
				int index = Integer.parseInt(st.nextToken()); 
				int number = Integer.parseInt(st.nextToken()); 
				gate[i] = new Gate (index, number); 
			}
			
			dis = new int[4][N+1]; 
			
			for(int i=1; i<=3; i++) {
				dis[i][gate[i].index] = 1; 
				for(int j=gate[i].index-1; j>=1; j--) dis[i][j] = dis[i][j+1]+1; 				
				for(int j=gate[i].index+1; j<=N; j++) dis[i][j] = dis[i][j-1]+1; 				
			}
			
			result = 987654321; 
			order = new int[4]; 
			visitedOrder = new int [4]; 
			orderFunction(1); 

			sb.append("#").append(t).append(" ").append(result).append("\n"); 			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void orderFunction(int cnt ) {
		
		if(cnt==4) {
			visited = new int[N+1]; 
	
			dfs(1); 
			return; 
		}
		
		for(int i=1; i<=3; i++) {
			if(visitedOrder[i]==1)continue; 
			visitedOrder[i] = 1; 			
			order[cnt] = i; 
			orderFunction(cnt+1); 
			visitedOrder[i] = 0; 			
		}
		
	}
	

	
	
	static void dfs(int level) {

		
		
		if(level==4) {
			int sum =0; 

			for(int i=1; i<=N; i++) {
				sum+=dis[visited[i]][i]; 
			}
			result = Math.min(result, sum); 
			return; 
		}		
		
		
		int gateNumber = order[level]; 
		System.out.println(Arrays.toString(visited)+ " level : "+level + " gate : "+gateNumber);
		if(gate[gateNumber].number%2==1) {//홀 수 일 때 
			int left = gate[gateNumber].index; 
			int right = gate[gateNumber].index; 
			int total = gate[gateNumber].number; 
			while(total>0) {			
				if(left>=1&&visited[left]==0) {
					visited[left] = gateNumber; 					
					total--; 
				}
				if(right<=N&&visited[right]==0) {
					visited[right] = gateNumber; 
					total--; 
				}
				if(total<=0)break ;
				left--; 
				right++; 
			}
			dfs(level+1);			
		}
		else if(gate[gateNumber].number%2==0) {
			int left = gate[gateNumber].index; 
			int right = gate[gateNumber].index; 
			int total = gate[gateNumber].number; 
			
			for(int i=0; i<=N; i++) {
				if(1<=left-i) {
					if(visited[left-i]==0) {
						visited[left-i]=gateNumber; 
						total--; 
					}
				}
				if(N>=right+i) {
					if(visited[right+i]==0) {
						visited[right+i]=gateNumber; 
						total--; 
					}
				}
				if(total==-1) {
					visited[left-i]=0; 
					dfs(level+1); 
					visited[left-i]=gateNumber; 
					visited[right+i]=0; 
					dfs(level+1); 
				}
				if(total==0)break ;
			}
		
		}

	}
	
	static class Gate{
		
		int index; 
		int number;
		
		public Gate(int index, int number) {
			super();
			this.index = index;
			this.number = number;
		} 

	}

}
