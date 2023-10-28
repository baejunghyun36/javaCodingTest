import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<Integer> [] list;
    static int [] visited;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 2];
        visited = new int[n + 2];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }


        dp = new int[2][n + 2];
        visited[1] =1 ;
        dfs(1);
        sb.append(Math.min(dp[0][1], dp[1][1]));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur){

        dp[0][cur] = 0;
        dp[1][cur] = 1;
        for (int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i);
            if(visited[next]==1)continue;
            visited[next] = 1;
            dfs(next);
            dp[0][cur] += dp[1][next];
            dp[1][cur] += Math.min(dp[0][next], dp[1][next]);
        }
    }
}