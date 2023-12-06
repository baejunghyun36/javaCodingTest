import java.util.*;
import java.io.*;

public class Main {

    static List <Edge> [] graph;
    static int n;
    static int [] visited;
    static Set <Integer> visitedEdge;
    static long maxLen;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];

        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(i, b, c));
            graph[b].add(new Edge(i, a, c));
        }

        visited = new int[n];
        visitedEdge = new HashSet<>();
        long answer = 0;

        for (int i = 0; i <= n - 1; i++) {
            for(Edge e : graph[i]){
                if (!visitedEdge.contains(e.idx)) {
                    Arrays.fill(visited, 0);
                    visitedEdge.add(e.idx);
                    visited[e.idx] = 1;
                    answer = Math.max(answer, subsetRun(i) + subsetRun(e.to) + e.cost);
                }
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static long subsetRun(int vertex){
        maxLen = 0;
        dfs(vertex);
        return maxLen;
    }

    static long dfs(int cur){
        ArrayList<Long> temp = new ArrayList<>();
        for (Edge e : graph[cur]) {
            if(visited[e.idx]==1)continue;
            visited[e.idx] = 1;
            temp.add(dfs(e.to)+e.cost);
        }
        if(temp.size()==0) return 0;
        Collections.sort(temp, Collections.reverseOrder());
        maxLen = Math.max(maxLen, temp.get(0));
        if(temp.size()>=2) maxLen = Math.max(maxLen, temp.get(0) + temp.get(1));
        return temp.get(0);
    }


    static class Edge {

        int idx;
        int to;
        long cost;

        public Edge(int idx, int to, long cost) {
            this.idx = idx;
            this.to = to;
            this.cost = cost;
        }
    }
}