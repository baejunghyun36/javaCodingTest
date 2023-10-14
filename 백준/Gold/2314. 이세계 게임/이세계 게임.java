import java.io.*;
import java.util.*;

public class Main {
    static int [][] map;
    static int [][] goal;
    static int[] dx = {1, -1, 0};
    static int[] dy = {0, 0, 1};
    static int n = 4;
    static int [][] visited;
    static int [][] fixed;
    static Queue<int[]> q;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        map = new int[n][n];
        goal = new int[n][n];
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 4; j++) {
                if(s.charAt(j)=='P')map[i][j] = 1;
            }
        }
        br.readLine();
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 4; j++) {
                if(s.charAt(j)=='P')goal[i][j] = 1;
            }
        }

        fixed = new int[n][n];


        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(map[i][j]!=goal[i][j]){
                    q = new LinkedList<>();
                    visited = new int[n][n];
                    visited[i][j] = 1;
                    q.add(new int[]{i, j, 0});
                    bfs(map[i][j]);
                    map[i][j] = goal[i][j];
                }
                fixed[i][j] = 1;
            }
        }

        sb.append(answer);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int type){

        while (!q.isEmpty()) {
            int [] yx = q.poll();
            for (int i = 0; i < 3; i++) {
                int nx = yx[1] + dx[i];
                int ny = yx[0] + dy[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (visited[ny][nx] == 1 || fixed[ny][nx] == 1) continue;
                if (map[ny][nx] != type && goal[ny][nx]!=map[ny][nx]) {
                    map[ny][nx] = type;
                    answer += yx[2] + 1;
                    return;
                }
                visited[ny][nx] = 1;
                q.add(new int[]{ny, nx, yx[2] + 1});
            }
        }
    }

}