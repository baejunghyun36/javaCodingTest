import java.util.*; 
class Solution {
    
    static int [] visited; 
    static int [] degree; 
    static List<Integer> [] list; 
    static List<Integer> [] listAftVisit; 
    static Queue<Integer> q; 
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        list = new ArrayList [n+1];
        listAftVisit = new ArrayList [n+1];
        q = new LinkedList<>(); 
        visited = new int[n+1]; 
        degree = new int[n+1];  
        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>(); 
            listAftVisit[i] = new ArrayList<>(); 
        }
        for(int i=0; i<path.length; i++){
            list[path[i][0]].add(path[i][1]); 
            list[path[i][1]].add(path[i][0]); 
        }
        
        for(int i=0; i<order.length; i++){
            int a = order[i][0]; 
            int b = order[i][1]; 
            if(b==0) return false; 
            if(a==0) degree[b] --; 
            listAftVisit[a].add(b); 
            degree[b] ++; 
        }
        
        q.add(0); 
        visited[0] = 1; 
        bfs(); 
        for(int i=0; i<n; i++){
            if(visited[i]!=1){
                return false; 
            }
        }
        return true; 
    }
    static void bfs(){
        
        while(!q.isEmpty()){
            int cur = q.poll(); 
            for(int i=0; i<list[cur].size(); i++){
                int next = list[cur].get(i); 
                if(visited[next]==1)continue; 
                if(degree[next]>0) visited[next] = 2; 
                if(visited[next]==0&&degree[next]==0){
                    visited[next] = 1; 
                    q.add(next); 
                    for(int j=0; j<listAftVisit[next].size(); j++){
                        int number = listAftVisit[next].get(j); 
                        degree[number]--;
                        if(degree[number]==0&&visited[number]==2){
                            q.add(number); 
                            visited[number] = 1; 
                        }
                    }
                }
            }
        }  
    }
    
    
    
}