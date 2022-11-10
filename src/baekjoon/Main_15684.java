package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15684{

	static int M, N; 
	static int [][] map; 
	static ArrayList<int []> list; 
	static int [] visited; 
	static boolean finish; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st.nextToken()); 
		int number = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		
		map = new int[M+1][N+2]; 
		
		for(int i=0; i<number; i++) {
			st = new StringTokenizer(br.readLine()); 
			int y = Integer.parseInt(st.nextToken()); 
			int x = Integer.parseInt(st.nextToken()); 
			map[y][x] = 1; 
		}
		list = new ArrayList<>(); 
		for(int i=1; i<=M; i++) {
			for(int j=1; j<N; j++) if(map[i][j]==0) list.add(new int[] {i,j});				
		}		
		visited = new int[list.size()]; 
		for(int i=0; i<=3; i++) {
			backTracking(i, 0, 0); 
			if(finish==true) {
				sb.append(i); 
				break; 				
			}
		}		
		if(finish == false) sb.append(-1); 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	static boolean check() {
		
		for(int i=1; i<=N; i++) {
			int x = i; 
			int y = 1; 
			while(y!=M+1) {
				if(map[y][x]==1)x++; 
				else if(map[y][x-1]==1)x--; 
				y++; 				
			}		
			if(i!=x)return false; 
		}
		return true; 
	}

	static void backTracking(int level, int cnt, int start) {
		if(finish)return ; 
		if(level==cnt) {
			if(check()) finish = true; 		
			return; 
		}
		for(int i=start; i<list.size(); i++) {
			if(visited[i]==1)continue; 			
			int y = list.get(i)[0]; 
			int x = list.get(i)[1]; 
			if(x-1>=1&&map[y][x-1]==1)continue; 
			if(x+1<=N&&map[y][x+1]==1)continue; 
			visited[i] = 1; 
			map[y][x] = 1; 
			backTracking(level, cnt+1, i); 
			visited[i] = 0; 
			map[y][x] = 0; 			
		}
	}
}
