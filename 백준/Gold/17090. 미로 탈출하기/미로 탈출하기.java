import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static int [][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static String dir = "URDL";
    static int answer;
    static int [][] isTrue;
    static int [][] visited;
    // -1 : false
    //  1 : true
    //  0 : not visit
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new int[m][n];
        isTrue = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = dir.indexOf(s.charAt(j));
            }
        }

        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(isTrue[i][j]==0) isTrue[i][j] = dfs(i, j);
                if(isTrue[i][j]==1)answer++;
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int y, int x){

        if(y<0||y>=m||x<0||x>=n||isTrue[y][x]==1)return 1;
        if(isTrue[y][x]==-1||visited[y][x]==1)return -1;
        visited[y][x] = 1;
        return isTrue[y][x] = dfs(y + dy[map[y][x]], x + dx[map[y][x]]);
    }
}