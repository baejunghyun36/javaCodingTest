import java.io.*;
import java.util.*;

public class Main {
    static int [] depth, visited;
    static int [][] parent;
    static int d;
    static ArrayList<Integer> [] list;

    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        depth = new int[n + 1];

        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for (int i = 1; i <= n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        int tmp = 1;
        d = 0;
        while (tmp <= n) { // 최대 depth 알아내기.
            tmp <<= 1;
            d++;
        }
        parent = new int[d + 1][n + 1];
        visited = new int[n + 1];
        dfs(1, 1);
        setParent();
        m = Integer.parseInt(br.readLine());
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
    //으어.. 해설 참고해버림
    static int lca(int a, int b) {

        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        for (int i = d - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[i][a];
            }
        }

        if (a == b) return a;

        for (int i = d - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }

    static void setParent(){
        for (int i = 1; i < d; i++) {
            for (int j = 1; j <= n; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
    }

    static void dfs(int level, int cur){

        visited[cur] = 1;
        depth[cur] = level;
        for (int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i);
            if(visited[next]==1)continue;
            parent[0][next] = cur;
            dfs(level + 1, next);
        }
    }
}