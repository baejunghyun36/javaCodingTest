import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int [] depth;
    static int [] visited;
    static int [] parent;
    static int [] costOfVertex;
    static int answer;
    static StringBuilder sb;
    static ArrayList<int []> [] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        depth = new int[n + 1];
        visited = new int[n + 1];
        parent = new int[n + 1];
        costOfVertex = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 1; i <= n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        m = Integer.parseInt(br.readLine());
        visited[1] = 1;
        dfs(0,  1);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int lca(int a, int b) {

        if(a==b)return 0 ;
        int cost = costOfVertex[a] + costOfVertex[b];
        while(a!=b){
            if(depth[a]>=depth[b]) a = parent[a];
            else b = parent[b];
        }
        cost-= 2*costOfVertex[a];
        return cost;
    }

    static void dfs(int level, int cur) {

        for (int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i)[0];
            int cost = list[cur].get(i)[1];
            if(visited[next]==1)continue;
            visited[next] = 1;
            parent[next] = cur;
            depth[next] = level+1;
            costOfVertex[next] = costOfVertex[cur] + cost;
            dfs(level + 1,next);
        }
    }
}