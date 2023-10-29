import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<Integer>[] list;
    static int [][] dp;
    static int [] visited;
    static int [] people;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        people = new int[n + 1];
        dp = new int[2][n + 1];
        list = new ArrayList[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= n; i++) {

            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        visited = new int[n + 1];
        dfs(1);

        int answer = Math.max(dp[0][1], dp[1][1]);
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur) {

        dp[0][cur] = 0;
        dp[1][cur] = people[cur];
        visited[cur] = 1;
        for (int i = 0; i < list[cur].size(); i++) {
            int child = list[cur].get(i);
            if(visited[child]==1)continue;
            dfs(child);
            dp[0][cur] += Math.max(dp[1][child], dp[0][child]);
            dp[1][cur] += dp[0][child];
        }

    }
}