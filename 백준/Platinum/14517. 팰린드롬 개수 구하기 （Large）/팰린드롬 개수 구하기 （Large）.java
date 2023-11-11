import java.io.*;
public class Main {
    static String s;
    static int [][] dp;
    static final int mod = 10007;
    //해설 참고..
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        s = br.readLine();
        int n = s.length();
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < n; j++) {
            if (s.charAt(j-1) == s.charAt(j)) dp[j-1][j] = 3;
            else dp[j - 1][j] = 2;
        }

        int l = 2;
        while (l < n) {
            for (int i = 0; i < n-l; i++) {
                int j = i + l;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (dp[i+1][j] + dp[i][j-1] + 1)%mod;
                } else {
                    dp[i][j] = (mod + dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1])%mod;
                }
            }
            l++;
        }

        sb.append(dp[0][n - 1] % mod);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}