import java.io.*;
import java.util.*;

public class Main {


    static int [][][][] dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    //하, 상, 우, 좌
    static Queue<int[]> q;
    static int m, n;
    static char [][] map;
    static int [] start;
    static int [][] end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        dp = new int[4][5][m][n];
        int idx = 0;
        start = new int[2];
        end = new int[2][2];
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if(map[i][j]=='S') {
                    start[0] = i;
                    start[1] = j;
                }
                if(map[i][j]=='C'){
                    map[i][j] = (char)('A' + idx);
                    idx++;
                }
            }
        }
        for (int k = 0; k < 4; k++) {
            for (int d = 0; d < 5; d++) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        dp[k][d][i][j] = -1;
                    }
                }
            }
        }
        dp[0][4][start[0]][start[1]] = 0;
        q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0, 4, 0});
        int answer = bfs();
        if(answer==0) answer = -1;
        System.out.println(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        //하, 상, 우, 좌
        while (!q.isEmpty()) {
            int[] info = q.poll();
            int y = info[0];
            int x = info[1];
            int dist = info[2];
            int prev = info[3];
            int cnt = info[4];
            if (map[y][x] == 'A') cnt |= 1;
            if(map[y][x]=='B') cnt|=2;
            if(cnt==3) return dist;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(ny<0||ny>=m||nx<0||nx>=n)continue;
                if(map[ny][nx]=='#')continue;
                if(prev==i)continue;
                if(dp[cnt][i][ny][nx]!=-1)continue;
                dp[cnt][i][ny][nx] = dist+1;
                q.add(new int[]{ny, nx, dist + 1, i, cnt});
            }
        }
        return 0;
    }
}