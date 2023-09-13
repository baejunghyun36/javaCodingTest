import java.util.*; 
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

            
        int l = 0; 
        int h = Integer.MAX_VALUE-1; 
        
        while(l<=h){
            int mid = (l+h)/2; 
            
            if(check(stones, mid, k)){

                answer = mid;
                l = mid+1; 
            }
            else{
                h = mid -1; 
            }
        }
        
        
        return answer; 
    }
    
    static boolean check (int[]stones, int friends, int k){
        int skip = 0; 
        for(int i=0; i<stones.length; i++){
            if(friends >stones[i])skip++; 
            else skip = 0; 
            if(k==skip)return false; 
        }
        return true; 
    }

}