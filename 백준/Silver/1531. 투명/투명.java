import java.io.*;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[101][101];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j <= y2; j++) {
                for (int k = x1; k <= x2; k++) {
                    map[j][k]++;
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if (map[i][j] > m) {
                    answer++;
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