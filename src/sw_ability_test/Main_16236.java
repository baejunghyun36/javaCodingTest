package sw_ability_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {

	static int N; 
	static int [][] map; 
	static int sharkY; 
	static int sharkX; 
	static int sharkSize; 
	static int eatCnt; 
	static int answer; 
	static int []fishCount; 
	static int []dx = {0, -1, 1, 0}; 
	static int []dy= {-1, 0, 0, 1}; 
	static PriorityQueue <Fish> pq; 
	public static void main(String[] args) throws IOException {
		
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader   br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter	 bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder 	 sb = new StringBuilder(); 
		StringTokenizer  st = new StringTokenizer(br.readLine()); 
		
		N = Integer.parseInt(st.nextToken()); 
		map = new int[N][N]; 
		fishCount = new int[7]; 
	
		sharkSize = 2; 
		
		pq = new PriorityQueue<>(new Comparator<Fish>() {
			@Override
			public int compare(Fish o1, Fish o2) {
								
				if(o1.y==o2.y) {
					return o1.x-o2.x; 
				}
				return o1.y-o2.y; 
				
			}
		}); 
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()) ;
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				if (map[i][j]==9) {
					sharkY = i; 
					sharkX = j; 
					map[i][j] = 0; 
				}
			}
		}
		sharkSize = 2; 
		bfs(); 

		sb.append(answer); 
		bw.write(sb.toString()); 
		bw.flush();
		br.close(); 
		bw.close(); 		
	}
	static void bfs() {		
	
	    while(true) {	 
	 
	    	
			Queue <int []> q = new LinkedList<>(); 
			int [][] dis = new int[N][N]; 
			int [][] visited = new int[N][N]; 
			
		    q.offer(new int[] {sharkY, sharkX}); 
		    visited[sharkY][sharkX]=1; 

		    int yy = -1 , xx = -1; 		    
		    
	    	while(!q.isEmpty()) {		 
	    		
	    		if(pq.size()>0) {
	    			yy = pq.peek().y; 
	    			xx = pq.peek().x;
	    		//	System.out.println("상어의 위치 : y : "+sharkY+" x : "+sharkX+ " || 가야할 위치 yy : "+yy + " xx : "+xx + " 거리는 : "+ dis[yy][xx]);
	    			pq.clear();
	    			q.clear();
	    			break; 
	    		}	    

		    	int size = q.size(); 
		    	while(size>0) {
		    	  	int y = q.peek()[0]; 
			    	int x = q.peek()[1]; 
		    		q.poll(); 
		    		for(int i=0; i<4; i++) {
			    		int ny = y+dy[i]; 
			    		int nx = x+dx[i]; 
			    		if(ny<0||ny>=N||nx<0||nx>=N)continue; 		    		
			    		if(visited[ny][nx]==1||map[ny][nx]>sharkSize) continue;				    		
			    		if(map[ny][nx]>0&&map[ny][nx]<sharkSize)pq.add(new Fish(ny, nx, map[ny][nx])); 
			    		//System.out.print("{"+ny+" , "+nx+"} ");			    		
			    		q.offer(new int[] {ny, nx}); 
			    		visited[ny][nx]=1; 		 
			    		dis[ny][nx] = dis[y][x] +1; 
			    	}   
		    		size--; 
		    	}

		    }
	    	if(yy==-1&&xx==-1) {
	    		break; 
	    	}
	    	else {
	    		map[yy][xx] = 0; 
	    		sharkY = yy; 
	    		sharkX = xx;     	
	    		answer += dis[yy][xx]; 
	    		eatCnt++; 
	    		if(eatCnt==sharkSize) {
	    			eatCnt=0; 
	    			sharkSize++; 
	    		}
	    	}
	    	
	    }
	}
	
	public static class Fish {
		int y; 
		int x; 
		int size;
		public Fish() {}
		
		public Fish(int y, int x, int size) {
			super();
			this.y = y;
			this.x = x;
			this.size = size;
		} 
	}
}
