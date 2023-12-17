import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Integer>[] list;
    static int [] seq;
    static int [] visited;
    static final int INF = 2000000000;
    static int answer = INF;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[3];
        visited = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list[first].add(second);
            list[second].add(first);
        }
        for (int i = 1; i <= N; i++) list[0].add(i);
        dfs(0, 0, 0);
        if(answer == INF) System.out.println(-1);
        else System.out.println(answer);

    }

    static void dfs(int cur, int cnt, int end) {

        for (int next : list[cur]) {
            if(cnt==3&&next==end)check();
            if(visited[next]==1||cnt==3)continue;
            visited[next] = 1;
            seq[cnt] = next;
            if(cnt==0)dfs(next, cnt + 1, next);
            else dfs(next, cnt+1, end);
            visited[next] = 0;
        }
    }

    static void check(){

        int sum = 0;
        for (int i = 0; i < 3; i++) {
            int cur = seq[i];
            for (int f : list[cur]) {
                if (f != seq[0] && f != seq[1] && f != seq[2]) {
                    sum++;
                }
            }
        }
        answer = Math.min(answer, sum);
    }
}