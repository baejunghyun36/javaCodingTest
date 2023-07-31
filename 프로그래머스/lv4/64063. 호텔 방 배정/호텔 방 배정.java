import java.util.*; 
class Solution {
    static Map<Long, Long> map; 
    static long a; 
    public long[] solution(long k, long[] room_number) {
        
        long[] answer = new long[room_number.length];
        map = new HashMap<>(); 
        
        for(int i=0; i<room_number.length; i++){
            long num = room_number[i]; 
            answer[i] = dfs(num)-1; 
        }
        return answer;
    }
    
    static long dfs(long num){
        
        if(map.getOrDefault(num, 0l)==0){
            map.put(num, num+1); 
      
            return num+1; 
        }
        
        long x = dfs(map.get(num));
        // long x = map.put(num,dfs(map.get(num))); 
        map.put(num,x); 
 
        return x; 

    }
}