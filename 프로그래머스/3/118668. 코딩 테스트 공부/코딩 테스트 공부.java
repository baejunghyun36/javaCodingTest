import java.util.*;
class Solution {
    static int [][] dp; 
    static int maxAlp, maxCop; 
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;

 
        for(int [] info : problems){
           maxAlp = Math.max(maxAlp, info[0]); 
           maxCop = Math.max(maxCop, info[1]); 
        }
        
        if(maxAlp<=alp&&maxCop<=cop) return 0; 
        if(maxAlp<=alp) alp = maxAlp; 
        if(maxCop<=cop) cop = maxCop; 
        
        dp = new int[155][155]; 
        for(int i=0; i<=154; i++) Arrays.fill(dp[i], 99999999); 
        dp[alp][cop] = 0; 
        
        answer = solve(alp, cop,problems); 
        
        
        return answer;
    }

    
    static int solve (int startAlp, int startCop, int[][] problems){
  
        for(int i=startAlp; i<=maxAlp; i++){
            for(int j=startCop; j<=maxCop; j++){
                // if(i>=1&&j>=1)dp[i][j] = Math.min(dp[i][j], Math.min(dp[i-1][j], dp[i][j-1])+1); 
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                
                for(int [] info : problems){
                    if(i<info[0]||j<info[1])continue; 
                    int nxtAlp = i + info[2]; 
                    int nxtCop = j + info[3]; 
             
                    int nxtCost = dp[i][j] + info[4]; 
                    if(maxAlp<nxtAlp) nxtAlp = maxAlp; 
                    if(maxCop<nxtCop) nxtCop = maxCop; 
                    dp[nxtAlp][nxtCop] = Math.min(dp[nxtAlp][nxtCop], nxtCost); 
                    
                }                
            }
        }
//                 for(int p=0; p<problems.length; p++){
//                     if(i<problems[p][0] || j<problems[p][1])    continue; // 못 푸는 문제
                                        
//                     int nxt_alp = i + problems[p][2];
//                     int nxt_cop = j + problems[p][3];
//                     int nxt_cost = visit[i][j] + problems[p][4];
                    
//                     if(nxt_alp>alp_target)  nxt_alp = alp_target;
//                     if(nxt_cop>cop_target)  nxt_cop = cop_target;
                    
//                     visit[nxt_alp][nxt_cop] = Math.min(visit[nxt_alp][nxt_cop], nxt_cost);
//                 }

        

        return dp[maxAlp][maxCop]; 
        
    }
    

}