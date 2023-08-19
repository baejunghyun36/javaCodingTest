import java.util.*; 
class Solution {
    static Set <Integer> lock; 
    static Map <Integer, Integer> key; 
    static Set <Integer> nodeToVisit; 
    static int [] visited; 
    static ArrayList<Integer> list[]; 
    static Queue<Integer> q; 
    public boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        lock = new HashSet<>(); 
        key = new HashMap<>(); 
        nodeToVisit = new HashSet<>(); 
        visited = new int[n+1]; 
        list = new ArrayList[n+1]; 
        for(int i=0; i<=n; i++) list[i] = new ArrayList<>(); 
        for(int i=0; i<path.length; i++){
            list[path[i][0]].add(path[i][1]); 
            list[path[i][1]].add(path[i][0]); 
        }
        for(int i=0; i<order.length; i++){
            lock.add(order[i][1]); 
            key.put(order[i][0], order[i][1]); 
        }
        list[n].add(0); 
        q = new LinkedList<>(); 
        q.add(n); 
        bfs(); 
        for(int i=0; i<n; i++){
            if(visited[i]==0)return false; 
        }
        return true;
    }
    static void bfs(){
        
        ArrayList<Integer> reachableNode = new ArrayList<>(); 
        while(!q.isEmpty()){
            int size = q.size(); 
            while(size-->0){                
                int cur = q.poll(); 
                for(int i=0; i<list[cur].size(); i++){
                    int next = list[cur].get(i); 
                    if(visited[next]==1)continue; 
                    if(lock.contains(next)){
                        nodeToVisit.add(next);
                        continue; 
                    }
                    visited[next] = 1; 
                    q.add(next); 
                    int k = key.getOrDefault(next, -1); 
                    if(k!=-1) reachableNode.add(k);
                }
            }
            for(int i=0; i<reachableNode.size(); i++){
                int lockNode = reachableNode.get(i); 
                if(nodeToVisit.contains(lockNode)){
                    // reachableNode.remove(i); 
                    // nodeToVisit.remove(lockNode); 
                    // lock.remove(lockNode); 
                    i--; 
                    visited[lockNode] = 1; 
                    q.add(lockNode); 
                }
            }
        }
    }
}