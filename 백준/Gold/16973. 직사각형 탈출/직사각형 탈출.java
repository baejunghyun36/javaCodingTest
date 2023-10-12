import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static int [][] map;
    static int h, w, sr, sc, fr, fc;
    static int [][] second;
    static final int INF = 987654321;
    static Queue<int[] > q;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m + 1][n + 1];
        second = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        fr = Integer.parseInt(st.nextToken());
        fc = Integer.parseInt(st.nextToken());

        for(int i=1; i<=m; i++)Arrays.fill(second[i], INF);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(map[i][j]==1){
                    for (int r = i; r >= i - h + 1; r--) {
                        if(r<=0)break;
                        for (int c = j; c >= j - w + 1; c--) {
                            if(c<=0)break;
                            second[r][c] = -1;
                        }
                    }
                }
            }
        }

        second[sr][sc] = 1;
        q = new LinkedList<>();
        q.add(new int[]{sr, sc, 1});
        bfs();
        if(second[fr][fc]==INF||second[fr][fc]==-1) sb.append(-1);
        else sb.append(second[fr][fc] - 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){

        while (!q.isEmpty()) {
            int [] yx = q.poll();
            if (yx[0] == fr && yx[1] == fc) return;
            int sec = yx[2];
            for (int i = 0; i < 4; i++) {
                int nx = yx[1] + dx[i];
                int ny = yx[0] + dy[i];
                if(ny<=0||ny>m||nx<=0||nx>n)continue;
                if(ny+h-1>m||nx+w-1>n)continue;
                if(second[ny][nx]==-1||second[ny][nx]<=sec+1)continue;
                second[ny][nx] = sec+1;
                q.add(new int[]{ny, nx, sec+1});
            }
        }
    }
}