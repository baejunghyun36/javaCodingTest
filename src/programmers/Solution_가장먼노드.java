package gitRepository;

import java.util.*; 
class Solution_가장먼노드 {
    
    static int [] visited; 
    static int [][] map; 
    static Queue <Integer> q; 
    public int solution(int n, int[][] edge) {
        int answer = 0;
        q = new LinkedList<>(); 
        visited = new int[n+1]; 
        
        ArrayList <Integer> list [] = new ArrayList [n+1]; 
        for(int i=1; i<=n; i++)list[i] = new ArrayList<>();        
        for(int i=0; i<edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        q.add(1); 
        visited[1]=1; 
        int cnt = 0; 
        
        while(!q.isEmpty()){
            cnt = q.size(); 
            answer = cnt; 
            while(cnt-->0){
                int x = q.poll(); 
                for(int i : list[x]){
                    if(visited[i]==0){
                        visited[i]=1; 
                        q.add(i); 
                    }
                }
             
            }
        }
 
        return answer;
    }
}