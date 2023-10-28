import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int start, end;
    static ArrayList<int[] > [] list;
    static int [] cost;
    static int [] visited;
    static PriorityQueue<int [] > pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>((o1, o2) -> o2[1] -o1[1]);
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        cost = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        visited = new int[n + 1];
        visited[start] = 1;
        for (int i = 0; i < list[start].size(); i++) {
            cost[list[start].get(i)[0]] = list[start].get(i)[1];
            pq.add(new int[]{list[start].get(i)[0], list[start].get(i)[1]});
        }
        dijk();
        sb.append(cost[end]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijk(){

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int cur = info[0];
            int c = info[1];
            if(visited[cur]==1)continue;
            visited[cur] = 1;
            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i)[0];
                int nextCost = list[cur].get(i)[1];
                if (cost[next] < Math.min(c, nextCost)) {
                    cost[next] = Math.min(c, nextCost);
                    pq.add(new int[]{next, cost[next]});
                }
            }
        }
    }
/*
4 5
1 3 2
1 2 100
2 3 101
2 4 100
3 4 50
1 4
*
*
* */

}