package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055 {

	static int [] dy = {0,0,1,-1}; 
	static int [] dx = {1,-1,0,0}; 
    static int [][] map ; 
    static int N; 
	static int [][]visited; 
	static Shark shark;  
	static List <Prey> prey ; 
	static int result ; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		map = new int[N][N]; 		
		prey = new ArrayList<>(); 		
		result = 0; 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				if(map[i][j]==9) {
						shark = new Shark(i, j, 2, 0);
						map[i][j] = 0; 
				}
				if(map[i][j]>=1&&map[i][j]<=6) {					
					prey.add(new Prey(i, j, map[i][j]));					
				}
			}
		}
		bfs(); 
		sb.append(result); 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	static void bfs() {
		while(true) {
			visited = new int [N][N]; 
			Queue <int []> q = new LinkedList<>();
			q.offer(new int [] {shark.y, shark.x}); 
			visited[shark.y][shark.x]=1; 
			int seconds = 0; 		
			List <Prey> preyList = new ArrayList<>();
			while(!q.isEmpty()) {					
				seconds++; 
				int size = q.size(); 		 
				while(0<size--) {		
					int [] yx = q.poll(); 
					int y = yx[0]; 
					int x = yx[1]; 
					for(int i=0; i<4; i++) {
						int ny = y+dy[i]; 
						int nx = x+dx[i]; 						
						if(ny<0||ny>=N||nx<0||nx>=N)continue; 
						if(visited[ny][nx] == 1 || map[ny][nx] > shark.size) continue; 
						if(map[ny][nx]>=1&&map[ny][nx]<shark.size) {
							preyList.add(new Prey(ny, nx, map[ny][nx])); 
						}
						visited[ny][nx] =1; 
						q.offer(new int [] {ny, nx}); 											
					}					
				}
				if(preyList.size()>0)break; 
			}
			if(preyList.size()==0)break; 
			
			result += seconds;
			Collections.sort(preyList);	
			sharkUpdate(preyList.get(0)); 
		}
	}
	
	static void sharkUpdate(Prey prey) {
		map[prey.y][prey.x] = 0; 
		shark.y = prey.y; 
		shark.x = prey.x; 
		shark.preyCount++; 
		if(shark.preyCount==shark.size) {
			shark.size++; 
			shark.preyCount = 0; 
		}		
	}
	
	static class Prey implements Comparable<Prey>{
		
		int y; 
		int x;
		int size; 
		
		public Prey(int y, int x, int size) {
			super();
			this.y = y;
			this.x = x;
			this.size = size; 
		}

		@Override
		public int compareTo(Prey o) {
			
			if(this.y==o.y) return this.x-o.x; 
			return this.y-o.y; 
		}

	}
	
	static class Shark{
		
		int y; 
		int x; 
		int size; 
		int preyCount;
		
		public Shark(int y, int x, int size, int preyCount) {
			
			super();
			this.y = y;
			this.x = x;
			this.size = size;
			this.preyCount = preyCount;
			
		} 
	}
}
