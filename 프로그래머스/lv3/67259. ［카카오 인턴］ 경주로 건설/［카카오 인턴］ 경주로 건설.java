import java.util.*; 
class Solution {
    static int [][][] dp; 
    static int [] dx = {0,0,-1,1}; 
    static int [] dy = {-1,1,0,0}; 
    static Queue<int[]> q;     
    static int m, n;
    static int inf = 987654321; 
    static int answer; 
    public int solution(int[][] board) {
        answer = inf;
        m = board.length; 
        n = board[0].length; 
        dp = new int [m][n][4]; 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<4; k++){
                    dp[i][j][k] = inf; 
                }
            }
        }
        q = new LinkedList<>(); 
        q.add(new int[]{0,0,-1,0}); 
        bfs(board); 
        
        return answer;
    }
    
    static void bfs(int [][] map){
        
        while(!q.isEmpty()){
            
            int [] info = q.poll(); 
            int y = info[0]; 
            int x = info[1]; 
            int prevDir = info[2];
            int cost = info[3];
            if(y==m-1&&x==n-1){
                answer = Math.min(answer, cost); 
                continue; 
            }
            for(int i=0; i<4; i++){
                int nx = x + dx[i]; 
                int ny = y + dy[i]; 
                int c = cost; 
                if(ny<0||ny>=m||nx<0||nx>=n)continue; 
                if(map[ny][nx]==1)continue; 
                if(prevDir==-1||prevDir==i)c += 100; 
                else c+=600; 
                
                if(dp[ny][nx][i]>c){
                    dp[ny][nx][i] = c; 
                    q.add(new int [] {ny, nx, i, c}); 
                }
                
                
                
            }
            
            
        }
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
}