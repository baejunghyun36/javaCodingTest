import java.io.*;
import java.util.*;

public class Main {

    static int n, m, r;
    static int[] scoreOfVertex;
    static int[][] pointToPoint;
    static final int INF = 987654321;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        scoreOfVertex = new int[n + 1];
        pointToPoint = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) scoreOfVertex[i] = Integer.parseInt(st.nextToken());
        for (int i=1; i<=n; i++) Arrays.fill(pointToPoint[i], INF);

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            pointToPoint[a][b] = pointToPoint[b][a] = dist;
        }

        floyd();
        output();
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void output(){
        for (int i = 1; i <= n; i++) {
            int sum = scoreOfVertex[i];
            for (int j = 1; j <= n; j++) {
                if(i!=j&&pointToPoint[i][j]<=m)sum+=scoreOfVertex[j];;
            }
            answer = Math.max(answer, sum);
        }
    }

    static void floyd(){

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (pointToPoint[i][j] > pointToPoint[i][k] + pointToPoint[k][j]) {
                        pointToPoint[i][j] = pointToPoint[i][k] + pointToPoint[k][j];
                    }
                }
            }
        }
    }
}