import java.io.*;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new int[4][10001];

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 10000; j++) {
                if (i == j) dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])+1;
                else if(i>j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i][j - i];
            }
        }
        for (int i = 0; i < n; i++) {
            sb.append(dp[3][Integer.parseInt(br.readLine())]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


}