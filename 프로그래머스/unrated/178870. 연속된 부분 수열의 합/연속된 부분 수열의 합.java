class Solution {
    
    static int start = 0;
    static int end = 0; 
    public int[] solution(int[] sequence, int k) {
        
        int[] answer = new int[2];       
        answer[1] = 987654321; 
        int sum = sequence[0]; 
        
        while(end<sequence.length){
            if(start>end)break; 
            if(sum==k){
                if(end-start<answer[1] - answer[0]){
                    answer[1] = end; 
                    answer[0] = start; 
                }
                if(end<sequence.length-1)sum+= sequence[++end];
                else end++; 
            }
            
            else if(sum<k){
                if(end<sequence.length-1)sum+= sequence[++end];
                else end++;
            }
            
            else{
 
                sum-= sequence[start++]; 
            }
        }
        
        
        return answer;
    }
}