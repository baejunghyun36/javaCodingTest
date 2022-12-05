package sw_ability_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_헌터 {

	static int seconds; 
	static int [][] map; 
	static Monster [] monster; 
	static Guest [] guest; 
	static int N; 
	static Hunter hunter; 
	static int [] orderHunting;
	static int cnt; 
	static int []visited; 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st; 
		int testCase = Integer.parseInt(br.readLine()); 
		for(int t = 1; t<=testCase; t++) {
			
			
			N = Integer.parseInt(br.readLine()); 
			monster = new Monster[5]; 
			guest = new Guest[5]; 

			map = new int [N+1][N+1]; 
			cnt =0; 
			seconds = 987654321; 
			for(int i=1; i<=N; i++) {
				st = new StringTokenizer(br.readLine()); 
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
					if(map[i][j]>0) {monster[map[i][j]] = new Monster(i, j, false); cnt++; }
					if(map[i][j]<0)guest[Math.abs(map[i][j])]= new Guest(i,j, false);
					
				}
			}

			hunter = new Hunter(1,1); 
			orderHunting = new int[cnt*2+1]; 
			visited = new int [cnt*2+1]; 
			perm(1); 
			sb.append("#").append(t).append(" ").append(seconds).append("\n"); 
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void moveHunter() {
		
		int sum=0; 
		for(int i=1; i<=cnt*2; i++) {
			int s = 0; 
			int Number = orderHunting[i]; 
			
			if(Number<=cnt) {
	
				s = Math.abs(hunter.y-monster[Number].y) + Math.abs(hunter.x-monster[Number].x); 

				monster[Number].die = true;
				guest[Number].visitPossible=true; 		
				hunter.y = monster[Number].y; 
				hunter.x = monster[Number].x; 
			}
			else if(Number>cnt) {				
				Number-=cnt;
				if(guest[Number].visitPossible==false) return; 				
				s = Math.abs(guest[Number].y-hunter.y) + Math.abs(guest[Number].x-hunter.x); 

				hunter.y = guest[Number].y; 
				hunter.x = guest[Number].x; 
			}
			sum+=s; 
		}
		seconds = Math.min(seconds, sum); 

	}
	
	
	
	static void perm(int index) {
		if(index==cnt*2+1) {			
			moveHunter(); 
			for(int i=1; i<=cnt; i++) {
				monster[i].die=false; 
				guest[i].visitPossible=false; 
				hunter.y = 1; 
				hunter.x = 1; 
			}
			return; 
		}
		for(int i=1; i<=cnt*2; i++) {
			if(visited[i]==1)continue; 
			visited[i] = 1; 
			orderHunting[index] = i; 
			perm(index+1); 
			visited[i] = 0; 
		}
		
	}
	
	
	static class Hunter{
		int y; 
		int x;
		public Hunter(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		} 
		
	}
	
	static class Monster{
		int y; 
		int x;
		boolean die; 
		public Monster(int y, int x, boolean die) {
			super();
			this.y = y;
			this.x = x;
			this.die = die; 
		} 
		
	}
	
	static class Guest{
		int y; 
		int x;
		boolean visitPossible; 
		public Guest(int y, int x, boolean visitPossible) {
			super();
			this.y = y;
			this.x = x;
			this.visitPossible = visitPossible; 
		} 
		
	}

}
