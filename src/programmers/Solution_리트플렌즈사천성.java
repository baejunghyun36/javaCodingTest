import java.util.*; 

class Solution {
    static char [][] map; 
	static Map <Character, ArrayList<Node>> mm; 
	static ArrayList <Character> alpa; 
	static int []visited; 
    static char [] storage; 
    public String solution(int m, int n, String[] board) {

		alpa = new ArrayList <>(); 
		mm = new HashMap <>(); 
        String answer = ""; 
		map = new char[m][n]; 
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
        Collections.sort(alpa);
		   
        int idx = 0;
        while(alpa.size() != 0){
            if(check(alpa.get(idx))){
                char popped = alpa.remove(idx);
                answer += popped;
                deleteChar(popped);
                idx = 0;
            } 
            else{
                idx++;
                if(idx == alpa.size()){
                    return "IMPOSSIBLE";
                }       
            }
        }
        
        return answer;
	}
	static void deleteChar(char a){
        	ArrayList<Node> aa = mm.get(a); 
            
			int y1 = aa.get(0).y; 
			int x1 = aa.get(0).x; 
			int y2 = aa.get(1).y; 
			int x2 = aa.get(1).x; 
            map[y1][x1]='.'; 
            map[y2][x2]='.'; 

    }
	
     static boolean check(char a) {
              ArrayList<Node> aa = mm.get(a); 
         	int r1 = aa.get(0).y; 
			int c1 = aa.get(0).x; 
			int r2 = aa.get(1).y; 
			int c2 = aa.get(1).x; 

		   if(c1 < c2){
	            if(ColumnCheck(c1, c2, r1, a) && RowCheck(r1, r2, c2, a)){
	                return true;
	            }
	            if(RowCheck(r1, r2, c1, a) && ColumnCheck(c1, c2, r2, a)){
	                return true;
	                }
	        }
    
            else if (c1>=c2) {
	            if(RowCheck(r1, r2, c2, a) && ColumnCheck(c2, c1, r1, a)){
	                return true;
	            }
	            if(ColumnCheck(c2, c1, r2, a) && RowCheck(r1, r2, c1, a)){
	                return true;
	            }
	        }
		return false; 
	}
	
	
	  static boolean RowCheck(int r1, int r2, int c, char a){
	        for(int i = r1; i < r2+1; i++){
	            if(map[i][c] != '.' && map[i][c] != a)
	                return false;
	        }
	        return true;
	    }
	    
	  static boolean ColumnCheck(int c1, int c2, int r, char a){
	        for(int i = c1; i < c2+1; i++){
	            if(map[r][i] != '.' && map[r][i] != a)
	                return false;
	        }
	        return true;
	    }
    

        static class Node	{

            int y; 
            int x;

            public Node(int y, int x) {

                this.y = y;
                this.x = x;

            } 	
        }
}