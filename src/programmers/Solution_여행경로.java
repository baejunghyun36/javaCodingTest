package programmers;

import java.util.*; 
class Solution_여행경로 {
    static int [] visited; 
    static int N; 
    static ArrayList <Node> list; 
    static ArrayList <String> temp; 
    static ArrayList <String> ans; 
    static boolean flag; 
    public String[] solution(String[][] tickets) {
       
        ans = new ArrayList<>(); 
        temp = new ArrayList<>(); 
        visited = new int[tickets.length];         
        list = new ArrayList<>(); 
        for(int i=0; i<tickets.length; i++){
            list.add(new Node(tickets[i][0], tickets[i][1])); 
        }
        Collections.sort(list); 
        N = tickets.length; 
        dfs("ICN", 0, "ICN"); 
        
        String[] answer = new String [ans.size()];
        int index = 0; 
        for(String s : ans){
            answer[index++]=s; 
        }
        return answer;

    }
    
    
    static void dfs(String start, int cnt, String s){
 
        if(cnt==N){
            for(int i=0; i<s.length(); i+=3){
                ans.add(s.substring(i,i+3)); 
            }
            
            flag=true; 
            return; 
        }
        for(int i=0; i<N; i++){
            if(visited[i]==1)continue; 
            if(start.equals(list.get(i).from)){
                visited[i] = 1; 
                if(flag==false)dfs(list.get(i).to, cnt+1, s+list.get(i).to); 
                visited[i] = 0; 
            }
        }
    }
    
    static class Node implements Comparable <Node>{
        
        String from; 
        String to; 
        
        public Node(String from, String to){
            this.from = from; 
            this.to = to; 
        }
        
        public int compareTo(Node n){
            if(this.from.equals(n.from)){
                return this.to.compareTo(n.to); 
            }
            return this.from.compareTo(n.from); 
            
        }
    }
}