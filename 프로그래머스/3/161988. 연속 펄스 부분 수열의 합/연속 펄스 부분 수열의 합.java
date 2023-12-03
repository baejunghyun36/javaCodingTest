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
        if(minIdx <= maxIdx){
            answer = Math.max(answer, Math.max(accum[maxIdx] - accum[minIdx], accum[maxIdx]));    
        }
        else answer = Math.max(answer, accum[maxIdx]); 
    
        // -2 3 6 1 -3 -1 -2 4
        // -2 1 7 8  5  4  2 6
        
        //0 1 2 1 -1 2 2 2  2  2
        //0 1 3 4  3 5 7 9 11 12

    }
}