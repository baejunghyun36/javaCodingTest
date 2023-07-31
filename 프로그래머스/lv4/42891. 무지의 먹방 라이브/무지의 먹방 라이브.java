import java.util.*; 

class Solution {
    static long second; 
    static PriorityQueue<Integer> q;
    public int solution(int[] food_times, long k) {
        // int answer = 0;
        
        q = new PriorityQueue<>(); 
        for(int i=0; i<food_times.length; i++) q.add(food_times[i]); 
        long answer = afterK(0, k, food_times); 
        return (int)answer;
    }
    
    static long afterK(long answer, long k, int[] foodTimes){
        
        long n = 0; 
        while(!q.isEmpty()){
            long foodCount = q.size(); 
            long s = q.peek(); 
            if(answer+(long)((s-second)*foodCount)>k){
                n = (k-answer)%foodCount+1; 
                break;
            }
            else{
                answer+=(s - second) * foodCount; 
                while(!q.isEmpty()&&s==q.peek()) q.poll(); 
                second = s;  
            }
        }
        if(q.isEmpty())return -1; 
        long cnt = 0; 
        for(int i=0; i<foodTimes.length; i++){
            if(foodTimes[i]>second) cnt++; 
            if(cnt==n)return i+1;
        }
        return foodTimes.length; 

    }
}