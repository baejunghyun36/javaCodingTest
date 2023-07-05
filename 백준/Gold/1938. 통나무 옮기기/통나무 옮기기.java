import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static char [][] board;
    static Queue <Log> q;
    static List<int []> pointOfStart;
    static List<int []> pointOfArrival;
    static int answer;
    static int [][][] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        pointOfArrival = new ArrayList<>();
        pointOfStart = new ArrayList<>();
        board = new char[n][n];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                board[i][j] = s.charAt(j);
                if(s.charAt(j)=='B'){
                    pointOfStart.add(new int[]{i, j});
                    board[i][j] = '0';
                }
                if(s.charAt(j)=='E'){
                    pointOfArrival.add(new int[]{i, j});
                    board[i][j] = '0';
                }
            }
        }
        q = new LinkedList<>();
        visited = new int[2][n][n];
        int [] yy = new int[3];
        int [] xx = new int[3];
        for(int i=0; i<3; i++){
            xx[i] = pointOfStart.get(i)[1];
            yy[i] = pointOfStart.get(i)[0];
        }
        int shape = 0;
        if(xx[0]==xx[1]) shape = 1;
        else shape = 0;
        visited[shape][yy[1]][xx[1]] = 1;
        q.add(new Log(yy.clone(), xx.clone(), 0, shape));

        bfs();
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
    static void bfs() {
        int [] ny = new int[3];
        int [] nx = new int[3];
        while (!q.isEmpty()) {
            Log log = q.poll();
            boolean flag = true;
            for (int i = 0; i < 3; i++) {
                if (pointOfArrival.get(i)[0] != log.y[i] || pointOfArrival.get(i)[1] != log.x[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer = log.dist;
                return;
            }

            for (int i = 0; i < 5; i++) {
                boolean possible = true;
                int shape = log.shape;
                if (i != 4) {
                    for (int j = 0; j < 3; j++) {
                        ny[j] = log.y[j] + dy[i];
                        nx[j] = log.x[j] + dx[i];
                        if (ny[j] < 0 || ny[j] >= n || nx[j] < 0 || nx[j] >= n || board[ny[j]][nx[j]] == '1'||(j == 1 && visited[shape][ny[j]][nx[j]] == 1)) {
                            possible = false;
                            break;
                        }
                    }
                }
                else {
                    //세로로
                    possible = true;
                    for(int j=0; j<8; j++){
                        int yy = log.y[1] + dy[j];
                        int xx = log.x[1] + dx[j];
                        if(yy<0||yy>=n||xx<0||xx>=n||board[yy][xx]=='1'){
                            possible = false;
                            break;
                        }
                    }
                    if(possible){
                        if (log.y[0] == log.y[1]) {
                            int x = log.x[1];
                            int uy = log.y[1] - 1;
                            int dy = log.y[1] + 1;
                            if (uy < 0 || dy >= n || board[dy][x] == '1' || board[uy][x] == '1') continue;
                            shape ^= 1;
                            if (visited[shape][log.y[1]][x] != 1) {
                                visited[shape][log.y[1]][x] = 1;
                                ny[0] = uy;
                                ny[1] = log.y[1];
                                ny[2] = dy;
                                nx[0] = nx[1] = nx[2] = x;
                                q.add(new Log(ny.clone(), nx.clone(), log.dist + 1, shape));
                            }
                        }
                        //가로로
                        else {
                            int y = log.y[1];
                            int lx = log.x[1] - 1;
                            int rx = log.x[1] + 1;
                            if (lx < 0 || rx >= n || board[y][lx] == '1' || board[y][rx] == '1') continue;
                            shape ^= 1;
                            if (visited[shape][y][log.x[1]] != 1) {
                                visited[shape][y][log.x[1]] = 1;
                                nx[0] = lx;
                                nx[1] = log.x[1];
                                nx[2] = rx;
                                ny[0] = ny[1] = ny[2] = y;
                                q.add(new Log(ny.clone(), nx.clone(), log.dist + 1, shape));
                            }
                        }
                    }
                    continue;
                }
                if(possible){
                    visited[shape][ny[1]][nx[1]] = 1;
                    q.add(new Log(ny.clone(), nx.clone(), log.dist + 1, shape));
                }
            }
        }
    }
    static class Log {

        int []y;
        int []x;
        int dist;
        int shape;

        public Log(int []y, int []x, int dist, int shape) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.shape = shape;
        }
    }
}