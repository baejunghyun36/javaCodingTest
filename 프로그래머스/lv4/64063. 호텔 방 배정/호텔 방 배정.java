import java.util.*; 
class Solution {
    static Map<Long, Long> map; 
    static long a; 
    public long[] solution(long k, long[] room_number) {
        
        long[] answer = new long[room_number.length];
        map = new HashMap<>(); 
        
        for(int i=0; i<room_number.length; i++){
            a = 0; 
            long num = room_number[i]; 
            dfs(num);
            answer[i] = a; 
        }
        return answer;
    }
    
    static long dfs(long num){
        
        if(map.getOrDefault(num, 0l)==0){
            map.put(num, num+1); 
            a = num; 
            return num+1; 
        }
        return map.put(num, dfs(map.get(num))); 
    }
}