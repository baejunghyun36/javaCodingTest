class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        
        int l= 1; 
        int h = 200000000; 
        
        while(l<=h){
            
            int mid = (l+h)/2; 
            int cnt = 0; 
            for(int i=0; i<stones.length; i++){
                if(stones[i]<mid){
                    cnt++; 
                    if(cnt==k){
                        h = mid -1; 
                        break; 
                    }
                }
                else cnt = 0; 
                if(i==stones.length-1){
                    answer = mid; 
                    l = mid + 1; 
                }
            }
            
            
            
        }
        
        
        return answer;
    }
}