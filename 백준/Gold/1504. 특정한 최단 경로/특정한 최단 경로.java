import java.io.*;
import java.util.*;

public class Main {

    static int [] dist;
    static int n, m;
    static int v1, v2;
    static ArrayList<Node> [] info;
    static PriorityQueue<Node> pq;
    static final int INF = 987654321;
    static int dist1, dist2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        info = new ArrayList[n + 1];
        for(int i=1; i<=n; i++)info[i] = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            info[a].add(new Node(b, d));
            info[b].add(new Node(a, d));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        initMethod(1, 1, v1);
        initMethod(n, 1, v2);
        initMethod(1, 2, v2);
        initMethod(n, 2, v1);
        initMethod(v1, 3, v2);

        sb.append(Math.min(dist1, dist2));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void initMethod (int start, int version, int endPoint){

        init();
        dist[start] = 0;
        pq.add(new Node(start, 0));
        dijk();

        if(version==1&&dist[endPoint]!=INF) dist1 += dist[endPoint];
        else if(version==2&&dist[endPoint]!=INF) dist2 += dist[endPoint];
        else if(version==3&&dist[v2]!=INF){
            dist1 += dist[v2];
            dist2 += dist[v2];
        }
        else {
            System.out.println(-1);
            System.exit(0);
        }
    }



    static void dijk(){

        int[] visited = new int[n + 1];
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.vertex]==1)continue;
            visited[cur.vertex] = 1;
            for (int i = 0; i < info[cur.vertex].size(); i++) {
                Node next = info[cur.vertex].get(i);
                if(dist[next.vertex]>dist[cur.vertex] + next.dist){
                    dist[next.vertex] = dist[cur.vertex] + next.dist;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
    }

    static class Node {

        int vertex;
        int dist;

        public Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
    }

    static void init(){

        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        pq = new PriorityQueue<>((o1, o2) -> (o1.dist - o2.dist));
    }
}