package sw_ability_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_19236_미해결 {
	static int maxNumber; 
	static int [][] map; 
	static int N = 4; 
	static int [] dx = {0, 0,-1, -1, -1, 0, 1, 1, 1}; 
	static int [] dy = {0, -1, -1, 0, 1, 1, 1, 0,-1}; 
	static Fish [] fishInformation123; 
	static int sharkDirection; 
	static int sharkY, sharkX; 
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st  = null; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		map = new int[N+1][N+1];  //map 물고기 위치 기록
		fishInformation123 = new Fish[17];  // 물고기 클래스 생성 
		maxNumber = Integer.MIN_VALUE; 
		//물고기 삽입 
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j=1; j<=N; j++) {		
				int num = Integer.parseInt(st.nextToken()); 		
				int dir = Integer.parseInt(st.nextToken()); 
				map[i][j] = num; 
				Fish fish = new Fish(num, i, j, dir, false); 
				fishInformation123[num] = fish;
					
			}
		}
		
		//상어 1,1 자리에 투입 
		int num = map[1][1]; 
		Fish fish = fishInformation123[num]; 
		fish.isEated = true; 
		sharkDirection = fish.direction; 
		sharkY = 1; sharkX = 1; 
		map[1][1] = 0; 	
		fishMove(map, fishInformation123); 
		dfs(num, map, fishInformation123 ); 
		sb.append(maxNumber); 
		
		bw.write(sb.toString());
		bw.flush();
		bw.close(); 
		br.close();
	}

	static void dfs(int sum, int [][]temp, Fish[] fishInformation) {

		
		

		//fishMove(temp); 

//		
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				if(temp[i][j]==0) {
//					System.out.printf("xx ");
//					continue;
//					
//				}
//				System.out.printf("%2d ", fishInformation[temp[i][j]].direction );
//			}
//			System.out.println();
//		}
		int ny = sharkY + dy[sharkDirection]; 
		int nx = sharkX + dx[sharkDirection];
		
		List <int []> sharkMoveCase = new ArrayList<>(); 
		
		while(ny>=1&&ny<=N&&nx>=1&&nx<=N) {
			if(temp[ny][nx]==0)break; 
			sharkMoveCase.add(new int[] {ny, nx}); 
			ny+=dy[sharkDirection]; 
			nx+=dx[sharkDirection]; 		
		}
		if(sharkMoveCase.size()==0) {
			maxNumber = Math.max(sum, maxNumber); 
			return; 
		}
		for(int i=0; i<sharkMoveCase.size(); i++) {		
			int [][] ttemp = new int [N+1][N+1];
			Fish [] fishinfo = new Fish[17]; 
			for(int j=1; j<=16; j++) {
				int y = fishInformation[j].y; 
				int x = fishInformation[j].x;
				int direction = fishInformation[j].direction; 
				boolean isEated = fishInformation[j].isEated; 
				Fish fish = new Fish (j, y, x, direction, isEated); 
				fishinfo[j] = fish; 
			}
			
			for(int j=0; j<=N; j++) {
				ttemp[j] = temp[j].clone(); 
			}
			int y = sharkMoveCase.get(i)[0]; 
			int x = sharkMoveCase.get(i)[1]; 
			int fishNumber = ttemp[y][x]; 
			sharkY = y; 
			sharkX = x; 
			sharkDirection = fishinfo[fishNumber].direction; 
			fishinfo[fishNumber].isEated = true; 	
			ttemp[y][x] = 0;
			
			System.out.println("sharkY : "+ sharkY + " sharkX : " + sharkX + " 먹은 물고기 Number : "+fishNumber+" 방향 : "+sharkDirection);
			for(int k=1; k<=N; k++) {
				for(int j=1; j<=N; j++) {
					if(k==sharkY&&j==sharkX)System.out.print("sha ");
					else
					System.out.printf("%3d ",temp[k][j]);
				}
				System.out.println();
			}
			System.out.println();
			
			fishMove(ttemp, fishinfo); 
			dfs(sum+fishNumber, ttemp, fishinfo); 
			fishInformation[fishNumber].isEated = false; 
			
			System.out.println("----------------");
		}
		return; 
	}
	
	
	static void fishMove(int [][] m, Fish[] fishInformation) {
		
		for(int i=1; i<=16; i++) {
			if(fishInformation[i].isEated==true)continue; 
			Fish fish = fishInformation[i]; 
			int y = fish.y; 
			int x = fish.x; 
			int dir = fish.direction; 
			int end = 8; 
			for(int j= dir; j<=end; j++) {
			
				int nx = dx[j]+x; 
				int ny = dy[j]+y; 
			
				if(ny<1||ny>N||nx<1||nx>N) {
					if(j==8) {
						j=0; 
						end = dir-1; 
					}
					continue; 
				}
				if(ny==sharkY&&nx==sharkX)continue; 
				if(m[ny][nx]>=1) { //스왑
					fishInformation[m[ny][nx]].y = y; 
					fishInformation[m[ny][nx]].x = x; 
					//if(m[ny][nx]==13)System.out.println("현재 물고기 : "+i+"번, 13번 물고기 방향 : "+ fishInformation[13].direction);
					fish.y = ny; 
					fish.x = nx; 
					fish.direction = j;	
					int temp =m[ny][nx] ; 
					m[ny][nx] = m[y][x]; 
					m[y][x] = temp; 					
					break; 
				}
				else if(m[ny][nx]==0) { //이동
					m[ny][nx] = fish.number; 
					m[y][x] =0; 
					fish.direction = j;	
					fish.y = ny; 
					fish.x = nx; 
					break; 
				}			
				if(j==8) {
					j=0; 
					end = dir-1; 
				}
				
			}
		}
	}
	
	static class Fish{
		int number; 
		int y; 
		int x; 
		int direction; 
		boolean isEated;
		
		public Fish() {}
		public Fish(int number, int y, int x, int direction, boolean isEated) {
			super();
			this.number = number;
			this.y = y;
			this.x = x;
			this.direction = direction;
			this.isEated = isEated;
		} 
	}
}
