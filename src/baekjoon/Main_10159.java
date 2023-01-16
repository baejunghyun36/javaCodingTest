package gitRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10159 {

	static int N; 
	static int M; 
	static int [] number; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = null; 
		N = Integer.parseInt(br.readLine()); 
		ArrayList<Integer>list1[] = new ArrayList[N+1]; 
		ArrayList<Integer>list2[] = new ArrayList[N+1];
		number = new int[N+1];
		for(int i=1; i<=N; i++) {
			list1[i] = new ArrayList<>(); 
			list2[i] = new ArrayList<>(); 
		}
		M  = Integer.parseInt(br.readLine()); 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st.nextToken()); 
			int b = Integer.parseInt(st.nextToken()); 
			list1[a].add(b); 
			list2[b].add(a); 
		}
		
		for(int i=1; i<=N; i++) {
			
			sb.append(N-bfs(i, list1)-bfs(i, list2)-1).append("\n"); 
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	
	static int bfs(int start, ArrayList<Integer>list[]) {

		int cnt = 0; 
		Queue <Integer> q = new LinkedList<>(); 
		q.add(start); 
		int[] visited =new int[N+1]; 
		visited[start] = 1; 
		while(!q.isEmpty()) {
			int num = q.poll(); 
			for(int i=0; i<list[num].size(); i++) {
				int x = list[num].get(i); 
				if(visited[x]==1)continue; 
				else {
					visited[x] = 1; 
					cnt++; 
					q.add(x); 
				}
			}
		}
		return cnt; 
	}

}
