class Solution {
    static int n; 
    static long answer = 0; 
    public long solution(int[] sequence) {
        n = sequence.length; 
        for(int i=0; i<n; i+=2) sequence[i] *=-1;         
        greedy(sequence); 
        for (int i=0; i<n; i++) sequence[i] *=-1; 
        greedy(sequence); 
        return answer;
    }
    
    static void greedy(int [] seq){
        long sum = 0; 
        long [] accum = new long[n+1]; 
        long max = -50000000000l;
        long min =  50000000000l; 
        int maxIdx = 0; 
        int minIdx = 0; 
        for(int i=1; i<=n; i++){
            accum[i] = accum[i-1] + seq[i-1]; 
            if(accum[i]>max){
                max = accum[i]; 
                maxIdx = i; 
            }
            if(accum[i]<min){
                min = accum[i]; 
                minIdx = i; 
            }
        }
        answer = Math.max(answer, Math.max(accum[maxIdx] - accum[minIdx], accum[maxIdx]));    

    }
}