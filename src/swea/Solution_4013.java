package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_4013 {

	static int n; 
	static int testCase; 
	static Rotate [] list; 
	static int [] direction; 
	static int [][] info; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringBuilder sb = new StringBuilder(); 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		testCase = Integer.parseInt(st.nextToken());
		
		for(int t=1; t<=testCase; t++) {
			
			st = new StringTokenizer(br.readLine()); 
			int k = Integer.parseInt(st.nextToken()); 
			
			list = new Rotate[4]; 
			direction = new int [4]; 
			info = new int[4][8]; 
			
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());  
				for(int j=0; j<8; j++) {
					info[i][j]= Integer.parseInt(st.nextToken()); 
				}
				list[i] = new Rotate(2, 6); 
			}
		
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine()); 	
				int num = Integer.parseInt(st.nextToken())-1; 
				int dir = Integer.parseInt(st.nextToken()); 
				rotateCheck(num, dir); 
			}
			int cnt =1;
			int result =0; 
			for(int i=0; i<4; i++) {
				Rotate r = list[i]; 
				int index = (r.pointLeft+2)%8; 
				if(info[i][index]==1) result+=cnt; 				
				cnt*=2; 
			}
			sb.append("#").append(t).append(" ").append(result).append("\n"); 
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}


	static void rotateFunction(int num, int dir) {
		
		if(dir==-1) {
			list[num].pointLeft+=1; 
			list[num].pointRight+=1; 
			if(list[num].pointLeft==8)list[num].pointLeft = 0; 
			if(list[num].pointRight==8)list[num].pointRight = 0; 
		}
		else {
			list[num].pointLeft-=1; 
			list[num].pointRight-=1; 
			if(list[num].pointLeft==-1)list[num].pointLeft = 7; 
			if(list[num].pointRight==-1)list[num].pointRight = 7; 
		}
	}
	
	static void rotateCheck(int num, int dir) {
		
		Map <Integer, Integer> m = new HashMap<>(); 
		m.put(num, dir); 
		int leftPoint = info[num][list[num].pointLeft]; 
		int rightPoint = info[num][list[num].pointRight]; 
		int leftdir = dir*-1; 
		int rightdir = dir*-1; 
		
		for(int i=num-1; i>=0; i--) {
			if(leftPoint==info[i][list[i].pointRight])break; 
			m.put(i, leftdir); 
			leftPoint = info[i][list[i].pointLeft]; 
			leftdir*=-1; 
		}
		for(int i=num+1; i<=3; i++) {
			if(rightPoint==info[i][list[i].pointLeft])break; 
			m.put(i, rightdir); 
			rightPoint = info[i][list[i].pointRight]; 
			rightdir*=-1; 
		}
		for(int key : m.keySet()) rotateFunction(key, m.get(key)); ;
	}
	
	static class Rotate {
		
		int pointRight; 
		int pointLeft; 

		public Rotate(int pointRight, int pointLeft) {
			
			this.pointRight = pointRight;
			this.pointLeft = pointLeft;
		} 
	}
}
