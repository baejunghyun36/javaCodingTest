import java.io.*;
import java.util.*;

public class Main {

    static int k, n, m;
    static List<Edge> [] adj;
    static int [][] dp;
    static final int INF = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adj[s].add(new Edge(d, l, t));
        }

        sb.append(dijk());


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int dijk(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) Arrays.fill(dp[i], INF);
        pq.add(new Edge(1, 0, 0));
        dp[0][1] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(cur.vertex==n) return cur.dist;
            if(dp[cur.cost][cur.vertex] < cur.dist) continue;
            for (Edge next : adj[cur.vertex]) {
                if(next.cost + cur.cost > k) continue;
                if (dp[next.cost + cur.cost][next.vertex] > dp[cur.cost][cur.vertex] + next.dist) {
                    dp[next.cost + cur.cost][next.vertex] = dp[cur.cost][cur.vertex] + next.dist;
                    pq.add(new Edge(next.vertex, dp[next.cost + cur.cost][next.vertex], next.cost + cur.cost));
                }
            }
        }
        return -1;
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int dist;
        int cost;

        public Edge(int vertex, int dist, int cost) {
            this.vertex = vertex;
            this.dist = dist;
            this.cost = cost;
        }

        public int compareTo(Edge e){
            return this.dist - e.dist;
        }
    }
}