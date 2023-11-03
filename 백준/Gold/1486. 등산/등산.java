import java.io.*;
import java.util.*;

public class Main {

    static int m, n, threshold, darkTime;
    static int [][] map, dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer;
    static ArrayList<int []> []list;
    static final int INF = 1000001;
    static int [][][][] dist;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        threshold = Integer.parseInt(st.nextToken());
        darkTime = Integer.parseInt(st.nextToken());


        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) > 'Z') map[i][j] = s.charAt(j) - 'a' + 26;
                else map[i][j] = s.charAt(j) - 'A';
            }
        }
        dist = new int[m][n][m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    Arrays.fill(dist[i][j][k], 1000001);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dijk(i, j);
            }
        }
        int maxHeight = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[0][0][i][j] + dist[i][j][0][0] <= darkTime) {
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }
        }


        sb.append(maxHeight);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijk(int y, int x) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(y, x, 0));
        dist[y][x][y][x] = 0;
        int[][] visited = new int[m][n];
        while (!pq.isEmpty()) {

            Node cur = pq.poll();
            if(visited[cur.y][cur.x]==1) continue;
            visited[cur.y][cur.x] = 1;
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if(ny<0||ny>=m||nx<0||nx>=n)continue;
                if(Math.abs(map[ny][nx]-map[cur.y][cur.x])>threshold)continue;
                int cost = 0;
                if(map[cur.y][cur.x]>=map[ny][nx])cost = 1;
                else cost = (int)Math.pow(Math.abs(map[cur.y][cur.x] - map[ny][nx]), 2);
                if (dist[y][x][ny][nx] > cur.time + cost) {
                    dist[y][x][ny][nx] = cur.time + cost;
                    pq.add(new Node(ny, nx, dist[y][x][ny][nx]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int y;
        int x;
        int time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }

        public int compareTo(Node node) {
            return this.time - node.time;
        }
    }

}