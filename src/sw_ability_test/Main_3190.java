package sw_ability_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_3190 {

	static int N; 
	static int K; 
	static int move; 
	static int [][]map; 
	static int [][]visited; 
	static List <int []> list; 
	//위 오른쪽 아래쪽 왼쪽 	
	static int [] dx = {0, 1, 0, -1}; 
	static int [] dy = {-1, 0, 1, 0}; 
	static Map<Integer, Character> m; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		map = new int [N][N]; 
		visited = new int [N][N]; 
		st = new StringTokenizer(br.readLine()); 
		K = Integer.parseInt(st.nextToken()); 
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine()); 
			int row = Integer.parseInt(st.nextToken())-1; 
			int col = Integer.parseInt(st.nextToken())-1; 
			map[row][col] = 2; //사과 			
		}
		m = new HashMap<>(); 
		st = new StringTokenizer(br.readLine()); 
		move = Integer.parseInt(st.nextToken()); 
		for(int i=0; i<move; i++) {
			int a; 
			char c; 
			st = new StringTokenizer(br.readLine()); 
			a = Integer.parseInt(st.nextToken()); 
			c = st.nextToken().charAt(0); 
			m.put(a, c); 
		}
		 
		list = new LinkedList<>(); 
		list.add(new int [] {0,0}); 
		visited[0][0] = 1; 
		map[0][0] = 1; 
		int y = 0; 
		int x = 0; 
		int dir = 1; 
		int second=0; 
		while(true) {
			second++; 
			y+=dy[dir]; 
			x+=dx[dir]; 
			if(y<0||y>=N||x<0||x>=N)break; 
			if(visited[y][x]==1)break; 
			
			if(map[y][x]==2) {//사과 있을 때 
				list.add(new int[] {y,x}); 
				visited[y][x] =1; 
				map[y][x] = 1; 
			}
			else { //사과 없을 때 
				list.add(new int [] {y,x}); 
				visited[y][x] = 1; 
				int [] yx = list.get(0); 
				visited[yx[0]][yx[1]]=0; 
				list.remove(0); 
			}			
			
			if(m.get(second)!=null) {
				if(m.get(second)=='D') {
					dir+=1;				
					if(dir==4)dir=0; 
				}
				else if(m.get(second)=='L') {
					dir-=1; 					
					if(dir==-1)dir=3; 
				}
			}			
		}
		System.out.println(second);
	}
}
