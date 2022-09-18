package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution_리트플렌즈사천성 {
	
	static char [][] map; 
	static Map <Character, ArrayList<Node>> mm; 
	static ArrayList <Character> alpa; 
	static int []visited; 
	static int M; 
	static int N; 
	static String answer = ""; 
	static char [] storage; 
	static boolean f = true; 
	public static void main(String[] args) {

		int m = 2; 
		int n = 4; 		
		M = m; 
		N = n; 
	
		alpa = new ArrayList <>(); 
		mm = new HashMap <>(); 
		String []board = {"NRYN", "ARYA"}; 
		map = new char[M][N]; 
		for(int i=0; i<m; i++) {
			String s= board[i]; 
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j); 
				if(map[i][j] =='.'||map[i][j]=='*')continue; 
				char c = map[i][j]; 
				ArrayList <Node> a; 
				if(mm.get(c)==null) a = new ArrayList<>(); 				
				else {
					a = mm.get(c); 	
					alpa.add(c); 					
				}		
				a.add(new Node(i, j)); 
				mm.put(c, a); 
			}
		}
		visited = new int[alpa.size()];
		storage = new char[alpa.size()] ;
		Collections.sort(alpa);
		backTracking(0); 
		if(answer=="")answer = "IMPOSSIBLE"; 
	
	}
	static boolean check(int y1, int x1, int y2, int x2) {
	
		int r1 = y1; 
		int c1 = x1; 
		int r2 = y2; 
		int c2 = x2; 
		char a = map[y1][x1]; 
		   if(c1 < c2){
	            if(linearColumnCheck(c1, c2, r1, a) && linearRowCheck(r1, r2, c2, a)){
	                return true;
	            }
	            if(linearRowCheck(r1, r2, c1, a) && linearColumnCheck(c1, c2, r2, a)){
	                return true;
	                }
	        }else{
	            if(linearRowCheck(r1, r2, c2, a) && linearColumnCheck(c2, c1, r1, a)){
	                return true;
	            }
	            if(linearColumnCheck(c2, c1, r2, a) && linearRowCheck(r1, r2, c1, a)){
	                return true;
	            }
	        }
		return false; 
	}
	
	
	
	
	
	  static boolean linearRowCheck(int r1, int r2, int c, char a){
	        for(int i = r1; i < r2+1; i++){
	            if(map[i][c] != '.' && map[i][c] != a)
	                return false;
	        }
	        return true;
	    }
	    
	  static boolean linearColumnCheck(int c1, int c2, int r, char a){
	        for(int i = c1; i < c2+1; i++){
	            if(map[r][i] != '.' && map[r][i] != a)
	                return false;
	        }
	        return true;
	    }

	static void backTracking(int cnt) {
		
		if(cnt==alpa.size()) {
	
		
			System.out.println(answer);
			System.out.println(Arrays.toString(storage));
			
			f = false; 
			return; 
		}
		
		for(int i=0; i<alpa.size(); i++) {
			if(visited[i]==1)continue; 
			char c = alpa.get(i); 
	
			ArrayList<Node> a = mm.get(c); 
			int y1 = a.get(0).y; 
			int x1 = a.get(0).x; 
			int y2 = a.get(1).y; 
			int x2 = a.get(1).x; 
			if(check(y1, x1, y2, x2)) {
				
				visited[i] = 1;	
				map[y1][x1] = '.';
				map[y2][x2] = '.';
				storage[cnt] = c; 
				//for(int j=0; j<M; j++)System.out.println(Arrays.toString(map[j]));
				if(f==true)backTracking(cnt+1);
				else return; 
				map[y1][x1] = c;
				map[y2][x2] = c;
				visited[i] = 0; 
			}
		}
	}
	static class Node	{
		
		int y; 
		int x;
		
		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		} 	
	}
}
