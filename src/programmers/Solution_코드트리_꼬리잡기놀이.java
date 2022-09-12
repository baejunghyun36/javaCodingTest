package programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_코드트리_꼬리잡기놀이 {

	static int N; 
	static int teamCnt; 
	static int K; //라운트 갯수 
	static int [][] map; 
	static int [] dx = {0,0,1,-1};
	static int [] dy = {1,-1,0,0}; 
	static int [][] visited; 
	static Team [] team; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ; 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		teamCnt = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken()); 
		map = new int [N][N]; 
		visited = new int [N][N]; 
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}

		team = new Team[teamCnt]; 
		int index = 0; 
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] ==1) {
					team[index] = new Team(0, 0, true, new ArrayList<>()); 
					visited[i][j] = 1; 
					team[index].list.add(new int [] {i,j}); 					
					dfs(team[index++], i, j, 1 ); 
				}
			}
			
		}
		
		for(int i = 0; i<teamCnt; i++) {
			System.out.println(team[i].list.size());
			for(int j= 0; j<team[i].list.size(); j++) {
				System.out.print(" "+ team[i].list.get(j)[0]+" "+ team[i].list.get(j)[1]);
			}
			System.out.println();
		}
	}

	static void dfs(Team t, int i, int j, int loc ) {
		
		for(int d = 0; d<4; d++) {
			int nx = j + dx[d]; 
			int ny = i + dy[d]; 
			if(ny<0||ny>=N||nx<0||nx>=N)continue; 
			if(map[ny][nx] == 0)continue; 			
			if(visited[ny][nx] == 1)continue; 
			t.list.add(new int [] {ny, nx}); 
			visited[ny][nx] = 1; 
			if(map[ny][nx] == 3) t.tail = loc; 
			dfs(t, ny, nx, loc+1); 
		}

	}
	
	
	
	
	static class Team	{
		int head; 
		int tail; 
		boolean direction; 
		//1이면 오른쪽, 0이면 왼쪽 
		ArrayList <int []> list;
		
		public Team(int head, int tail, boolean direction, ArrayList<int[]> list) {
			super();
			this.head = head;
			this.tail = tail;
			this.direction = direction;
			this.list = list;
		} 
		
		
	}
	static int round1 () {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]>0)return map[i][j]*map[i][j]; 
			}
		}
		return 0; 
		
	}
	
	static int round2 () {
			
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=0; j--) {
				if(map[j][i]>0)return map[j][i]*map[j][i]; 
			}
		}
		return 0; 
	}
		
	static int round3 () {
		
		for(int i=N-1; i>=0; i--) {
			for(int j=N-1; j>=0; j--) {
				if(map[i][j]>0)return map[i][j]*map[i][j]; 
			}
		}
		return 0; 
		
		
	}
	
	static int round4 () {
		
		for(int i=N-1; i>=0; i--) {
			for(int j=0; j>N; j++) {
				if(map[j][i]>0)return map[j][i]*map[j][i]; 
			}
		}
		return 0; 
	}

}


