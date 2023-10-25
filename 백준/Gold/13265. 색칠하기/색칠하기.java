import java.io.*;
import java.util.*;

public class Main {

    static int n, m, testCase;
    static int [] visited;
    static List<Integer> [] list;
    static final String IMPOSSIBLE = "impossible";
    static final String POSSIBLE = "possible";
    static boolean isPossible = true;
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
            visited = new int[n + 1];
            Arrays.fill(visited, -1);
            list = new List[n + 1];
            for (int i = 1; i <=n; i++) list[i] = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            for (int i = 1; i <= n; i++) {
                if(visited[i]==-1) dfs(i, 0);
            }
            if(isPossible) sb.append(POSSIBLE).append("\n");
            if(!isPossible) sb.append(IMPOSSIBLE).append("\n");
            isPossible = true;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur, int color) {
        if(visited[cur]!=-1&& visited[cur]==color) return;
        if(visited[cur]!=-1&& visited[cur]!=color){
            isPossible = false;
            return;
        }
        visited[cur] = color;
        for (int i = 0; i < list[cur].size(); i++) {
            if(isPossible) dfs(list[cur].get(i), color ^ 1);
        }
    }
}