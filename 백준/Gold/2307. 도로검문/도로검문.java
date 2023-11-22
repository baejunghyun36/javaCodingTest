import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<Node> [] list;
    static final int INF = 987654321;
    static int optimalTime;
    static int latencyTime;
    static int [] reverseIndex;
    static int [][] dp;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        dp = new int[2][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        optimalTime = dijk(-1, -1);

        int cur = n;

        while (cur != 1) {
            int next = reverseIndex[cur];
            latencyTime = Math.max(latencyTime, dijk(cur, next));
            cur = next;
        }

        if(latencyTime==INF) sb.append(-1);
        else sb.append(latencyTime - optimalTime);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static int dijk(int from, int to){

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(1, 0));
        dist[1] = 0;
        reverseIndex = new int[n + 1];
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(dist[cur.vertex] < cur.cost) continue;
            for (int i = 0; i < list[cur.vertex].size(); i++) {
                Node next = list[cur.vertex].get(i);
                if((to==cur.vertex&&from==next.vertex)||(to==next.vertex&&from==cur.vertex))continue;
                if (dist[next.vertex] > dist[cur.vertex] + next.cost) {
                    dist[next.vertex] = dist[cur.vertex] + next.cost;
                    reverseIndex[next.vertex] = cur.vertex;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
        return dist[n];
    }

    static class Node {

        int vertex;
        int cost;


        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}