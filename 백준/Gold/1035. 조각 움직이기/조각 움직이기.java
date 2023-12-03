import java.io.*;
import java.util.*;

public class Main {

    static char [][] map;
    static Map <Integer, int []> idToLoc;
    static Map <Integer, int []> changeLoc;
    static int [][] temp;
    static int n;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int [][] loc;
    static int [][] visited;
    static int [] start;
    static int answer = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        map = new char[5][5];
        start = new int[2];
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }
        idToLoc = new HashMap<>();
        temp = new int[5][5];
        visited = new int[5][5];
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(map[i][j]=='*'){
                    idToLoc.put(idx++, new int[]{i, j});
                }
            }
        }
        n = idx;
        loc = new int[n][2];
        changeLoc = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            Arrays.fill(temp[i], -1);
        }
        backTracking(0, 0);
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void chk(int dist){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int [] {start[0], start[1]});
        for (int i = 0; i < 5; i++) Arrays.fill(visited[i], 0);
        visited[start[0]][start[1]] = 1;
        int cnt = 1;
        while (!q.isEmpty()) {
            int [] yx = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + yx[1];
                int ny = dy[i] + yx[0];
                if(ny<0||ny>=5||nx<0||nx>=5)continue;
                if(visited[ny][nx]==1||temp[ny][nx]==-1)continue;

                visited[ny][nx] = 1;
                cnt++;
                q.add(new int[]{ny, nx});
            }
        }

        if (cnt == n) {
            answer = Math.min(answer, dist);
        }
    }

    static void backTracking (int cur, int dist){
        if(answer<=dist)return;
        if(cur==n){
            chk(dist);
            return;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(temp[i][j]!=-1)continue;
                temp[i][j] = cur;
                start[0] = i;
                start[1] = j;
                int[] info = idToLoc.get(cur);
                int d = Math.abs(info[0] - i) + Math.abs(info[1] - j);
                backTracking(cur+1, dist+d);
                temp[i][j] = -1;
            }
        }
    }
}