import java.util.*; 
class Solution {
    static int [][] map; 
    static int n; 
    static int [] dx = {0, 1, 1, 1, 0, -1, -1, -1}; 
    static int [] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; 
    static int answer; 
    public int solution(int nn) {
        n= nn; 
        map = new int[n][n]; 
        backTracking(0);
        return answer;
    }
    
    static void backTracking(int start){
        
        if(start==n){

            System.out.println(); 
            answer++; 
            return; 
        }
     
        for(int j=0; j<n; j++){
            if(map[start][j]==0){
                visitedCheck(start, j, 1); 
                backTracking(start+1); 
                visitedCheck(start, j, -1); 
            }                
        }
    }
    
    static void visitedCheck(int i, int j, int isVisited){
        
        for(int d=0; d<8; d++){
            int ny = i; 
            int nx = j;
            while(0<=ny&&ny<n&&0<=nx&&nx<n){
                map[ny][nx] += isVisited; 
                ny += dy[d]; 
                nx += dx[d]; 
            }
        }
    }
}