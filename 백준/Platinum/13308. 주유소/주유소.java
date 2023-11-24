import java.io.*;
import java.util.PriorityQueue;
import java.util.*;

public class Main {


    static PriorityQueue<Node> pq;
    static int n, m;
    static List<Node> [] list;
    static int [] cost;
    static int [] payOil;
    static final long INF = 98765432198798l;
    static long [][] dp;
    static int minVertex, minPayOil, costToMinVertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        pq = new PriorityQueue<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        payOil = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) payOil[i + 1] = Integer.parseInt(st.nextToken());


        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, 0, c, 2500));
            list[b].add(new Node(a, 0, c, 2500));
        }
        dp = new long[2501][n + 1];
        for (int i = 0; i <= 2500; i++) Arrays.fill(dp[i], INF);
        dp[0][1] = 0;
        pq.add(new Node(1, 0, 0, payOil[1]));
        sb.append(dijk());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static long dijk(){

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dp[cur.payPerl][cur.vertex] < cur.cost) {
                continue;
            }
            for (int i = 0; i < list[cur.vertex].size(); i++) {
                Node next = list[cur.vertex].get(i);
                int nextCost = cur.cost + cur.payPerl * next.dist;

                if (dp[cur.payPerl][next.vertex] > nextCost) {
                    dp[cur.payPerl][next.vertex] = nextCost;
                    pq.add(new Node(next.vertex, nextCost, 0, Math.min(cur.payPerl, payOil[next.vertex])));
                }
            }
        }
        long cost = INF;
        for(int i=0; i<=2500; i++){
            cost = Math.min(dp[i][n], cost);
        }

        return cost;
    }
    static class Node implements Comparable<Node> {

        int vertex;
        int cost;
        int dist;
        int payPerl;

        public Node(int vertex, int cost, int dist, int payPerl) {
            this.vertex = vertex;
            this.cost = cost;
            this.dist = dist;
            this.payPerl = payPerl;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - payPerl;
        }
    }
}