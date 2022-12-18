package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1987 {

	static int M,N;
	static char [][] board; 
	static Map <Character, Integer> map; 
	static int [] dy = {0,0,1,-1}; 
	static int [] dx = {1,-1,0,0}; 
	static int answer; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		M = Integer.parseInt(st.nextToken()); 
		N = Integer.parseInt(st.nextToken()); 
		map = new HashMap<>(); 
		for(char i = 'A'; i<='Z'; i++) map.put(i, 0); 
		
		board = new char[M][N]; 
		for(int i=0; i<M; i++) {
			String s  = br.readLine(); 
			for(int j=0; j<s.length(); j++) {
				board[i][j] = s.charAt(j); 
			}
		}
		
		map.put(board[0][0], 1); 
		
		dfs(0,0,1); 
		sb.append(answer); 
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int y, int x, int cnt) {
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i]; 
			int ny = y+dy[i]; 
			if(ny<0||ny>=M||nx<0||nx>=N)continue; 
			if(map.get(board[ny][nx])==1)continue; 
			map.put(board[ny][nx], 1); 
			dfs(ny,nx, cnt+1); 
			map.put(board[ny][nx], 0); 
		}
		answer = Math.max(answer, cnt); 
		return; 
		
	}

}
