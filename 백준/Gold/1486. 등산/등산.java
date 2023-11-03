import java.io.*;
import java.util.*;

public class Main {

    static int m, n, threshold, darkTime;
    static int [][] map, dp;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int answer;
    static ArrayList<int []> []list;
    static int [][][][] floydArr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        threshold = Integer.parseInt(st.nextToken());
        darkTime = Integer.parseInt(st.nextToken());
        floydArr = new int[m][n][m][n];

        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) > 'Z') map[i][j] = s.charAt(j) - 'a' + 26;
                else map[i][j] = s.charAt(j) - 'A';
            }
        }
        floydArr = new int[m][n][m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    Arrays.fill(floydArr[i][j][k], 1000001);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    int ny = dy[k] + i;
                    int nx = dx[k] + j;
                    if(ny<0||ny>=m||nx<0||nx>=n)continue;
                    if(Math.abs(map[i][j]-map[ny][nx])>threshold)continue;
                    if (map[i][j]>=map[ny][nx]) {
                        floydArr[i][j][ny][nx] = 1;
                    }
                    else{
                        floydArr[i][j][ny][nx] = (int)Math.pow(Math.abs(map[i][j] - map[ny][nx]), 2);
                    }
                }
            }
        }

        int total = n*m;
        for (int k = 0; k < total; k++) {
            for (int i = 0; i < total; i++) {
                for (int j = 0; j < total; j++) {
                    if (find(i, j) > find(i, k) + find(k, j)) {
                        update(i, j, k);
                    }
                }
            }
        }

        int maxHeight = map[0][0];
        for (int i = 0; i < total; i++) {
            int y = i/n;
            int x = i%n;
            if(darkTime>=floydArr[y][x][0][0]+floydArr[0][0][y][x]){
                maxHeight = Math.max(maxHeight, map[y][x]);
            }
        }

        sb.append(maxHeight);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

//    static boolean check(int offset1, int offset2) {
//        int y = offset1/n;
//        int x = offset1%n;
//        int yy = offset2/n;
//        int xx = offset2%n;
//        if(Math.abs(map[y][x]-map[yy][xx])>threshold)return false;
//        return true;
//    }

    static void update(int offset1, int offset2, int offset3) {
        int y = offset1/n;
        int x = offset1%n;
        int yy = offset2/n;
        int xx = offset2%n;
        int yyy = offset3/n;
        int xxx = offset3%n;
        floydArr[y][x][yy][xx] = floydArr[y][x][yyy][xxx] + floydArr[yyy][xxx][yy][xx];
    }

    static int find(int offset1, int offset2) {
        int y = offset1/n;
        int x = offset1%n;
        int yy = offset2/n;
        int xx = offset2%n;
        return floydArr[y][x][yy][xx];
    }
}