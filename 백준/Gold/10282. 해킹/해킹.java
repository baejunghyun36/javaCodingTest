import java.io.*;
import java.util.*;

public class Main {

    static int testCase;
    static int n, d, c, a, b, s;
    static int [] cost, visited;
    static ArrayList<Computer> [] list;
    static PriorityQueue<Computer> pq;
    static final int INF = 987654321;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        testCase = Integer.parseInt(st.nextToken());

        while (testCase-- > 0) {

            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            init();

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                list[b].add(new Computer(a, s));
            }

            dijk();
            output();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }



    static void dijk(){

        pq.add(new Computer(c, 0));
        cost[c] = 0;

        while (!pq.isEmpty()) {
            Computer cur = pq.poll();
            if(visited[cur.vertex]==1)continue;
            visited[cur.vertex] = 1;
            for (int i = 0; i < list[cur.vertex].size(); i++) {
                Computer next = list[cur.vertex].get(i);
                if(cost[next.vertex] > cost[cur.vertex] + next.cost){
                    cost[next.vertex] = cost[cur.vertex] + next.cost;
                    pq.add(new Computer(next.vertex, cost[next.vertex]));
                }
            }
        }
    }

    static class Computer {

        int vertex;
        int cost;

        public Computer(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

    static void output(){

        int cnt = 0;
        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if(cost[i]!=INF)cnt++;
            if(cost[i]!=INF) maxTime = Math.max(maxTime, cost[i]);
        }

        sb.append(cnt + " " + maxTime).append("\n");
    }

    static void init(){

        pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        list = new ArrayList[n + 1];
        visited = new int[n + 1];
        cost = new int[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        Arrays.fill(cost, INF);
    }
}