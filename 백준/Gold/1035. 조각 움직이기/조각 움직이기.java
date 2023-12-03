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
    static int answer = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        map = new char[5][5];
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
        backTracking(0);
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void chk(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int [] {loc[0][0], loc[0][1]});
        for (int i = 0; i < 5; i++) Arrays.fill(visited[i], 0);
        visited[loc[0][0]][loc[0][1]] = 1;
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
            int dist = 0;
            for (int i = 0; i < n; i++) {
                int[] info = idToLoc.get(i);
                dist += Math.abs(info[0] - loc[i][0]) + Math.abs(info[1] - loc[i][1]);
            }
            answer = Math.min(answer, dist);
        }
    }

    static void backTracking (int cur){
        if(cur==n){
            chk();
            return;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(temp[i][j]!=-1)continue;
                temp[i][j] = cur;
                loc[cur][0] = i;
                loc[cur][1] = j;
                backTracking(cur+1);
                temp[i][j] = -1;
            }
        }
    }
}