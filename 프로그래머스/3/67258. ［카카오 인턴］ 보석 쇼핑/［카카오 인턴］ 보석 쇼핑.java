import java.util.*; 
class Solution {
    static Set <String> set; 
    static Map <String, Integer> map; 
    public int[] solution(String[] gems) {
        int[] answer = {};
        set = new HashSet<>(); 
        for(String s : gems) set.add(s); 
        int n = set.size(); 

        answer = new int[2]; 
        int size = 100001; 
        map = new HashMap<>(); 
        int start = 0; 
        
        for(int end=0; end<gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1); 
            if(map.size()==n){
                while(map.size()==n){
                    if(size > end - start){
                        answer[0] = start+1; 
                        answer[1] = end + 1; 
                        size = end - start; 
                    }
                    map.put(gems[start], map.get(gems[start]) -1);
                    if(map.get(gems[start])==0) map.remove(gems[start]); 

                    start++; 
                }
            }
        }
       
        return answer;
    }
}