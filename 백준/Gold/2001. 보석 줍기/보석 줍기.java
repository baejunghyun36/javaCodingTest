import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static int [][] visited;
    static Map <Integer, Integer> offsetOfVertex;
    static List <Edge> [] graph;
    static int [] reverseMaxJwl;
    static boolean [][] isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        offsetOfVertex = new HashMap<>();
        reverseMaxJwl = new int[n + 1];
        visited = new int[1 << k][n + 1];
        isPossible = new boolean[k + 5][n + 1];
        boolean isA = false;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==1)isA = true;
            else offsetOfVertex.put(x, idx++);
        }
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, c));
            graph[b].add(new Edge(a, c));
        }

        dfs(1, 0, 0);
        dijk();

        int answer = 0;
//        System.out.println(Arrays.toString(reverseMaxJwl));
        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= 0; j--) {
                if(isPossible[j][i]==false) continue;
//                System.out.println(i+" " + j );
                answer = Math.max(answer, Math.min(reverseMaxJwl[i], j));
            }
        }
        if(isA) answer++;

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int curVtx, int chk, int get){

        if(visited[chk][curVtx]==1)return;
        visited[chk][curVtx] = 1;
        isPossible[Integer.bitCount(chk)][curVtx] = true;

        for (Edge next : graph[curVtx]) {
            if (offsetOfVertex.get(next.vertex) != null) {
                if(get+1 <= next.threshold) dfs(next.vertex, (chk | (1 << offsetOfVertex.get(next.vertex))), get + 1);
            }
            if(get > next.threshold) continue;

            dfs(next.vertex, chk, get);
        }
    }

    static void dijk(){

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 99999));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curVtx = cur.vertex;
            int threshold = cur.threshold;
            if(reverseMaxJwl[curVtx] > threshold) continue;
            for (Edge next : graph[curVtx]) {
                if(reverseMaxJwl[next.vertex] < Math.min(threshold, next.threshold)){
                    reverseMaxJwl[next.vertex] = Math.min(threshold, next.threshold);
                    pq.add(new Edge(next.vertex, reverseMaxJwl[next.vertex]));
                }
            }
        }
    }


    static class Edge implements Comparable<Edge> {

        int vertex;
        int threshold;

        public Edge(int vertex, int threshold) {
            this.vertex = vertex;
            this.threshold = threshold;
        }

        public int compareTo(Edge edge) {
            return edge.threshold - this.threshold;
        }
    }
}