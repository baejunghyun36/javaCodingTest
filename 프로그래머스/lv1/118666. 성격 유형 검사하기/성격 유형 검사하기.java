import java.util.*;
class Solution {
    static Map<Character, Integer> map; 
    static char[][] emo = {{'R','T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}}; 
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        map = new HashMap<>(); 
        for(int i=0; i<survey.length; i++){
            int num = choices[i]; 
            if(num==4)continue; 
            if(num>=1&&num<=3){
                map.put(survey[i].charAt(0), map.getOrDefault(survey[i].charAt(0), 0)+(4-num)); 
            }
            else{
                map.put(survey[i].charAt(1), map.getOrDefault(survey[i].charAt(1), 0)+(num-4)); 
            }         
        }
        for(int i = 0; i<4; i++){
            int a = map.getOrDefault(emo[i][0], 0); 
            int b = map.getOrDefault(emo[i][1], 0); 
            if(a>=b)answer+=emo[i][0]; 
            else answer+=emo[i][1]; 
        }
        
        return answer;
    }
}