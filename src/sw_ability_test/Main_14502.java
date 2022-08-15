package sw_ability_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502 {
	static int [][]	map; 
	static int M,N; 
	static List<int []> virus;
	static int[] dx = {0,0,-1,1}; 
	static int[] dy = {1,-1,0,0}; 
	static int [][]visited; 
	static int answer; 
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = null; 
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder   sb = new StringBuilder(); 
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken());
		
		virus = new ArrayList<>(); 
		visited  = new int [M][N]; 
		map = new int[M][N]; 
		answer = Integer.MIN_VALUE; 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) virus.add(new int[] {i,j}); 
				
			}
		}
	
		comb(0); 
		System.out.println(answer);
		
		
	}
	static void comb(int cnt) {
 
		
		if(cnt==3) {
			bfs(); 
			return; 
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==0&&visited[i][j]==0) {
					map[i][j]=1; 
					visited[i][j]= 1; 
					comb(cnt+1);
					visited[i][j] = 0; 
					map[i][j] =0; 
				}			
			}
		}
	}
	
	static void bfs() {
		
		Queue <int[]> q = new LinkedList<>(); 
		
		for(int i=0; i<virus.size(); i++) {
			int [] yx = virus.get(i); 
			q.add(yx); 
		}
		int [][] temp = new int[M][N]; 
		for(int i=0; i<M; i++) {		
			temp[i] = map[i].clone(); 
		
		}
		
		while(!q.isEmpty()) {
			
			int y= q.peek()[0]; 
			int x =q.peek()[1]; 
			q.poll(); 
			for(int i=0; i<4; i++) {
				int nx = x+dx[i]; 
				int ny = y +dy[i]; 
				if(ny<0||ny>=M||nx<0||nx>=N)continue; 
				if(temp[ny][nx]==2||temp[ny][nx]==1)continue; 
				temp[ny][nx] = 2; 
				q.offer(new int[] {ny,nx}); 
			}
		}
		int cnt=0; 
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(temp[i][j]==0)cnt++; 
			}
		}
		answer = Math.max(answer, cnt); 
		
	}

}















