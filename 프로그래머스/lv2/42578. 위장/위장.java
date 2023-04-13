import java.util.*; 
class Solution {
    static Map<String, Integer> map; 
    public int solution(String[][] clothes) {
        int answer = 1;
        map = new HashMap<>(); 
        for(int i=0; i<clothes.length; i++){
            String type = clothes[i][1]; 
            map.put(type, map.getOrDefault(type, 1)+1);     
        }
       
        for(String s : map.keySet()){
            answer*=map.get(s); 
        }
        return answer-1; 
  
    }
}