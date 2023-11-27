import java.io.*;
import java.util.*;

public class Main {

    static int m, n, c, k;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    static int [][] map;
    static int [][][][] dp;
    static final int mod = 1000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[m + 1][n + 1];
        dp = new int[51][c + 1][m + 1][n + 1];

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = i+1;
        }

        for (int i = 0; i <= c; i++) {
        
            k = i;
            for(int l = 0; l<=50; l++){
                for (int j = 0; j <= i; j++) {
                    for (int r = 1; r <= m; r++) {
                        for (int c = 1; c <= n; c++) {
                            dp[l][j][r][c] = -1;
                        }
                    }
                }
            }

            int answer = 0;
            if(map[1][1]!=0) answer = dfs(map[1][1], 1, 1, 1);
            else answer = dfs(0, 1, 1, 0);
            sb.append(answer + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int cur, int y, int x, int cnt) {


        if (y == m && x == n) {
            if(cnt==k) return 1;
            else return 0;
        }
        if(dp[cur][cnt][y][x]!=-1) return dp[cur][cnt][y][x];
        dp[cur][cnt][y][x] = 0;
        for (int i = 0; i < 2; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny>m||nx>n)continue;
            if(map[ny][nx]!=0&&cur<map[ny][nx]) dp[cur][cnt][y][x] = (dp[cur][cnt][y][x] + dfs(map[ny][nx], ny, nx, cnt+1))%mod;
            else if(map[ny][nx]==0) dp[cur][cnt][y][x] = (dp[cur][cnt][y][x] + dfs(cur, ny, nx, cnt))%mod;
        }
        return dp[cur][cnt][y][x]%mod;

    }
}