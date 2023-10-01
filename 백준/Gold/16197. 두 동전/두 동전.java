import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static char [][] map;
    static int [][][][] visited;
    static final int INF = 987654321;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int []> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        List<Integer> coins = new ArrayList<>();
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 'o') {
                    coins.add(i);
                    coins.add(j);
                }
            }
        }
        visited = new int[m][n][m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                        visited[i][j][k][l] = INF;
                    }
                }
            }
        }

        int [] start = new int[4];
        for (int i = 0; i < 4; i++) {
            start[i] = coins.get(i);
        }
        q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]][start[2]][start[3]] = 0;
        sb.append(bfs());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        int second = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] yx = q.poll();
                int y1 = yx[0];
                int x1 = yx[1];
                int y2 = yx[2];
                int x2 = yx[3];
                for (int i = 0; i < 4; i++) {
                    int ny1 = y1 + dy[i];
                    int nx1 = x1 + dx[i];
                    int ny2 = y2 + dy[i];
                    int nx2 = x2 + dx[i];
                    if((ny1<0||ny1>=m||nx1<0||nx1>=n)&&(ny2<0||ny2>=m||nx2<0||nx2>=n))continue;
                    if((ny1<0||ny1>=m||nx1<0||nx1>=n)||(ny2<0||ny2>=m||nx2<0||nx2>=n)){
                        return second;
                    }
                    if(map[ny1][nx1]=='#'){
                        ny1 = y1;
                        nx1 = x1;
                    }
                    if(map[ny2][nx2]=='#'){
                        ny2 = y2;
                        nx2 = x2;
                    }
                    if(visited[ny1][nx1][ny2][nx2]!=INF)continue;
//                    System.out.println(second);
                    visited[ny1][nx1][ny2][nx2] = second;
                    q.add(new int[]{ny1, nx1, ny2, nx2});

                }
            }
            second++;
            if(second>10) return -1;
        }
        return -1;
    }
}