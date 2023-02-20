import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14500 {

    static int [][][] tetromino = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},

            // ㄹ형
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
            {{0, 0}, {1, 0}, {0, 1}, {-1, 1}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},

            // 정사각형
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}},

            // ㄴ형
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {2, -1}},
            {{0, 0}, {1, 0}, {2, 0}, {0, -1}},
            {{0, 0}, {1, 0}, {2, 0}, {0, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
            // ㅗ형
            {{0, 0}, {1, 0}, {2, 0}, {1, -1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}}

    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] map = new int[n][m];
        int answer = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                for (int i = 0; i < 19; i++) {

                    int x2 = x + tetromino[i][1][0];
                    int y2 = y + tetromino[i][1][1];

                    int x3 = x + tetromino[i][2][0];
                    int y3 = y + tetromino[i][2][1];

                    int x4 = x + tetromino[i][3][0];
                    int y4 = y + tetromino[i][3][1];

                    // 범위 밖이면 continue
                    if (x2 >= n || x3 >= n || x4 >= n || y2 >= m || y3 >= m || y4 >= m
                            || x2 < 0 || x3 < 0 || x4 < 0 || y2 < 0 || y3 < 0 || y4 < 0) continue;

                    int sum = map[x][y] + map[x2][y2] + map[x3][y3] + map[x4][y4];
                    if (sum > answer) answer = sum;
                }
            }
        }
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
