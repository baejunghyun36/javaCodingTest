class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int [2]; 
        int start = 0; 
        int minLen = 1000001;
        int sum = 0; 
        for(int end = 0; end < sequence.length; end++){
            sum += sequence[end]; 
            if(sum<k)continue; 
            while(sum>k) sum -= sequence[start++]; 
            if(sum==k&&end-start+1<minLen){
                minLen = end-start+1; 
                answer[0] = start; 
                answer[1] = end;
                sum -= sequence[start++]; 
            }
        }
        return answer;
    }
}