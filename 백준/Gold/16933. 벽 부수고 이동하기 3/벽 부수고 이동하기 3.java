import java.io.*;
import java.util.*;

public class Main {

    static int isDay;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int [][] map;
    static int [][][] visited;
    static int m, n, k;
    static Queue<int[]> q;
    static int endY, endX;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int [m][n];
        visited = new int[k+1][m][n];
        q = new LinkedList<>();
        endY = m-1;
        endX = n-1;
        for(int i=0; i<m; i++){
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int j = 0; j <= k; j++) {
            for (int k = 0; k < m; k++) {
                for (int l = 0; l < n; l++) {
                    visited[j][k][l] = INF;
                }
            }
        }

        visited[k][0][0] = 1;
        q.add(new int[]{k, 1, 0, 0});
        sb.append(bfs());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(){
        while (!q.isEmpty()) {
            int size = q.size();
            isDay ^= 1;
            while (size-- > 0) {
                int [] info = q.poll();
                int remainK = info[0];
                int dist = info[1];
                int curY = info[2];
                int curX = info[3];
                if(curY==endY&&curX==endX)return dist;
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i]+curX;
                    int ny = dy[i]+curY;
                    if(ny<0||ny>=m||nx<0||nx>=n)continue;
                    if(remainK==0&&map[ny][nx]==1)continue;
                    int tempK = remainK;
                    //낮일 때
                    if(isDay==1){
                        if(map[ny][nx]==1&&tempK>0)  tempK--;
                    }
                    //밤일 때
                    else {
                        if(map[ny][nx]==1&&tempK>0) {
                            q.add(new int []{tempK, dist+1, curY, curX});
                            continue;
                        }
                    }

                    if(visited[tempK][ny][nx]<=dist+1)continue;
                    visited[tempK][ny][nx] = dist+1;
                    q.add(new int[]{tempK, dist + 1, ny, nx});
                }
            }
        }
        return -1;
    }
}