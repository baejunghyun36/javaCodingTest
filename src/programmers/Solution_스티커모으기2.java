package programmers;

import java.util.*; 
class Solution_스티커모으기2 {
    
    static int [] dp1; 
    static int [] dp2; 
    static int N; 
    static int []sticker; 
    static int answer; 
    public int solution(int sticker[]) {
   

        N = sticker.length; 
        dp1 = new int[N]; 
        dp2 = new int[N]; 
        if(N==1)return sticker[0]; 
        dp1[0] = sticker[0]; 
        dp1[1] = sticker[0];
        for(int i=2; i<N-1; i++)dp1[i] = Math.max(dp1[i-1], dp1[i-2] +sticker[i]); 
        
        dp2[0] = 0; 
        dp2[1] = sticker[1]; 
        for(int i=2; i<N; i++)dp2[i] = Math.max(dp2[i-1], dp2[i-2] +sticker[i]); 
        
        answer = Math.max(dp1[N-2], dp2[N-1]); 
       
        return answer;
    }
    

}