import java.io.*;
import java.util.*;

public class Main {

    //두번째 방식  - dfs
    static int n, m;
    static List<Node> [] list;
    static PriorityQueue<Node> pq;
    static int [] dist;
    static int [] visited;
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

            dist = new int[n + 1];
            Arrays.fill(dist, inf);
            dist[a] = 0;
            dfs(a, b, 0);
            sb.append(dist[b]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
    static void dfs(int a, int b, int cost){

        if(b==a){
            return;
        }

        for (int i = 0; i < list[a].size(); i++) {
            Node next = list[a].get(i);
            if (dist[next.next] > next.cost + cost) {
                dist[next.next] = next.cost + cost;
                dfs(next.next, b, dist[next.next]);
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