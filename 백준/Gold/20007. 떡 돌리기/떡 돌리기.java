import java.io.*;
import java.util.*;

public class Main {

    static int n, m, x, y, answer;
    static int [] dist;
    static int []visited;
    static ArrayList<Node> [] list;
    static PriorityQueue<Node> pq;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];

        for (int i = 0; i < n; i++) list[i] = new ArrayList<>();
        dist = new int[n];
        visited = new int[n];
        Arrays.fill(dist, INF);
        pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        dist[y] = 0;
        pq.add(new Node(y, 0));
        dijk();
        for (int i = 0; i < n; i++) dist[i]*=2;
        Arrays.sort(dist);
        answer = 1;
        if(dist[n-1]>x) sb.append(-1);
        else{
            int d = 0;
            for (int i = 1; i < n; i++) {
                if(d+dist[i]<=x){
                    d+=dist[i];
                    continue;
                }
                answer++;
                d = dist[i];
            }
            sb.append(answer);
        }
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
                if(dist[next.vertex]> cur.dist+next.dist){
                    dist[next.vertex]= cur.dist+next.dist;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{

        int vertex;
        int dist;

        public Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        public int compareTo(Node node) {
            return Long.compare(this.dist, node.dist);
        }
    }
}