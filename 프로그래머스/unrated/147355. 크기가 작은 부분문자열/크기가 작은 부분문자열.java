import java.util.*; 
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int length = p.length(); 
        long pValue = Long.parseLong(p); 
        for(int i=0; i<t.length()-length+1; i++){
            String sub = t.substring(i, i+length); 
            long subValue = Long.parseLong(sub); 
            if(pValue>=subValue)answer++; 
        }
        
        return answer;
    }
}