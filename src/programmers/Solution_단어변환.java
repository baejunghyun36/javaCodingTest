package gitRepository;

import java.util.*; 
class Solution_단어변환 {
    static Map <String, Integer> map; 
    static int [] visited; 
    static int answer; 
    public int solution(String begin, String target, String[] words) {
        
        map = new HashMap<>(); 
        answer = 987654321; 
        visited = new int [words.length+1]; 
        for(int i=0; i<words.length; i++) map.put(words[i],i+1); 
        dfs(begin, target, words, 0); 
        if(answer==987654321)answer = 0; 
        return answer;
    }
    
    static void dfs(String s, String target, String[] words, int count){
        
        
        for(int i=0; i<words.length; i++){
           
            String temp = words[i]; 
            //System.out.println(temp); 
            int cnt = 0; 
            for(int j=0; j<temp.length(); j++){
                if(s.charAt(j)!=temp.charAt(j))cnt++; 
            }
            if(cnt==1&&temp.equals(target)){
                answer = Math.min(answer, count+1);      
                return; 
            }
            if(cnt==1&&visited[map.get(temp)]==0){
                visited[map.get(temp)]++; 
                dfs(temp, target, words, count+1); 
                visited[map.get(temp)]--; 
            }
        }

    }
    
}