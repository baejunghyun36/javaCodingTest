package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main_9205 {

	static int [] dx = {0, 50, 0, -50}; //북동남서순
	static int [] dy = {50, 0, -50, 0}; //북동남서순
	static int [] house; 
	static LinkedList<Store> storeList; 
	static int [] des; //목적지
	static Queue <int []> q; 
	static int lineValue = 32768; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = null; 
		int testCase = Integer.parseInt(br.readLine()); 
		
		for(int t = 1; t<=testCase; t++) {			
			
			int storeCnt = Integer.parseInt(br.readLine()); 
			house = new int[2]; 
			st = new StringTokenizer(br.readLine()); 
			house[1] = Integer.parseInt(st.nextToken()); //x
			house[0] = Integer.parseInt(st.nextToken()); //y
			
			storeList = new LinkedList<>(); 
			for(int i=0; i<storeCnt; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); 
				int y = Integer.parseInt(st.nextToken()); 
		
				storeList.add(new Store(x, y)); 				
			}
			
			des = new int[2]; 
			st = new StringTokenizer(br.readLine()); 
			des[1] = Integer.parseInt(st.nextToken()); //x
			des[0] = Integer.parseInt(st.nextToken()); //y
			
			for(int i=0; i<storeCnt; i++) {
				Store s = storeList.get(i); 
				s.dis =  Math.abs(des[0]-s.y)+Math.abs(des[1]-s.x); 
			}
			q = new LinkedList <>(); 
			q.add(new int [] {house[0], house[1], 20, Math.abs(house[1]-des[1])+Math.abs(house[0]-des[0])}); 
			if(bfs()) System.out.println("happy");
			else System.out.println("sad");
		}

	}

	static boolean bfs() {
		
		while(!q.isEmpty()) {
			
			int [] yx = q.poll(); 
			int curY = yx[0]; 
			int curX = yx[1]; 
			int restBottle = yx[2]; 
			int disToDes = yx[3]; 
			System.out.println(curY+" "+curX);
			if(curY==des[0]&&curX==des[1]) {
				return true; 
			}
			for(int i=0; i<4; i++) {
				int nx = curX+dx[i]; 
				int ny = curY+dy[i]; 
				if(ny<-lineValue||ny>lineValue||nx<-lineValue||nx>lineValue)continue; 
				if(Math.abs(ny-des[0])+Math.abs(nx-des[1])>disToDes)continue; 
				for(int j=0; j<storeList.size(); j++) {
					Store store = storeList.get(j); 
					if(Math.abs(ny-des[0])+Math.abs(nx-des[1])<store.dis) {						
						q.add(new int [] {store.y, store.x, 20, Math.abs(store.x-des[1])+Math.abs(store.y-des[0])}); 
						storeList.remove(j); 												
					}
				}
				q.add(new int[] {ny, nx, restBottle-1,Math.abs(ny-des[0])+Math.abs(nx-des[1])}); 
			}
		}
		return false; 
	}
		
	static class Store{
		
		int x; 
		int y;
		int dis; 
		public Store(int x, int y) {
			super();
			this.x = x;
			this.y = y;		
		}
	}
	
}
