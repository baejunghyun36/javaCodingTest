import java.util.*;

public class Solution {
    
    public int solution(int n) {
        int ans = 1;
        
        while(n>1){
            if(n%2==0)n/=2; 
            else {
                ans++; 
                n-=1; 
            }
        }
        return ans;
    }
}
//6 -> 3 -> 2 -> 1

    
