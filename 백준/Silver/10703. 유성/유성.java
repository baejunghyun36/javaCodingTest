import java.io.*;
import java.util.*;

public class Main {

    static char [][] map;
    static int [] startMeteor, endLand;
    static int m, n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        startMeteor = new int[n];
        endLand = new int[n];
        map = new char[m][n];

        for (int i = 0; i < m; i++) map[i] = br.readLine().toCharArray();
        for (int j = 0; j < n; j++) {
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                if(map[i][j]=='X') startMeteor[j] = i+1;
                else if(map[i][j]=='#'&&flag==false){
                    endLand[j] = m-i;
                    flag = true;
                }
            }
        }

        int maxHeight = 1;
        int startY = -1;
        int startX = -1;

        for (int i = 0; i < n; i++) {
            if(maxHeight<=endLand[i]+startMeteor[i]&&startMeteor[i]>0){
                maxHeight = endLand[i]+startMeteor[i];
                startX = i;
                startY = startMeteor[i]-1;
            }
        }

        if(startY!=-1)bfs(startY, startX, m - startMeteor[startX] - endLand[startX]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)  {
                if(map[i][j]=='M') sb.append('X');
                else sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x, int offset){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        map[y+offset][x] = 'M';
        map[y][x] = '.';
        while (!q.isEmpty()) {
            int[] yx = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + yx[1];
                int ny = dy[i] + yx[0];
                if(ny<0||ny>=m||nx<0||nx>=n||map[ny][nx]!='X')continue;
                map[ny+offset][nx] = 'M';
                map[ny][nx] = '.';
                q.add(new int[]{ny, nx});
            }
        }
    }
}