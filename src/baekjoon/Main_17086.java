package gitRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17086 {

	static int M, N; 
	static int [][] map; 
	static int [] dy = {0,0,1,-1,-1,-1,1,1}; 
	static int [] dx = {1,-1,0,0,-1, 1, -1, 1}; 
	static ArrayList<int[]>list; 
	static int answer = -1; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		
		map = new int[M][N]; 
		list = new ArrayList<>(); 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					list.add(new int[] {i,j}); 
				}
			}
		}
		bruteForce(); 		
		System.out.println(answer+1);
	}
	
	static void bruteForce() {
		
		
		for(int i=0; i<list.size(); i++) {
		
			int [] yx = list.get(i);  
			int [][] visited = new int[M][N]; 
			visited[yx[0]][yx[1]] = 1; 
			Queue <int[]> q = new LinkedList<>(); 
			q.add(new int[] {yx[0], yx[1], 0}); 
			out:while(!q.isEmpty()) {
				int [] yxd = q.poll(); 
				int y = yxd[0]; 
				int x = yxd[1]; 
				int d = yxd[2]; 
				for(int j = 0; j<8; j++) {
					int nx = x +dx[j]; 
					int ny = y+dy[j]; 
					if(ny<0||ny>=M||nx<0||nx>=N)continue; 
					if(visited[ny][nx]==1)continue; 
					if(map[ny][nx] ==1) {
						answer = Math.max(answer, d); 
						break out; 
					}
					visited[ny][nx] = 1; 
					q.add(new int[] {ny,nx,d+1}); 
				}	
				
			}

			
			
			
		
		}
		
		
	}

}
