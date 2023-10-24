import java.io.*;
import java.util.*;

public class Main {

    static int n, r1, r2;
    static List<int[]>[] list;
    static int answer = 2000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        int []dist1 = new int[n + 1];
        int []dist2 = new int[n + 1];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        dfs(r1, 0, dist1);
        dfs(r2, 0, dist2);

        output(dist1, dist2);
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur, int d, int[] dist) {
        if(dist[cur]!=-1) return;
        dist[cur] = d;
        for (int i = 0; i < list[cur].size(); i++) {
            dfs(list[cur].get(i)[0], d + list[cur].get(i)[1], dist);
        }
    }

    static void output(int[] dist1, int[] dist2) {

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dist1[i] + dist2[i]);
            for (int j = 0; j < list[i].size(); j++) {
                answer = Math.min(answer, dist1[i] + dist2[list[i].get(j)[0]]);
            }
        }
    }
}