import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, k, m;
    static int [] curVideoNum;
    static int [] nextVideoNum;
    static int [][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        curVideoNum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            curVideoNum[i] = Integer.parseInt(st.nextToken());
        }

        nextVideoNum = new int[k + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= k; i++) {
            nextVideoNum[i] = Integer.parseInt(st.nextToken());
        }

        int offset = 0;
        while ((1 << offset) <= m) {
            offset++;
        }

        dp = new int[offset][k + 1];
        for (int i = 0; i < offset; i++) {
            for (int j = 1; j <= k; j++) {
                if(i==0)dp[i][j] = nextVideoNum[j];
                else dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }

        String bitString = Integer.toBinaryString(m-1);
        for (int i = 1; i <= n; i++) {
            int cur = curVideoNum[i];
            int idx = 0;
            for (int j = bitString.length() - 1; j >= 0; j--) {
                if(bitString.charAt(j)=='1') cur = dp[idx][cur];
                idx ++;
            }
            sb.append(cur + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


}