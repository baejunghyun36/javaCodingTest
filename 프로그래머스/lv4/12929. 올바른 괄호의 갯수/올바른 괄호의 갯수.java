
import java.util.*;
class Solution {
    static int [][] dp; 
    public int solution(int n) {
        int answer = 0;
        dp = new int[15][15]; 
        // dp[1][1] = 1;
        // dp[2][2] = 2; 
        // dp[3][3] = 5; 
        
        dfs(n, n); 
        
        answer = dp[n][n]; 
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                System.out.println(i+" " + j + " " + dp[i][j]);
            }
        }
        
        
        return answer;
    }
    
    static int dfs(int l, int r){
        // if(l==0&&r==1)System.out.println("hi"); 
        System.out.println(l + " " + r); 
        if(l>r){                            
            dp[l][r] = -1; 
            return 0; 
        }
        if(l<=0||r<=0){
            dp[l][r] = 1; 
            return 1;
        } 

        if(dp[l][r]==-1)return 0; 
        if(dp[l][r]!=0) return dp[l][r]; 
        
        return dp[l][r] = dfs(l-1, r) + dfs(l, r-1);       
        
    }
}