import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[][] relationship = new boolean[N + 1][N + 1];
        int[] friendCounts = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            relationship[first][second] = true;
            relationship[second][first] = true;
            friendCounts[first]++;
            friendCounts[second]++;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (relationship[i][j]) {
                    for (int k = j + 1; k <= N; k++) {
                        if (relationship[i][k] && relationship[j][k]) {
                            result = Math.min(result, friendCounts[i] + friendCounts[j] + friendCounts[k] - 6);
                        }
                    }
                }
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
        br.close();
    }
}