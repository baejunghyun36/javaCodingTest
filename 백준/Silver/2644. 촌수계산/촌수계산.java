import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int p1, p2;
    static List <Integer> [] list;
    static int [] visited;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        dfs(p1, 0);
        if(answer==0) answer = -1;
        sb.append(answer);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur, int cnt){
        if(cur==p2) {
            answer = cnt;
            return;
        }
        if(visited[cur]==1)return;
        visited[cur] = 1;
        for(int next : list[cur]){
            dfs(next, cnt+1);
        }
    }
}