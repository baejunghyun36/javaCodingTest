import java.util.*; 
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length; 
        int [] accum = new int[n+1]; 
        for(int i=1; i<=n; i++){
            accum[i] = accum[i-1] + elements[i-1]; 
        }
        System.out.println(Arrays.toString(accum)); 
        Set<Integer> set = new HashSet<>(); 
        for(int size=1; size<=n; size++){
            int start = 1;
            int end = start+size-1; 
            while(start<=n){
                if(end<start){
                    set.add(accum[end]+accum[n]-accum[start-1]); 
                }
                else{
                    set.add(accum[end]-accum[start-1]); 
                }
                start++; 
                end++; 
                if(end==n+1)end = 1; 
            }
    
            
        }
        answer = set.size(); 
        return answer;
    }
}