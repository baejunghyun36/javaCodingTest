import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static char [][] map;
    static int [][] visited;
    static int testCase = 1;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int minMoveCnt;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s = "";
        while ((s = br.readLine())!=null && !s.isEmpty()) {

            StringTokenizer st = new StringTokenizer(s);
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            int space = 0;
            minMoveCnt = INF;

            map = new char[m][n];
            visited = new int[m][n];
            for (int i = 0; i < m; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    if(map[i][j]=='.')space++;
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '.') {
                        visited[i][j] = 1;
                        backTracking(i, j, 0, space-1);
                        visited[i][j] = 0;
                    }
                }
            }

            if(minMoveCnt==INF)minMoveCnt = -1;
            sb.append("Case ").append(testCase++).append(": ").append(minMoveCnt).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int y, int x, int moveCnt, int space){

        if(space==0){
            minMoveCnt = Math.min(moveCnt, minMoveCnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y;
            int nx = x;
            int cnt = 0;

            while(true){
                ny += dy[i];
                nx += dx[i];
                if(ny<0||ny>=m||nx<0||nx>=n||visited[ny][nx]==1||map[ny][nx]=='*'){
                    ny -= dy[i];
                    nx -= dx[i];
                    break;
                }
                cnt++;
                visited[ny][nx] = 1;
            }

            if(cnt!=0){
                backTracking(ny, nx, moveCnt+1, space-cnt);
                while(!(ny==y&&nx==x)){
                    visited[ny][nx] = 0;
                    ny -= dy[i];
                    nx -= dx[i];
                }
            }
        }
    }
}