import java.io.*;
import java.util.*;

public class Main {

    static int m, n, birusCnt;
    static int [][] visited;
    static int [][] map;
    static int cnt;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<int[] > q;
    static int possibleArea;
    static LinkedList<int[]> birusList;
    static int [] seq;
    static int ans=-1 ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = m;
        birusCnt = Integer.parseInt(st.nextToken());
        visited = new int[m][n];
        map = new int[m][n];
        q = new LinkedList<>();
        birusList = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) birusList.add(new int[]{i, j});
                if(map[i][j]==0) possibleArea++;
            }
        }
        seq = new int[birusList.size()];
        possibleArea+= birusList.size()-birusCnt;
        comb(0, 0);
        sb.append(ans);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void comb(int start, int index) {
        if (birusCnt == index) {
            for (int i = 0; i < m; i++) Arrays.fill(visited[i], 0);
            for (int i = 0; i < birusCnt; i++) {
                int[] yx = birusList.get(seq[i]);
                q.add(yx);
                visited[yx[0]][yx[1]] = 1;
            }
            bfs();

            return;
        }
        for (int i = start; i < birusList.size(); i++) {
            seq[index] = i;
            comb(i + 1, index + 1);
        }

    }

    static void bfs(){
        int second = 2;
        cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int [] yx = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = yx[1] + dx[i];
                    int ny = yx[0] + dy[i];
                    if(ny<0||ny>=m||nx<0||nx>=n)continue;
                    if(map[ny][nx]==1||visited[ny][nx]!=0)continue;
                    visited[ny][nx] = second;
                    q.add(new int[]{ny, nx});
                    cnt++;
                }
            }
            second++;
        }
        
        if(possibleArea==cnt&&ans!=-1) ans = Math.min(ans, second - 3);
        else if(possibleArea==cnt&&ans==-1)ans = second - 3;
    }
}