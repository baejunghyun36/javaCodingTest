import java.util.*; 
class Solution {
    static PriorityQueue<Node> pq; 
    static int [] visited; 
    static List <Node> list[]; 
    static Map<Integer, Integer> summitMap; 
    static int [] dist; 
    static final int INF = 987654321; 
    static int [] answer ;
    static int [] summit; 
    static int [] gateOfSummit; 
    static Set <Integer> summitCheck; 
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        answer = new int[2];
        visited =new int[n+1]; 
        list = new ArrayList[n+1]; 
        pq = new PriorityQueue<>(); 
        summit = new int [n+1]; 
        summitCheck = new HashSet<>(); 
        summitMap = new HashMap<>(); 
        gateOfSummit = new int[n+1]; 
        dist = new int[n+1]; 
        Arrays.fill(dist, INF);
        Arrays.fill(summit, INF); 
        for(int i=0; i<=n; i++)list[i] = new ArrayList<>(); 
        for(int i=0; i<paths.length; i++){
            int a = paths[i][0]; 
            int b = paths[i][1]; 
            int c = paths[i][2]; 
            list[a].add(new Node(b, c)); 
            list[b].add(new Node(a, c)); 
        }
        for(int i=0; i<summits.length; i++) summitMap.put(summits[i], 1);  
        for(int i=0; i<gates.length; i++) {
            pq.add(new Node(gates[i], 0)); 
        }
        dijk(); 
        Arrays.sort(summits); 
        int minNumber = INF; 
        for(int i=0; i<summits.length; i++){
             int x = summits[i]; 
             // System.out.println(x); 
             if(minNumber > dist[x]){
                answer[0] = x; 
                answer[1] = dist[x];
                minNumber = dist[x]; 
            }
        }
        return answer;
    }
    
    static void dijk(){
      
        while(!pq.isEmpty()){
            Node cur = pq.poll(); 
            if(summitMap.getOrDefault(cur.to, -1)!=-1){
                continue;
            } 
            if(dist[cur.to]<cur.cost)continue; 
            for(int i=0; i<list[cur.to].size(); i++){
                Node temp = list[cur.to].get(i);                
                Node next = new Node(temp.to, temp.cost); 
                if(dist[next.to]>Math.max(next.cost, cur.cost)){
                    dist[next.to] = Math.max(next.cost, cur.cost);
                    next.cost = dist[next.to];  
                    pq.add(next);
                }
            }
        }
    }
    
    static class Node implements Comparable<Node> {
        
        int to; 
        int cost; 
        
        public Node(int to, int cost){
            this.to = to; 
            this.cost = cost; 
        }
        
        public int compareTo(Node node){
            return this.cost - node.cost; 
        }
    }
}