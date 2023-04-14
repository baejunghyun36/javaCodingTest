import java.util.*; 
class Solution {
    
    static int [][] dp; 
    static int n; 
    public int solution(int number, int[] money) {
        int answer = 0;
        dp = new int [money.length+1][number+1]; 
        Arrays.sort(money); 
        n = money.length; 
        int [] coin = new int [n+1]; 
        for(int i=1; i<=n; i++)coin[i] = money[i-1]; 
        for(int i=1; i<=n; i++){
            dp[i][coin[i]] = 1; 
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=number; j++){
                if(coin[i]>j)dp[i][j] = dp[i-1][j]; 
                else if(dp[i][j]==1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coin[i]] + 1; 
                }
                else dp[i][j] = dp[i-1][j] + dp[i][j-coin[i]]; 
            }
        }
        answer = dp[n][number]; 
        // for(int i=1; i<=n; i++){
        //     System.out.println(coin[i]); 
        //     System.out.println(Arrays.toString(dp[i])); 
        // }
        
        return answer%1000000007;
    }
}