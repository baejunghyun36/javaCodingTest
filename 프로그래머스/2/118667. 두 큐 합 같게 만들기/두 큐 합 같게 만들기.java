import java.util.*; 
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int cnt = 0; 
        long sum1 = 0; 
        long sum2 = 0; 
        Queue<Integer> q1 = new LinkedList<>(); 
        Queue<Integer> q2 = new LinkedList<>(); 
        for(int i=0; i<queue1.length; i++){
            sum1+=queue1[i]; 
            sum2+=queue2[i]; 
            q1.add(queue1[i]); 
            q2.add(queue2[i]); 
        }

        int size = queue1.length; 
        
        while(cnt<=size*4+1){
            if(sum1==sum2) {
                answer = cnt; 
                break; 
            }
            else if(sum1>sum2){
                int x = q1.poll(); 
                sum1-=x; 
                sum2+=x; 
                q2.add(x); 
            }
            else if(sum2>sum1){
                int x = q2.poll(); 
                sum1+=x; 
                sum2-=x; 
                q1.add(x); 
            }
            cnt++; 
        }
        return answer;
    }
}