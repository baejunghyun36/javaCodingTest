import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static int [] visited;
    static PriorityQueue<Node> pq;
    static long [][] dist;
    static List<Node> [] list;
    static final long INF = 10000000001l;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c, k));
            list[b].add(new Node(a, c, k));
        }
        dijk();
        sb.append(check());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static long check(){
        long minDist = INF;
        for (int i = 0; i <= k; i++) minDist = Math.min(minDist, dist[i][n]);
        return minDist;
    }



    static void dijk(){

        dist = new long[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dist[i], INF);
        }
        int[][] visited = new int[k + 1][n + 1];
        dist[k][1] = 0;
        pq.add(new Node(1, 0, k));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.cost > dist[cur.k][cur.vertex])continue;

            for (int i = 0; i < list[cur.vertex].size(); i++) {
                //k 안쓸 때
                Node next = list[cur.vertex].get(i);
                if (dist[cur.k][next.vertex] > dist[cur.k][cur.vertex] + next.cost) {
                    dist[cur.k][next.vertex] = dist[cur.k][cur.vertex] + next.cost;
                    pq.add(new Node(next.vertex, dist[cur.k][next.vertex], cur.k));
                }
                //k 쓸 때
                if (cur.k >= 1) {
                    if (dist[cur.k - 1][next.vertex] > cur.cost) {
                        dist[cur.k - 1][next.vertex] = cur.cost;
                        pq.add(new Node(next.vertex, dist[cur.k - 1][next.vertex], cur.k - 1));
                    }
                }
            }

        }
    }

    static class Node implements Comparable<Node> {

        int vertex;
        long cost;
        int k;

        public Node(int vertex, long cost, int k) {
            this.vertex = vertex;
            this.cost = cost;
            this.k = k;
        }

        public int compareTo(Node node) {
            return Long.compare(this.cost, node.cost);
        }
    }

    static void init(){
        pq = new PriorityQueue<>();
        list = new List[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        visited = new int[n + 1];
    }
}
