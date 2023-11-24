import java.util.*; 
class Solution {
    static int n; 
    static int [] dx = {0,0,1,-1}; 
    static int [] dy = {1,-1,0,0}; 
    static int [][][] dp;
    static Queue<int[]> q; 
    static int [][] board; 
    static int answer; 
    public int solution(int[][] boards) {

        n = boards.length; 
        dp = new int[4][n][n]; 
        board = boards; 
        q = new LinkedList<>(); 
        answer = 99999999; 
        q.add(new int []{-1, 0, 0, 0});
        q.add(new int []{0, -1, 0, 2}); 
        for(int i=0; i<4; i++) {
            for(int j=0; j<n; j++){
                Arrays.fill(dp[i][j], 99999999); 
            }
        }
        bfs(); 
        
        return answer;
    }
    static void bfs(){
        while(!q.isEmpty()){
            int [] info = q.poll(); 
            if(info[0]==n-1&&info[1]==n-1) {
                answer = Math.min(answer, info[2] -100); 
                continue; 
            }
            int cost = info[2]; 
            int prevDir = info[3]; 
            for(int i=0; i<4; i++){
                int nx = dx[i] + info[1]; 
                int ny = dy[i] + info[0]; 
                if(ny<0||ny>=n||nx<0||nx>=n) continue; 
                if(board[ny][nx] == 1) continue; 
                if(prevDir==i){
                    if(dp[i][ny][nx]> cost + 100) {
                        dp[i][ny][nx] = cost + 100; 
                        q.add(new int [] {ny, nx, cost+100, i}); 
                    }
                }
                else{
                    if(dp[i][ny][nx]> cost + 600){
                        dp[i][ny][nx] = cost + 600; 
                        q.add(new int [] {ny, nx, cost+600, i}); 
                    }
                }
            }
        }
        
    }
}