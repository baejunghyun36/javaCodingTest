import java.util.*; 

class Solution {
    static int ans; 
    static class TrieNode {
        
        Map<Character, TrieNode> childNode = new HashMap<>(); 
        boolean isTerminal = false; 
        int cnt = 0; 
    }
    
    static void insert(String s, TrieNode cur){

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i); 
            cur.childNode.putIfAbsent(c, new TrieNode()); 
            cur = cur.childNode.get(c);       
            cur.cnt++; 
            if(i==s.length()-1){
                cur.isTerminal = true; 
            }
        }

    }
    static void cont(TrieNode cur, String word, int index){
        

        if(cur.cnt==1){
            ans+=index; 
            return; 
        }
        if(word.length()==index){
            ans+=index; 
            return; 
        }
        
        char c = word.charAt(index); 
        
        cur = cur.childNode.get(c); 
        cont(cur, word, index+1); 
    }
    
    public int solution(String[] words) {
        int answer = 0;
        
        TrieNode trieNode = new TrieNode();
        for(int i=0; i<words.length; i++){
            String s = words[i]; 
            insert(s, trieNode); 
        }
        Arrays.sort(words); 
        // for(String s : words)System.out.println(s); 
        for(int i=0; i<words.length; i++){
            cont(trieNode, words[i], 0); 
        }
        answer = ans; 
                                
        
        
        return answer;
    }
}