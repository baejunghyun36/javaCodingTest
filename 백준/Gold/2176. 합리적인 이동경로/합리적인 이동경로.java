import java.io.*;
import java.util.PriorityQueue;
import java.util.*;

public class Main {

    static int n, m;
    static int [] dp;
    static int [] dist;
    static PriorityQueue<Edge> pq;
    static List <Edge> [] list;
    static final int INF = 10000001;
    static int s = 1, t = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }
        pq = new PriorityQueue<>();
        pq.add(new Edge(t, 0));
        dist = new int[n + 1];
        dp = new int[n + 1];
        dijk();
        Arrays.fill(dp, -1);
        int answer = dfs(s);
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int cur){

        if(cur==t) return 1;
        if(dp[cur]!=-1) return dp[cur];
        dp[cur] = 0;
        for (int i = 0; i < list[cur].size(); i++) {
            Edge next = list[cur].get(i);
            if(dist[cur]>dist[next.to]){
                dp[cur] += dfs(next.to);
            }
        }
        
        return dp[cur];
    }


    static void dijk(){
        Arrays.fill(dist, INF);
        dist[t] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if(dist[cur.to] < cur.dist) continue;
            for (int i = 0; i < list[cur.to].size(); i++) {
                Edge next = list[cur.to].get(i);
                if (dist[next.to] > dist[cur.to] + next.dist) {
                    dist[next.to] = dist[cur.to] + next.dist;
                    pq.add(new Edge(next.to, dist[next.to]));
                }
            }
        }
    }

    static class Edge implements Comparable <Edge> {

        int to;
        int dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        public int compareTo(Edge edge) {
            return this.dist - edge.dist;
        }
    }

}