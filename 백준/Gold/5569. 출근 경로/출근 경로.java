import java.io.*;
import java.util.*;

public class Main {


    static final int mod = 100000;
    static int [][][][] dp;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new int[2][2][m][n];

        sb.append((solution(2, 1, 0, 0) + solution(2, 0, 1, 1))%mod);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int solution(int cnt,  int y, int x, int curDir) {
        if(y==m-1&&x==n-1) return 1;
        if(y==m||x==n) return 0;
        int canChangeDirection = 0;
        if(cnt>=2)canChangeDirection = 1;
        if(dp[canChangeDirection][curDir][y][x]!=0) return dp[canChangeDirection][curDir][y][x];
        dp[canChangeDirection][curDir][y][x] += solution(cnt + 1, y + dy[curDir], x + dx[curDir], curDir) % mod;
        if (canChangeDirection == 1) {
            dp[canChangeDirection][curDir][y][x] += solution(1, y + dy[curDir^1], x + dx[curDir^1], curDir^1) % mod;
        }
        return dp[canChangeDirection][curDir][y][x] % mod;
    }
}