import java.util.*; 
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int [] dp1 = new int[money.length+1]; 
        int [] dp2 = new int[money.length+1]; 
        //첫집 방문 x
        dp1[0] = 0; 
        dp1[1] = money[1]; 
        dp1[2] = money[2]; 
        for(int i=3; i<money.length; i++){
            dp1[i] = Math.max(dp1[i-3]+money[i], dp1[i-2]+money[i]);
            dp1[i] = Math.max(dp1[i-1], dp1[i]); 
        }
        //첫집 방문 o 
        dp2[0] = money[0]; 
        dp2[1] = money[1]; 
        dp2[2] = dp2[0] + money[2]; 
        for(int i=3; i<money.length-1; i++){
            dp2[i] = Math.max(dp2[i-3]+money[i], dp2[i-2]+money[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i]); 
        }
        dp2[money.length-1] = Math.max(dp2[money.length-2], dp2[money.length-1]); 
        // System.out.println(Arrays.toString(dp1)); 
        // System.out.println(Arrays.toString(dp2)); 
        
        answer = Math.max(dp1[money.length-1], dp2[money.length-1]); 
        
        return answer;
    }
}