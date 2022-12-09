package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_2105 {
	static int [][]map; 
	static int [][]visited; 
	static int [] dirVisited; 
	static int testCase; 
	static int N; 
	static int startY, startX; 
	static int [] dx = {1,1,-1,-1}; //우위,우아래, 좌아래, 좌위 
	static int [] dy = {-1,1,1,-1}; 
	static int result; 
	static int []food; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st  = new StringTokenizer(br.readLine()) ;
		testCase = Integer.parseInt(st.nextToken()); 
		for(int t=1; t<=testCase; t++) {
			st = new StringTokenizer(br.readLine()); 
			N = Integer.parseInt(st.nextToken()) ; 
			map = new int [N][N]; 
			food = new int [101]; 
			result = 0; 
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					visited = new int [N][N]; 
					dirVisited = new int [4]; 
					startY = i; 
					startX = j; 
					visited[i][j] = 1; 
					food[map[i][j]]=1; 
					dfs(0, i, j, 1); 
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n"); 
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int pd, int y, int x, int cnt) {//prevDirection
		

		for(int i=0; i<4; i++) {
			
			int nx = x+dx[i]; 
			int ny = y+dy[i]; 
			if(startY==ny&&startX==nx) {
				result = Math.max(result, cnt); 
				return; 
			}
			if(ny<0||ny>=N||nx<0||nx>=N)continue; 
			if(visited[ny][nx]==1)continue; 
			if(dirVisited[i]==1&&pd!=i)continue; 
			if(food[map[ny][nx]]==1)continue; 
			
			visited[ny][nx] = 1; 
			dirVisited[i]=1; 
			food[map[ny][nx]]=1; 
			dfs(i, ny, nx, cnt+1); 
			food[map[ny][nx]]=0; 
			visited[ny][nx] = 0; 
			dirVisited[i]=0; 
			
		}
		
		
	}

}




//10               
//4                
//9 8 9 8
//4 6 9 4
//8 7 7 8
//4 5 3 5