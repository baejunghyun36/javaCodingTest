import java.util.*;
class Solution {

    static int [] cores; 
    static int N; 
    static int answer; 
    static int minNum = 987654321; 
    public int solution(int n, int[] core) {

        N = n; 
        if(n <= core.length) return n; 
        cores = core; 
        for(int i=0; i<core.length; i++){
            minNum = Math.min(minNum, core[i]); 
        }
        binearySearch(); 
        return answer;
    }
    
    static void binearySearch(){
        
        int l = 0; 
        int h = N * minNum; 
        int total = 0; 
        int second = 0; 
        while(l<=h){
            int mid = (l+h)/2; 
            int sum = cores.length; 
            for(int i=0; i<cores.length; i++){
                sum += mid / cores[i];
            }
            if(sum>=N){
                h = mid -1; 
            }
            else {
                total = sum; 
                second = mid+1; 
                l = mid +1;
            }
        }
    
        for(int i=0; i<cores.length; i++){
            if(second%cores[i]==0)total++; 
            if(total==N){
                answer = i+1; 
                break ;
            } 
        }
        
    }

}