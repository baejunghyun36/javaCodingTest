import java.util.*; 
class Solution {

    static final int INF = 2000000000; 
    static int [] intensity; 
    static PriorityQueue<Node> pq; 
    static int [] visited; 
    static Set<Integer> summitSet, gateSet; 
    static ArrayList<Node>[] list; 
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int []{INF, INF};
        list = new ArrayList[n+1]; 
        for(int i=1; i<=n; i++)list[i] = new ArrayList<>(); 
        for(int i=0; i<paths.length; i++){
            int a = paths[i][0]; 
            int b = paths[i][1]; 
            int c = paths[i][2];
            list[a].add(new Node(b, c)); 
            list[b].add(new Node(a, c)); 
        }
        gateSet = new HashSet<>(); 
        for(int i=0; i<gates.length; i++) gateSet.add(gates[i]); 
        Arrays.sort(summits); 
        intensity = new int[n+1]; 
        visited = new int[n+1]; 
        summitSet = new HashSet<>(); 
        for(int i=0; i<summits.length; i++) summitSet.add(summits[i]); 
        for(int i=0; i<summits.length; i++){
            pq = new PriorityQueue<>((o1, o2)-> o1.cost - o2.cost); 
            Arrays.fill(intensity, INF); 
            Arrays.fill(visited, 0); 
            intensity[summits[i]] = 0; 
            pq.add(new Node(summits[i], 0)); 
            dijk(); 
            // for(int j=1; j<=n; j++){
            //     System.out.print(intensity[j]+" "); 
            // }
            // System.out.println(); 
            for(int j=0; j<gates.length; j++){
                if(intensity[gates[j]]<answer[1]){
                    answer[0] = summits[i]; 
                    answer[1] = intensity[gates[j]]; 
                }
            }
        }
        
        return answer;
    }
    static void dijk(){
        while(!pq.isEmpty()){
            Node cur = pq.poll(); 
            if(gateSet.contains(cur.vertex))break; 
            if(visited[cur.vertex]==1)continue; 
            visited[cur.vertex] = 1; 
            for(int i=0; i<list[cur.vertex].size(); i++){
                Node next = list[cur.vertex].get(i); 
                if(summitSet.contains(next.vertex))continue; 
                if(intensity[next.vertex]>Math.max(cur.cost, next.cost)){
                    intensity[next.vertex] = Math.max(cur.cost, next.cost); 
                    pq.add(new Node(next.vertex, intensity[next.vertex])); 
                }
            }
        }
    }
    
    static class Node {
        int vertex; 
        int cost; 
        public Node(int vertex, int cost){
            this.vertex = vertex; 
            this.cost = cost; 
        }
    }
    
}