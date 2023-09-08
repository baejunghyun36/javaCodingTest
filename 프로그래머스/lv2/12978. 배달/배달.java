import java.util.*; 

class Solution {
    static ArrayList<Node> [] list; 
    static int [] dist; 
    static final int INF = 987654321; 
    static PriorityQueue<Node> pq; 
    static int [] visited; 
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        list = new ArrayList[N+1]; 
        pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist); 
        
        for(int i=1; i<=N; i++)list[i] = new ArrayList<>(); 
        for(int i=0; i<road.length; i++){
            int a = road[i][0]; 
            int b = road[i][1]; 
            int d = road[i][2]; 
            list[a].add(new Node(b, d)); 
            list[b].add(new Node(a, d)); 
        }
        visited = new int[N+1]; 
        dist = new int [N+1]; 
        pq.add(new Node(1, 0)); 
        Arrays.fill(dist, INF); 
        dist[1] = 0; 
        dijk(); 
        for(int i=1; i<=N; i++){
            if(dist[i]<=K)answer++; 
        }


        return answer;
    }
    static void dijk(){
        
        while(!pq.isEmpty()){
            
            Node node = pq.poll(); 
         
            if(visited[node.vertex]==1)continue; 
            visited[node.vertex] = 1; 
                 
            for(int i=0; i<list[node.vertex].size(); i++){
    
                Node next = list[node.vertex].get(i); 
                if(dist[next.vertex]> dist[node.vertex] + next.dist){
                    dist[next.vertex] = dist[node.vertex] + next.dist;
                    pq.add(new Node(next.vertex, dist[next.vertex])); 
                }
            }
        }
    }
    
    static class Node {
        
        int vertex; 
        int dist; 
        
        public Node (int vertex, int dist){
            this.vertex = vertex; 
            this.dist = dist; 
        }
        
        
    }
}