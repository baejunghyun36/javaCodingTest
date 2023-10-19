import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static int [] dp, maxCandiesPerRow;
    static int [][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        while(true){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m==0&&n==0)break;
            dp = new int[m + 1];
            maxCandiesPerRow = new int[m + 1];
            map = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            initMaxCandiesPerRow();
            sb.append(solution()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int solution(){

        if(m>=1) dp[1] = maxCandiesPerRow[1];
        if(m>=2) dp[2] = maxCandiesPerRow[1] <maxCandiesPerRow[2] ? maxCandiesPerRow[2] : maxCandiesPerRow[1];
        if(m>=3) {
            for (int i = 3; i <= m; i++) dp[i] = Math.max(Math.max(dp[i - 2], dp[i - 3]) + maxCandiesPerRow[i], dp[i-1]);
        }
        return dp[m];
    }

    static void initMaxCandiesPerRow (){

        for (int i = 1; i <= m; i++) {
            int[] temp = new int[n + 1];
            if(n>=1) temp[1] = map[i][1];
            if(n>=2) temp[2] = Math.max(map[i][1], map[i][2]);
            if(n>=3) {
                for (int j = 3; j <= n; j++) temp[j] = Math.max(Math.max(temp[j-2], temp[j-3])+map[i][j], temp[j-1]);
            }
            maxCandiesPerRow[i] = temp[n];
        }
    }
}