import java.util.*; 

class Solution {
    static String [] type = {"RT", "CF", "JM", "AN"}; 
    static Map<Character, Integer> score; 
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        score = new HashMap<>(); 
        for(int i=0; i<survey.length; i++){
            String s = survey[i];
            int c = choices[i]; 
            if(c<4) score.put(s.charAt(0), score.getOrDefault(s.charAt(0),0)+4-c); 
            else if(c>4) score.put(s.charAt(1),score.getOrDefault(s.charAt(1),0)+c-4);
        }
        for(int i=0; i<type.length; i++){
            int a = score.getOrDefault(type[i].charAt(0), 0); 
            int b = score.getOrDefault(type[i].charAt(1), 0); 
            answer += a >= b ? type[i].charAt(0) : type[i].charAt(1); 
        }
        return answer;
    }
}