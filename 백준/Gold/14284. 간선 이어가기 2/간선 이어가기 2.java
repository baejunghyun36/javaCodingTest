import java.io.*;
import java.util.*;

public class Main {

    static int n, m, s, t;
    static PriorityQueue<Edge> pq;
    static List<Edge> [] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[v1].add(new Edge(v2, c));
            graph[v2].add(new Edge(v1, c));
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        sb.append(dijk());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static int dijk(){
        int[] cost = new int[n + 1];
        Arrays.fill(cost, 2000000000);
        pq.add(new Edge(s, 0));
        cost[s] = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if(e.to==t)return e.cost;
            if(cost[e.to] < e.cost) continue;
            for(Edge next : graph[e.to]){
                if(cost[next.to] > next.cost + cost[e.to]){
                    cost[next.to] = next.cost + cost[e.to];
                    pq.add(new Edge(next.to, cost[next.to]));
                }
            }
        }
        return 0;
    }

    static class Edge implements Comparable<Edge> {

        int to;
        int cost;

        public Edge(int to, int cost) {

            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }

}