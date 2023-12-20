import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static long [][] dp;
    static int [] inputArray;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new long [1<<(n+1)][n+2];
        inputArray = new int[n+1];
        inputArray[0] = 30000;
        for (int i = 0; i < (1 << (n+1)); i++) Arrays.fill(dp[i], -1);
        for (int i = 1; i <= n; i++) inputArray[i] = Integer.parseInt(br.readLine());
        sb.append(dfs(1, 1, 0));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static long dfs(int visited, int index, int prevIndex) {

        if(index==n+1) return 1;
        if(dp[visited][prevIndex]!=-1) return dp[visited][prevIndex];
        dp[visited][prevIndex] = 0;
        for (int i = 1; i <= n; i++) {
            if ((visited&(1<<i))==0&&Math.abs(inputArray[prevIndex] - inputArray[i]) > k) {
                dp[visited][prevIndex] += dfs(visited | (1 << i), index + 1, i);
            }
        }
        return dp[visited][prevIndex];
    }
}