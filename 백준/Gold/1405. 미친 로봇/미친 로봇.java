import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int [][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Integer> dirList;
    static double [] percent;
    static double testCase = 1;
    static int isSimple;
    static double answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dirList = new ArrayList<>();
        percent = new double[4];
        for (int i = 0; i < 4; i++) {
            double d = Double.parseDouble(st.nextToken());
            percent [i] = 0.01*d;
        }

        visited = new int[100][100];
        for (int i = 0; i < n; i++) testCase*=4;
        visited[50][50] = 1;
        bruteForce(0,50, 50, 1);
        System.out.println(answer);
        bw.flush();
        bw.close();
        br.close();
    }

    static void bruteForce(int level, int y, int x, double p) {

        if (level == n) {
            answer+=p;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(percent[i]==0)continue;
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if(visited[ny][nx]==1) continue;
            visited[ny][nx] = 1;
            bruteForce(level+1, ny, nx, p*percent[i]);
            visited[ny][nx] = 0;
        }
    }
}