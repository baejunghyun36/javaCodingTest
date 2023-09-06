import java.io.*;
import java.util.*;

public class Main {

    static int testCase;
    static int n, m, w;
    static Edge [] edges;
    static int [] dist;
    static final int INF = 987654321;
    static ArrayList<Edge> [] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());

        while (testCase-- > 0) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            init();

            for (int i = 0; i < m+w; i++) {

                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(i<m){
                    info[a].add(new Edge(b, c));
                    info[b].add(new Edge(a, c));
                }
                else info[a].add(new Edge(b, -c));
            }

            if(bellmanFord(1)) sb.append("YES\n");
            else sb.append("NO\n");

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bellmanFord(int start){

        dist[start] = 0;

        for (int i = 1; i <= n; i++) {
            boolean flag = false;
            for (int j = 1; j <= n; j++) {
                for(Edge e : info[j]){
                    if(dist[e.vertex] > dist[j]  + e.dist){
                        if(i==n)return true;
                        flag = true;
                        dist[e.vertex] = dist[j]  + e.dist;
                    }
                }
            }
            if(!flag)return false;
        }
        return false;
    }

    static void init(){

        edges = new Edge[m + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        info = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            info[i] = new ArrayList<>();
        }
    }


    static class Edge {

        int vertex;
        int dist;

        public Edge(int vertex, int dist) {

            this.vertex = vertex;
            this.dist = dist;
        }
    }
}