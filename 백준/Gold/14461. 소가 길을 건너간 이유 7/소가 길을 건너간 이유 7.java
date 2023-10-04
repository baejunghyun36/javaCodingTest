import java.io.*;
import java.util.*;

public class Main {

    static long [][][] dp;
    static int [][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Node> q;
    static int n, t;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        dp = new long[3][n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 3; j++) Arrays.fill(dp[j][i], INF);
        }

        q = new LinkedList<>();
        dp[0][0][0] = 0;
        q.add(new Node(0, 0, 0,0));
        bfs();

        long answer = Math.min(dp[0][n - 1][n - 1], Math.min(dp[1][n - 1][n - 1], dp[2][n - 1][n - 1]));

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){

        while (!q.isEmpty()) {

            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;
                if(ny<0||ny>=n||nx<0||nx>=n)continue;
                long nextCost = (long)node.cost + t;
                int nextCnt = node.cnt + 1;
                if(nextCnt==3) {
                    nextCost+= (long)map[ny][nx];
                    nextCnt = 0;
                }
                if(dp[nextCnt][ny][nx]<=nextCost)continue;
                dp[nextCnt][ny][nx] = nextCost;
                q.add(new Node(ny, nx, nextCnt, nextCost));
            }
        }
    }

    static class Node{

        int y;
        int x;
        int cnt;
        long cost;

        public Node(int y, int x, int cnt, long cost) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.cost = cost;
        }
    }
}