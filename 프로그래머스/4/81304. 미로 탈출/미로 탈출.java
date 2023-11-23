import java.util.*; 
class Solution {
    
    static List<Node> [] list; 
    static Map<Integer, Integer> isTrap; 
    static PriorityQueue<Node> pq;
    static int [][] dist; 
    static final int INF = 1000000000; 
    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;
        list = new ArrayList[n+1]; 
        pq = new PriorityQueue<>(); 
        for(int i=1;i<=n; i++) list[i] = new ArrayList<>(); 
        for(int i=0; i<roads.length; i++){
            int from = roads[i][0]; 
            int to = roads[i][1]; 
            int cost = roads[i][2]; 
            list[from].add(new Node(to, cost, 0)); 
            list[to].add(new Node(from, cost, 1)); 
        }
        isTrap = new HashMap<>(); 
        for(int i=0; i<traps.length; i++) isTrap.put(traps[i], i);  
        pq.add(new Node(start, 0, 0)); 
        answer = dijk(n, start, end); 
        // answer = INF; 
        // for(int i=0; i< (1<<10); i++){
        //     answer = Math.min(answer, dist[n][i]); 
        // }
        return answer;
    }
    
    public int dijk(int n, int start, int end){
        dist = new int[n+1][1<<10]; 
        for(int i=1; i<=n; i++){
            Arrays.fill(dist[i], INF); 
        }
        dist[start][0] = 0; 
        int answer = INF; 
        while(!pq.isEmpty()){
            Node cur = pq.poll(); 
      
            if(cur.vertex==end){
                answer = Math.min(answer, cur.cost); 
                continue; 
            }
            if(dist[cur.vertex][cur.status] < cur.cost) continue; 
           
            for(int i=0; i<list[cur.vertex].size(); i++){
                Node next = list[cur.vertex].get(i); 
                int isReverse = next.status;  
                if(isReverse != (isConnected(cur.vertex, next.vertex, cur.status)? 1:0)){
                    continue; 
                }
                           
                int nextStatus = getNextState(cur.status, next.vertex); 
                
//                 int nextCost = next.cost + cur.cost; 
//                 if(nextCost >= dist[next.vertex][nextStatus])continue; 
//                 dist[next.vertex][nextStatus] = nextCost; 
//                 pq.add(new Node(next.vertex, nextCost, nextStatus)); 
                
//                 if(dist[next.vertex][nextStatus] > cur.cost + next.cost){
//                     dist[next.vertex][nextStatus] = cur.cost + next.cost; 
//                     pq.add(new Node(next.vertex, dist[next.vertex][nextStatus], nextStatus)); 
                       
//                 }     
                if(dist[next.vertex][nextStatus] > dist[cur.vertex][cur.status] + next.cost){
                    dist[next.vertex][nextStatus] = dist[cur.vertex][cur.status] + next.cost; 
                    pq.add(new Node(next.vertex, dist[next.vertex][nextStatus], nextStatus));              
                }
        
            }
        }
        return answer; 
    }
    
    public int getNextState(int curStatus, int nextVertex){
        if(isTrap.containsKey(nextVertex)){
            curStatus ^= (1<<isTrap.get(nextVertex));
        }
        return curStatus; 
    }
    
    public boolean isConnected(int curVertex, int nextVertex, int curStatus){
        boolean curVertexTrapChk = false; 
        boolean nxtVertexTrapChk = false; 
        if(isTrap.containsKey(curVertex)) curVertexTrapChk = ((curStatus & (1 << isTrap.get(curVertex)))!=0); 
        if(isTrap.containsKey(nextVertex)) nxtVertexTrapChk = ((curStatus & (1 << isTrap.get(nextVertex)))!=0); 
        return curVertexTrapChk ^ nxtVertexTrapChk; 
        
    }
    
    class Node implements Comparable<Node>{
        
        int vertex; 
        int cost; 
        int status; 
        public Node (int vertex, int cost, int status){
            this.vertex = vertex; 
            this.cost = cost; 
            this.status = status; 
        }
        public int compareTo(Node node){
            return this.cost - node.cost; 
        }
    }
    
    
}
