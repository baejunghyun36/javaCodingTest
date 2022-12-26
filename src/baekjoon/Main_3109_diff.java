package baekjoon;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3109_diff {

	static int [] dx = {1,1,1}; 
	static int [] dy = {-1, 0, 1}; 
	static int M, N; 
	static int [][] map; 
	static boolean flag; 
	static int answer; 
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		
		map = new int[M][N]; 
		
		for(int i=0; i<M; i++) {
			String s = br.readLine(); 
			for(int j=0; j<N; j++) {
				if(s.charAt(j)=='.')map[i][j] = 0; 
				else map[i][j] = 2; 
			}
		}
		
		for(int i=0; i<M; i++) {
			
			flag = false; 
			dfs(i, 0); 
			
			
		}

		sb.append(answer); 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void dfs (int y, int x) {
		
		if(x==N-1) {
			answer++; 
			flag = true; 
			return; 
		}
		
		out:for(int i=0; i<3; i++) {
			if(flag==true)break out; 
			int nx = dx[i]+x; 
			int ny = dy[i]+y; 
			if(ny<0||ny>=M)continue; 
			if(map[ny][nx]==2||map[ny][nx]==1)continue; 
			map[ny][nx] = 1; 
			dfs(ny,nx); 
		}
	}
}
