import java.io.*;
import java.util.*;

public class Main {

    static char [][] map;
    static int m, n;
    static Garbage [][] garbageMap;
    static char [][] aroundMap;
    static int [] start, end;
    static Queue<int []> q;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        start = new int[2];

        q = new LinkedList<>();
        end = new int[2];
        map = new char[m][n];
        aroundMap = new char[m][n];
        garbageMap = new Garbage[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                garbageMap[i][j] = new Garbage(INF, INF);
            }
        }
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if(map[i][j]=='S'){
                    start[0] = i;
                    start[1] = j;
                    garbageMap[i][j].cnt = 0;
                    garbageMap[i][j].around = 0;
                }
                else if(map[i][j]=='F'){
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 'g'){
                    for (int d = 0; d < 4; d++) {
                        int nx = dx[d] + j;
                        int ny = dy[d] + i;
                        if(ny<0||ny>=m||nx<0||nx>=n)continue;
                        aroundMap[ny][nx] = 'a';
                    }
                }
            }
        }
        aroundMap[start[0]][start[1]] = '.';
        aroundMap[end[0]][end[1]] = '.';
        q.add(new int[]{start[0], start[1]});
        bfs();
        Garbage endPoint = garbageMap[end[0]][end[1]];
        sb.append(endPoint.cnt + " " +endPoint.around);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(){
        Garbage cmp = new Garbage(0,0);
        while (!q.isEmpty()) {
            int[] yx = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = yx[0] + dy[i];
                int nx = yx[1] + dx[i];
                if(ny<0||ny>=m||nx<0||nx>=n)continue;
                Garbage cur = garbageMap[yx[0]][yx[1]];
                cmp.cnt = cur.cnt;
                cmp.around = cur.around;
//                System.out.println(map[ny][nx]);
                if(map[ny][nx]=='g') cmp.cnt++;
                else if(aroundMap[ny][nx]=='a') cmp.around++;
                Garbage next = garbageMap[ny][nx];
                boolean flag = false;

                if(next.cnt>cmp.cnt){
                    next.cnt = cmp.cnt;
                    next.around = cmp.around;
                    flag = true;
                }
                else if (next.cnt == cmp.cnt && next.around > cmp.around) {
                    next.around = cmp.around;
                    flag = true;
                }
                if(flag){
                     q.add(new int[]{ny, nx});
                }
            }
        }
    }
    static class Garbage {

        int cnt;
        int around;

        public Garbage( int cnt, int around) {
            this.cnt = cnt;
            this.around = around;
        }
    }
}


/*
3 3
ggF
ggg
Sgg

                   for (int k = 0; k < n; k++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(garbageMap[k][j].cnt+" ");
                        }
                        System.out.println();
                    }
                    System.out.println();
*/