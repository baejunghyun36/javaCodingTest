import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static List<Node> [] list;
    static PriorityQueue<Node> pq;
    static int [] dist;
    static final int inf = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dijk(a, b);
            sb.append(dist[b]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
    static void dijk(int start, int endPoint){
        dist = new int[n + 1];
        Arrays.fill(dist, inf);
        pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.next;
            if(cur==endPoint)return; 
            for (int i = 0; i < list[cur].size(); i++) {
                Node next= list[cur].get(i);
                if(dist[next.next]!=inf)continue;
                if (dist[next.next] > dist[cur] + next.cost) {
                   dist[next.next] = dist[cur] + next.cost;
                   pq.add(next);
                }
            }
        }
    }

    static class Node {

        int next;
        int cost;

        public Node(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
}