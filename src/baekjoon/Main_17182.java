package gitRepository;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17182 {

	static int[][] visited; 
	static int [] planet; 
	static int [][] map; 
	static int [][] dist; 
	static int N; 
	static int answer = 987654321; 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		int start = Integer.parseInt(st.nextToken()); 
		planet = new int[N]; 
		visited = new int[N][N]; 
		dist = new int[N][N]; 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]); 
				}
			}
		}
		planet[start]=1; 
		backT(start, 1, 0); 
		sb.append(answer); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void backT(int cur, int cnt, int sum) {
		if(cnt==N) {
			answer = Math.min(answer,  sum); 
			return; 			
		}
	
		for(int i=0; i<N; i++) {
			
			if(planet[i]==0&&cur!=i) {
				planet[i] = 1; 
				backT(i, cnt+1, sum+dist[cur][i]); 
				planet[i] = 0; 
			}
		
		}
	}
}
