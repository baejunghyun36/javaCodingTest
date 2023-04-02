import java.util.*; 
class Solution {
    static int [] dp1, dp2; 
    public int solution(int[] a) {
        
        int answer = 0;
        
        //
        
        dp1 = new int [a.length]; 
        dp2 = new int [a.length];    
        
        dp1[0] = a[0]; 
        dp2[a.length-1] = a[a.length-1]; 
 
        for(int i=1; i<a.length; i++) dp1[i] = Math.min(dp1[i-1], a[i]);    
        for(int i=a.length-2; i>=0; i--) dp2[i] = Math.min(dp2[i+1], a[i]); 
          
        if(a.length<=2)answer = a.length; 
        else{
            answer = 2; 
            for(int i= 1; i<a.length-1; i++){
                if(!(a[i]>dp1[i-1]&&a[i]>dp2[i+1]))  answer++; 
            }
        }
        
        return answer;
    }
}

//자기보다 작은게 양쪽에 두개 있으면 fail 
//그게 아니면 성공 