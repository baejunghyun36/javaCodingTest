import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static char [][] map;
    static int [][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Map <Character, Integer> dir;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[m][n];
        dir = new HashMap<>();
        dir.put('S', 0);
        dir.put('N', 1);
        dir.put('E', 2);
        dir.put('W', 3);
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
        }
        int answer = 0;
        int vcnt = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    if(vcnt==dfs(i, j, vcnt)){
                        answer++;
                        vcnt++;
                    }
                }
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int dfs(int y, int x, int vcnt){

        if(visited[y][x]==vcnt) return vcnt;
        else if(visited[y][x]>0&&visited[y][x]<vcnt)return visited[y][x];
        visited[y][x] = vcnt;
        return visited[y][x] = dfs(y + dy[dir.get(map[y][x])], x + dx[dir.get(map[y][x])], vcnt);
    }
}