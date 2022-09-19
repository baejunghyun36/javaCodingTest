package programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import programmers.Solution_코드트리_꼬리잡기놀이.Team;

public class Main {

	static int N; 
	static int teamCnt; 
	static int K; //라운트 갯수 
	static int [][] map; 
	static int [] dx = {0,0,1,-1};
	static int [] dy = {1,-1,0,0}; 
	static int [][] teamMap; 
	static Team [] team;
	static int index; 
	static int [][]visited; 
	static int result; 
	static int [][]vv; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ; 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		result = 0; 
		
		N = Integer.parseInt(st.nextToken());
		teamCnt = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());  //라운드 수 
		teamMap  = new int [N][N]; 
		map = new int [N][N]; 	
		visited = new int [N][N]; 
		team = new Team[teamCnt+1]; 

		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine()); 
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		
		index = 1; 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++)	{
				if(map[i][j] ==1) {
					team[index] = new Team(new int []{i,j}, new int[] {0,0}, 0, index); 
					teamMap[i][j] = index; 				
					dfs(team[index], i, j ); 
					index++; 
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
		int r = 1; 
		for(int rr=1; rr<=K; rr++) {
			
			for(int i=1; i<=teamCnt; i++) {
				Team t = team[i]; 
		
				for(int j=0; j<4; j++) {
					int ny = t.tail[0]+dy[j]; 
					int nx = t.tail[1]+dx[j];
					if(ny<0||ny>=N||nx<0||nx>=N)continue; 
					if(teamMap[ny][nx]!=t.teamNumber)continue; 
					if(map[ny][nx]!=2)continue; 
					map[ny][nx] = 3; 
					map[t.tail[0]][t.tail[1]] = 4; 		
					t.tail[0] = ny; 
					t.tail[1] = nx; 
					break;
				}
				for(int j=0; j<4; j++) {
					int ny = t.head[0]+dy[j]; 
					int nx = t.head[1]+dx[j];
					if(ny<0||ny>=N||nx<0||nx>=N)continue; 
					if(teamMap[ny][nx]!=t.teamNumber)continue; 
					if(map[ny][nx]!=4)continue; 
					map[t.head[0]][t.head[1]] = 2; 
					map[ny][nx] = 1; 			
					t.head[0] = ny; 
					t.head[1] = nx; 
					break ;
				}
			}
//			
			System.out.println("1칸씩 이동해!!!! round" + r);
			for(int i=0; i<N; i++) {
				System.out.println(Arrays.toString(map[i]));
			}
			
			//라운드 수 K 
			if(r>=1&&r<=N) right(r); 
			if(r>=N+1&&r<=2*N)up(r); 
			if(r>=2*N+1&&r<=3*N)left(r); 
			if(r>=3*N+1&&r<=4*N)down(r); 

			
			if(rr%(4*N)==0)r=1; 
			else r++; 
		
			
		}
	
	
		System.out.println(result);
	}
	
	static void sum (int y, int x, int headY, int headX, int number, int cnt) {
		if(headY==y&&headX==x) {
		    int y1 = team[number].head[0]; 
		    int x1 = team[number].head[1]; 
		    int y2 = team[number].tail[0]; 
		    int x2 = team[number].tail[1]; 
		    team[number].head[0] = y2; 
		    team[number].head[1] = x2; 
		    team[number].tail[0] = y1; 
		    team[number].tail[1] = x1; 
//			map[team[number].head[0]][team[number].head[1]]=3; 
//			map[team[number].tail[0]][team[number].tail[1]]=1; 
//			int []temp = team[number].head; 
//			team[number].head = team[number].tail;
//			team[number].tail= temp; 
			result += cnt*cnt; 
			return; 
		}
		for(int i=0; i<4; i++) {
			int nx = headX+dx[i]; 
			int ny = headY+dy[i]; 
			if(ny<0||ny>=N||nx<0||nx>=N)continue; 
			if(vv[ny][nx]==1)continue; 
			if(teamMap[ny][nx]!=number)continue; 
			if(map[ny][nx]==4||map[ny][nx]==0)continue; 
			vv[ny][nx] = 1; 
			//System.out.println("cnt : "+cnt);
			sum(y, x, ny, nx, number, cnt+1); 
		}
		
	}
	
	static void right(int r) {
		//System.out.println("dddd");
		for(int i=0; i<N; i++) {
			if(map[r-1][i]>=1&&map[r-1][i]<=3) {
				int y= r-1; 
				int x = i; 
				//System.out.println(map[r-1][i]);
				int number = teamMap[y][x];
				//System.out.println("team"+number);
				int []yx = team[number].head; 
				//System.out.println("head : "+ yx[0]+" "+yx[1]);
				//System.out.println("aim : "+ y+" "+x);
				vv= new int [N][N]; 
				vv[yx[0]][yx[1]]=1; 
				sum(y, x, yx[0], yx[1], number, 1); 
				return; 
			}
		}
	}
	static void up(int r) {
		r = r-N; 
		for(int i=N-1; i>=0; i--) {
			if(map[i][r-1]>=1&&map[i][r-1]<=3) {
				int y = i; 
				int x = r-1; 
				int number = teamMap[y][x];
				int []yx = team[number].head; 
				vv= new int [N][N]; 
				vv[yx[0]][yx[1]]=1; 
				sum(y, x, yx[0], yx[1], number, 1); 
				return; 
			}
		}
	}
	static void left(int r) {
		r = r-2*N; 
		for(int i=N-1; i>=0; i--) {
			if(map[N-r][i]>=1&&map[N-r][i]<=3) {
				int y = N-r; 
				int x = i; 
				int number = teamMap[y][x];
				int []yx = team[number].head; 
				vv= new int [N][N]; 
				vv[yx[0]][yx[1]]=1; 
				sum(y, x, yx[0], yx[1], number, 1); 
				return; 
			}
		}
	}
	static void down(int r) {
		r= r-3*N; 
		for(int i=0; i<N; i++) {
			if(map[i][N-r]>=1&&map[i][N-r]<=3) {
				int y = i; 
				int x = N-r; 
				int number = teamMap[y][x];
				int []yx = team[number].head; 
				vv= new int [N][N]; 
				vv[yx[0]][yx[1]]=1; 
				sum(y, x, yx[0], yx[1], number, 1); 
				return; 
			}
		}
	}
	static void dfs(Team t, int i, int j ) {
		
		for(int d = 0; d<4; d++) {
			int nx = j + dx[d]; 
			int ny = i + dy[d]; 
			if(ny<0||ny>=N||nx<0||nx>=N)continue; 
			if(map[ny][nx] == 0)continue; 			
			if(visited[ny][nx] == 1)continue; 
			visited[ny][nx] = 1; 
			teamMap[ny][nx] = index; 
			if(map[ny][nx] == 3) {
				t.tail[0] = ny; 
				t.tail[1] = nx; 
			}
			dfs(t, ny, nx); 
		}

	}
	
	static class Team{
		int [] head; 
		int [] tail; 
		int direction;
		int teamNumber; 
		public Team(int[] head, int[] tail, int direction, int teamNumber) {
			super();
			this.head = head;
			this.tail = tail;
			this.direction = direction;
			this.teamNumber = teamNumber; 
		} 
	}
}
