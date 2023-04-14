import java.util.*; 
class Solution {
    static Map<String, Integer> map; 
    static Map<String, Integer> sample; 
    static int total; 
    static int length = 987654321; 
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        map = new HashMap<>(); 
        sample = new HashMap<>();       
        for(int i=0; i<gems.length; i++){
            sample.put(gems[i], 1); 
        }

        total = sample.size(); 

        int start = 0; 
        int end = 0; 
        for(int i=0; i<gems.length; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0)+1); 
            end = i; 
            if(map.size()==total)break; 
        }
        length = end-start; 
        answer[0] = start+1; 
        answer[1] = end+1; 

        while(end<gems.length){
            while(map.get(gems[start])>=2){
                map.put(gems[start], map.get(gems[start])-1); 
                start++; 
            }
       
            if(length>end-start){
                length = end-start; 
                answer[0] = start+1; 
                answer[1] = end+1; 
            }
            end++; 
            if(end==gems.length)break; 
            map.put(gems[end], map.getOrDefault(gems[end], 0)+ 1);
        }
        return answer;
    }
}