import java.io.*;
import java.util.*;

public class Main {

    static int m, n, k;
    static int [][][] dp;
    static char [][] map;
    static char [] str;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
        }

        str = br.readLine().toCharArray();

        dp = new int[str.length][m][n];
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < m; j++) {
                for(int k=0; k<n; k++){
                   dp[i][j][k] = -1;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < m; i++) {
            char c = str[0];
            for (int j = 0; j < n; j++) {
                if(map[i][j]==c)answer += dfs(i, j, 1);
            }
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int i, int j, int index) {

        if(index==str.length){
            return 1;
        }
        if(dp[index][i][j]!=-1) return dp[index][i][j];
        dp[index][i][j] = 0;


        for (int d = 0; d < 4; d++) {
            int nx = j;
            int ny = i;
            for (int o = 0; o < k; o++) {
                nx += dx[d];
                ny += dy[d];
                if(ny<0||ny>=m||nx<0||nx>=n)continue;
                if(map[ny][nx] == str[index])
                    dp[index][i][j] += dfs(ny, nx, index + 1);
            }
        }
        return dp[index][i][j];


    }
}