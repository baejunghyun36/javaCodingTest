import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int [] arr;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[n + 1];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        dfs(0, n - 1);
        sb.append(dp[0][n - 1]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int s, int e){
        if(s>=e) return dp[s][e] = 0;
        if(dp[s][e]!=-1) return dp[s][e];
        if(arr[s]==arr[e]) dp[s][e] = dfs(s + 1, e - 1);
        else dp[s][e] = Math.min(dfs(s + 1, e), dfs(s, e - 1) )+ 1;
        return dp[s][e];
    }
}