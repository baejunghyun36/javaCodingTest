package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17143 {
	static int M; 
	static int N; 
	static int sharkCount; 
	static int [][] map; 
	static int answer; 
	static ArrayList <Shark> sharkList; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//r, c, count	
		//r,c,s,d,z 
		//행,열,속력, 이동방향, 크기 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); 
		sharkCount = Integer.parseInt(st.nextToken()); 
		map = new int [M+1][N+1]; 
		for(int j=1; j<=M; j++)Arrays.fill(map[j], -1);
		int num =0; 
		sharkList = new ArrayList<>(); 
		for(int i=0; i<sharkCount; i++) {
			st = new StringTokenizer(br.readLine()); 			
			int r = Integer.parseInt(st.nextToken()); //행
			int c = Integer.parseInt(st.nextToken()); //열
			int s = Integer.parseInt(st.nextToken()); //속력
			int d = Integer.parseInt(st.nextToken()); //방향
			int z = Integer.parseInt(st.nextToken()); //속도
			map[r][c] = num; 
			sharkList.add(new Shark(r, c, s, d, z, num++, false)); 
		}
	
		for(int col=1; col<=N; col++) {
			catchShark(col); //상어를 잡아볼까
			for(int j=1; j<=M; j++)Arrays.fill(map[j], -1);
			moveShark(); //상어야 움직여	
		}
	
		System.out.println(answer);
		
	}
	static void catchShark(int col) {
		for(int i=1; i<=M; i++) {
			if(map[i][col]!=-1) {
				sharkList.get(map[i][col]).isEaten=true; 
				answer+=sharkList.get(map[i][col]).z;			
				break; 
			}
		}
	}
	
	static void moveShark() {		
		for(int i=0; i<sharkCount; i++) {
			Shark shark = sharkList.get(i); 
			if(shark.isEaten==true)continue; 		
			switch (shark.d) {
				case 1 :rowUpdate(shark); break; 					
				case 2 :rowUpdate(shark); break;  			
				case 3 :colUpdate(shark); break; 		
				case 4 :colUpdate(shark); break; 		
			}		
			if(map[shark.r][shark.c]==-1) {
				map[shark.r][shark.c]=shark.num; 
				continue; 				
			}
			Shark storeShark = sharkList.get(map[shark.r][shark.c]);
			if(storeShark.z<shark.z) {
				map[shark.r][shark.c] = shark.num; 
				storeShark.isEaten=true; 
			}
			else shark.isEaten= true; 
		}
	}
	
	static void colUpdate(Shark shark) {
		int s =  shark.s % ((N-1)*2); 
		int c = shark.c; // 열 위치
		for(int j=0; j<s; j++) {
			if(c==1) {
				shark.d = 3; 
				c = 2; 
			}
			else if(c==N) {
				shark.d = 4; 
				c = N-1; 
			}
			else if(shark.d==3) c++; 
			else if(shark.d==4) c--; 							
		}	
		shark.c = c; 		
	}
	static void rowUpdate(Shark shark) {
		int s =  shark.s % ((M-1)*2); 
		int r = shark.r; // 행 위치
		for(int j=0; j<s; j++) {
			if(r==1) {
				shark.d = 2; 
				r = 2; 
			}
			else if(r==M) {
				shark.d = 1; 
				r = M-1; 
			}
			else if(shark.d==1) r--; 		
			else if(shark.d==2) r++; 					
		}	
		shark.r = r; 	
	}
	

	static class Shark {
		
		int r; //행
		int c; //열
		int s; //속력
		int d; //방향
		int z; //크기
		int num; //상어 번호 
		boolean isEaten; 
		
		public Shark(int r, int c, int s, int d, int z, int num, boolean isEaten) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.num = num; 
			this.isEaten = isEaten; 
		}
	}
}
