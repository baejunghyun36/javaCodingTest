import java.util.*; 
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        answer = new int[s.length()]; 
        
        Map <Character, Integer> map = new HashMap<>(); 
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i); 
            int x = map.getOrDefault(c, 0); 
            if(x==0) answer[i] = -1;             
            else answer[i] = 1+i-x; 
            map.put(c, i+1); 
        }      
        
        
        return answer;
    }
}