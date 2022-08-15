package sw_ability_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_20057_미해결 {

	
	static int N; 
	static int [][] map; 
	static int [] dx = {1, 1, 0, 0, -2, 0,0,-1,-1, -1}; 
	static int [] dy = {-1, 1, -2, 2,0, -1, 1, -1, 1, 0}; 
	static int result; 
	static int cnt; 
	public static void main(String[] args) throws IOException {
	
		StringTokenizer st = null; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); 
		map = new int[N+1][N+1]; 
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}

		move(N/2+1, N/2+1, 1); 
		//move(0, N/2, N/2); 
		
		sb.append(result);
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void move(int y, int x , int dis) {
		System.out.println("-------------------");
	    System.out.println("y : "+ y + " x : "+ x);
		if(cnt==N*N-1)return; 
		int startX = x-1; 
		int endX = x-dis; 
		if(endX<=0)endX=0; 
		System.out.println("startX : "+startX+" endX : "+ endX+" y : "+y+" dis : "+dis);
		System.out.println("result : "+ result);
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.printf("%d ", map[i][j]);
			}System.out.println();
		}

	//	System.out.println("뿌려야 하는 모래양 : "+map[y][startX]);
		for(int i=startX; i>=endX; i--) {
			int size=0; 
			if(map[y][i]==0)continue; 
			for(int j=0; j<10; j++) {
				int ny = y+dy[j]; 
				int nx = i+dx[j]; 
				if(ny<=0||ny>N||nx<=0||nx>N) {
					switch(j) {
					case 0:  size+=(map[y][i]/100); break; 
					case 1: size+=(map[y][i]/100);break; 
					case 2:  size+=(map[y][i]*2)/100; break; 
					case 3:   size+=(map[y][i]*2)/100;break; 
					case 4:  size+=(map[y][i]*5)/100; break; 
					case 5:size+=(map[y][i]*7)/100; break; 
					case 6:  size+=(map[y][i]*7)/100;break; 
					case 7: size+=(map[y][i]*10)/100;break; 
					case 8: size+=(map[y][i]*10)/100; break; 
					case 9: result+=map[y][i]-size;  break; 
					}
					continue;
				} 
			
				switch(j) {
				case 0: map[ny][nx]+=(map[y][i]/100);   size+=(map[y][i]/100); break; 
				case 1: map[ny][nx]+=(map[y][i]/100);   size+=(map[y][i]/100);break; 
				case 2: map[ny][nx]+=(map[y][i]*2)/100; size+=(map[y][i]*2)/100; break; 
				case 3: map[ny][nx]+=(map[y][i]*2)/100; size+=(map[y][i]*2)/100; break; 
				case 4: map[ny][nx]+=(map[y][i]*5)/100; size+=(map[y][i]*5)/100; break; 
				case 5: map[ny][nx]+=(map[y][i]*7)/100; size+=(map[y][i]*7)/100;break; 
				case 6: map[ny][nx]+=(map[y][i]*7)/100; size+=(map[y][i]*7)/100; break; 
				case 7: map[ny][nx]+=(map[y][i]*10)/100;size+=(map[y][i]*10)/100; break; 
				case 8: map[ny][nx]+=(map[y][i]*10)/100;size+=(map[y][i]*10)/100; break; 
				case 9: map[ny][nx]+=map[y][i]-size; 
				}
			}
			
			map[y][i] = 0; 
		}
	
		cnt++; 
		rotate(); 
		if(cnt%2==0&&cnt!=1) {
			dis+=1; 
		}	
		move(endX, N-y+1, dis); 
		
	}

	
	static void rotate() {
		
		int [][]temp = new int[N+1][N+1]; 
		for(int i=0; i<=N; i++) {
			temp[i] = map[i].clone(); 
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=N; j>=1; j--) {
				map[i][N-j+1] = temp[j][i]; 
			}
		}
	
		
	}
}
