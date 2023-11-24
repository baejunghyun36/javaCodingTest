import java.io.*;
import java.util.*;

public class Main {

    static int [][] dp;
    static int [][] temp;
    static int [][] map;
    static int m, n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m+1][n+1];
        temp = new int[2][n + 1];
        dp = new int [m+1][n+1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        solution();
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void solution() {

        for (int i = 1; i <= n; i++) dp[1][i] = dp[1][i - 1] + map[1][i];

        for (int i = 2; i <= m; i++) {
            temp[0][1] = dp[i-1][1] + map[i][1];
            for (int j = 2; j <= n; j++) {
                temp[0][j] = Math.max(dp[i - 1][j], temp[0][j - 1]) + map[i][j];
            }
            temp[1][n] = dp[i - 1][n] + map[i][n];
            for (int j = n - 1; j >= 1; j--) {
                temp[1][j] = Math.max(dp[i - 1][j], temp[1][j + 1]) + map[i][j];
            }
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
        answer = dp[m][n];
    }
}