import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Main {


    static Queue<Birus> q;
    static int [][] map;
    static int n, k;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        ArrayList<Birus> birusList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                birusList.add(new Birus(i, j, map[i][j]));
            }
        }
        Collections.sort(birusList, (o1, o2) -> o1.type - o2.type);
        q = new LinkedList<>();
        for (Birus b : birusList) {
            q.add(b);
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken())-1;
        int x = Integer.parseInt(st.nextToken())-1;
        sb.append(bfs(s, y, x));


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int s, int y, int x){
        int second = 0;
        while (!q.isEmpty()) {
            if (second == s) {
                return map[y][x];
            }
            int size = q.size();
            while (size-- > 0) {
                Birus b = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = b.y + dy[i];
                    int nx = b.x + dx[i];
                    int type = b.type;
                    if(ny<0||ny>=n||nx<0||nx>=n)continue;
                    if(map[ny][nx]!=0)continue;
                    map[ny][nx] = type;
                    q.add(new Birus(ny, nx, type));
                }
            }
            second++;
        }
        return map[y][x];
    }

    static class Birus {

        int y;
        int x;
        int type;

        public Birus(int y, int x, int type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }
    }
}