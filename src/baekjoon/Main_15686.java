package baekjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15686 {

	
	static int [][] map ; 
	static int [][] dis; 
	static int m; 
	static int ch; 
	static Queue<int []> q; 
	static List<int []> home; 
	static int [] dx = {0,0,-1,1}; 
	static int [] dy = {1,-1, 0,0}; 

	static int chickenNumber; 
	static List<int[]> chicken; 
	static int chickenM; 
	static int minNumber; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		 StringBuilder sb = new StringBuilder(); 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		 StringTokenizer st = new StringTokenizer(br.readLine()); 
		 
		 m = Integer.parseInt(st.nextToken()); 
		 ch = Integer.parseInt(st.nextToken()); 
		 
		 minNumber = Integer.MAX_VALUE; 
		 q = new LinkedList<>(); 
		 chicken = new ArrayList<>(); 
		 home = new ArrayList<>(); 
		
		 map = new int[m][m]; 
		 
		 for(int i=0; i<m; i++) {
			 st = new StringTokenizer(br.readLine()); 
			 for(int j=0; j<m; j++) {
				 map[i][j] = Integer.parseInt(st.nextToken());
				 if(map[i][j] ==1) {
					 home.add(new int[] {i,j}); 
				 }
				 if(map[i][j] ==2) {
					 
					 chickenNumber++; 
					 chicken.add(new int[] {i,j}); 
				 }
			 }
		 }
		 chickenM = chickenNumber- ch; 
		 
		 comb(0, 0); 
		
		 sb.append(minNumber); 

		 bw.write(sb.toString());
		 bw.flush();
		 bw.close(); 
	}
	
	static void comb(int cnt, int start) {
		
		if(cnt==chickenM) {
			minNumber = Math.min(minNumber, bfs()); 
			return; 
		}
		for(int i=start; i<chickenNumber; i++) {
			int y = chicken.get(i)[0];
			int x = chicken.get(i)[1]; 
			
			map[y][x] =0;
			comb(cnt+1, i+1	); 
			map[y][x]=2; 
			comb(cnt, i+1); 
		}
	}
	
	
	
	
	
	static int bfs() {
		
		int [][] temp = new int[m][m]; 
		List <int[]> chick = new ArrayList<>(); 
		for(int i=0; i<m; i++) {
			temp[i] = map[i].clone(); 
			for(int j=0; j<m; j++) {
				if(temp[i][j]==2) {
					chick.add(new int[] {i,j}); 
				}
			}
		}
		
		int result =0; 
		for(int i=0; i<home.size(); i++) {
			int sum =0; 
			int minnumber = Integer.MAX_VALUE; 
			for(int j=0; j<chick.size(); j++) {
				sum = Math.abs(chick.get(j)[0]-home.get(i)[0])+Math.abs(chick.get(j)[1]-home.get(i)[1]); 
				minnumber = Math.min(minnumber, sum); 
			}
			result+=minnumber; 
		}
		return result; 
		
	}

}








