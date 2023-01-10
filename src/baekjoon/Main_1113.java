package gitRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1113 {

	static int M, N; 
	static int [][] map; 
	static int [][] visited; 
	static int [] dx = {0,0,-1,1}; 
	static int [] dy = {1,-1,0,0}; 
	static ArrayList<int []> tempList; 
	static Queue<int[]> q; 
	static int answer; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		
		map = new int[M][N]; 
		for(int i=0; i<M; i++) {
			String s = br.readLine(); 
			for(int j=0; j<s.length(); j++) {
				map[i][j] = s.charAt(j)-'0'; 
			}
		}
		for(int i=1; i<=9; i++) {
			visited = new int [M][N]; 
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {
					if(visited[j][k]==1)continue; 
					if(map[j][k]==i) {
						q = new LinkedList<>(); 
						tempList = new ArrayList<>(); 
						q.add(new int[] {j,k}); 	
						tempList.add(new int[] {j,k}); 
						visited[j][k] = 1; 
						bfs(map[j][k]); 
					}
				}
			}
		}
		System.out.println(answer);

	}
	static void bfs(int startNumber) {
		
		int minNumber = 987654321; 
		while(!q.isEmpty()){
			int[] yx = q.poll(); 
			for(int i=0; i<4; i++) {
				int ny = dy[i]+yx[0]; 
				int nx = dx[i]+yx[1]; 
				if(ny<0||ny>=M||nx<0||nx>=N) {
					minNumber  = 0; 
					continue; 
				}
				if(visited[ny][nx]==1)continue; 
				if(map[ny][nx] ==  0) {
					minNumber  = 0; 
					continue; 
				}
				if(startNumber<map[ny][nx]) {
					minNumber = Math.min(map[ny][nx], minNumber);
					continue; 
				}
				visited[ny][nx] = 1; 
				q.add(new int[] {ny, nx}); 
				tempList.add(new int[] {ny, nx}); 
			}
		}
		if(minNumber==0) {
			for(int []yx : tempList) {
				map[yx[0]][yx[1]] = 0; 
			}
		}
		else {
			for(int []yx : tempList) {
				answer+=(minNumber - startNumber); 
				map[yx[0]][yx[1]] = minNumber; 
			}
		}
	
		
	}

}
