import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int testCase;
    static int n;
    static int [] coin;
    static int [] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            coin = new int[n+1];
            for (int i = 0; i < n; i++) coin[i + 1] = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(br.readLine());
            dp = new int [target+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= target; j++) {
                    if(j-coin[i]==0) dp[j]++;
                    else if(j-coin[i]>0) dp[j] = dp[j] + dp[j - coin[i]];
                }
            }
            sb.append(dp[target]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}