import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static Map<Character, int []> dir;
    static char [][] map;
    static int [][]visited;
    static int number = 1;
    static Queue<int[]> q;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        q = new LinkedList<>();
        dir = new HashMap<>();
        dir.put('D', new int[]{1, 0});
        dir.put('U', new int[]{-1, 0});
        dir.put('L', new int[]{0, -1});
        dir.put('R', new int[]{0, 1});

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visited = new int[m][n];

        for (int i = 0; i < m; i++) map[i] = br.readLine().toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]==0){
                    visited[i][j] = number;
                    q.add(new int[]{i, j});
                    bfs();
                    number++;
                }
            }
        }
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){

        while (!q.isEmpty()) {
            int[] yx = q.poll();
            int[] nextYx = dir.get(map[yx[0]][yx[1]]);
            int ny = nextYx[0] + yx[0];
            int nx = nextYx[1] + yx[1];
            if(visited[ny][nx]==0){
                visited[ny][nx] = number;
                q.add(new int[]{ny, nx});
            }
            else if(visited[ny][nx]!=number) return;
            else{
                answer++;
                return;
            }
        }
    }
}