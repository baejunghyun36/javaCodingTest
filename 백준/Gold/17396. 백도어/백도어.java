import java.io.*;
import java.util.*;

public class Main {


    static int [] forbiddenArea;
    static int n, m;
    static long [] dist;
    static int []visited;
    static ArrayList<Node> [] list;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        for (int i = 0; i < n; i++) list[i] = new ArrayList<>();

        forbiddenArea = new int[n];
        dist = new long[n];
        visited = new int[n];
        Arrays.fill(dist, 10000000001l);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            forbiddenArea[i] = Integer.parseInt(st.nextToken());
        }
        forbiddenArea[n-1] = 0;
        pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        pq.add(new Node(0, 0));

        dijk();
        if(dist[n-1]==10000000001l) sb.append(-1);
        else sb.append(dist[n - 1]);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void dijk(){


        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.vertex]==1)continue;
            visited[cur.vertex] = 1;
            for (int i = 0; i < list[cur.vertex].size(); i++) {
                Node next = list[cur.vertex].get(i);
                if(forbiddenArea[next.vertex]==1)continue;
                if(dist[next.vertex]> cur.dist+next.dist){
                    dist[next.vertex]= cur.dist+next.dist;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int vertex;
        long dist;

        public Node(int vertex, long dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        public int compareTo(Node node) {
            return Long.compare(this.dist, node.dist);
        }
    }
}