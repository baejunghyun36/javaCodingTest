import java.util.*; 
class Solution {
    
    public int[] solution(String[] words, String[] queries) {
        Trie tree = new Trie(); 
        Trie reverseTree = new Trie(); 
        
        //정방향
        for(int i=0; i<words.length; i++){
            char [] temp = words[i].toCharArray(); 
            insert(tree, temp); 
        }
        //역방향
        for(int i=0; i<words.length; i++){
            char [] temp = reverseString(words[i]); 
            insert(reverseTree, temp); 
        }
        
        ArrayList<Integer> ans = new ArrayList<>(); 
        for(String s : queries){
            char [] temp = s.toCharArray(); 
            int cnt =0; 
            if(s.charAt(0)=='?'){
                cnt = containsCheck(reverseTree, reverseString(s)); 
            }
            else{
                cnt = containsCheck(tree, temp); 
            }
            ans.add(cnt); 
        }
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i); 
        }
        return answer;
    }
    static int containsCheck (Trie cur, char[] str){
        
        for(int i=0; i<str.length; i++){
            char c = str[i]; 
            
            if(c=='?'){
                return cur.lengthCount.getOrDefault(str.length, 0); 
            }
            cur = cur.child.get(c); 
            if(cur==null)return 0; 
        }
        return 0; 
    }
    
    
    static char [] reverseString(String s){
        char [] temp = new char[s.length()]; 
        int index = 0; 
        for(int i=s.length()-1; i>=0; i--){
            temp[s.length()-1-i] = s.charAt(i); 
        }
        return temp; 
    }
        
        
    
    static class Trie {
        
        Map<Character, Trie> child = new HashMap<>(); 
        Map<Integer, Integer> lengthCount = new HashMap<>(); 
        
    }
    
    static void insert(Trie cur, char[] str){
        
        for(int i=0; i<str.length; i++){
            char c = str[i]; 
            cur.child.putIfAbsent(c, new Trie());
            cur.lengthCount.put(str.length, cur.lengthCount.getOrDefault(str.length, 0)+1); 
            cur = cur.child.get(c); 
        }
    }
    
    
}