import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Node> [] list;
    static int [][] dist;
    static Set <Integer> startSet;
    static int [] visited;
    static final int INF = 987654321;
    static int minCost;
    static StringBuilder sb;
    static ArrayList<Integer> [] reverseRoute;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        minCost = INF;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        reverseRoute = new ArrayList[n + 1];
        dist = new int[n+1][n + 1];
        startSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            reverseRoute[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) startSet.add(Integer.parseInt(st.nextToken()));
        for (int start : startSet) {
            dijk(start);
        }
        int endPoint = 0;
        for (int i = 1; i <= n; i++) {
            if (!startSet.contains(i)) {
                int sum =0;
                for (int start : startSet) {
                    sum += dist[start][i];
                }
                if (minCost > sum) {
                    endPoint = i;
                    minCost = sum;
                }
            }
        }
        RouteDijk(endPoint);
        reverseRouteSearch();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void reverseRouteSearch(){
        Queue<Integer> q = new LinkedList<>();
        for (int x : startSet) q.add(x);
        ArrayList<int[]> routeList = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < reverseRoute[cur].size(); i++) {
                routeList.add(new int[]{cur, reverseRoute[cur].get(i)});
                q.add(reverseRoute[cur].get(i));
            }
        }
        sb.append(minCost).append(" ").append(routeList.size()).append("\n");
        for (int i = 0; i < routeList.size(); i++) {
            sb.append(routeList.get(i)[0] + " " + routeList.get(i)[1]).append("\n");
        }
    }


    static void RouteDijk(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start]= 0;
        visited = new int[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.vertex]==1)continue;
            visited[cur.vertex]= 1;
            for (int i = 0; i < list[cur.vertex].size(); i++) {
                Node next = list[cur.vertex].get(i);
                if (dist[next.vertex] > dist[cur.vertex] + next.cost) {
                    reverseRoute[next.vertex] = new ArrayList<>();
                    reverseRoute[next.vertex].add(cur.vertex);
                    dist[next.vertex] = dist[cur.vertex] + next.cost;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
    }

    static void dijk(int start){
        Arrays.fill(dist[start], INF);
        visited = new int[n + 1];
        dist[start][start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.vertex]==1)continue;
            visited[cur.vertex]= 1;
            for (int i = 0; i < list[cur.vertex].size(); i++) {
                Node next = list[cur.vertex].get(i);
                if (dist[start][next.vertex] > dist[start][cur.vertex] + next.cost) {
                    dist[start][next.vertex] = dist[start][cur.vertex] + next.cost;
                    pq.add(new Node(next.vertex, dist[start][next.vertex]));
                }
            }
        }
    }

    static class Node {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }

}

/*
8 12
1 2 20
2 3 8
2 4 3
2 5 3
2 6 6
3 5 2
3 6 9
4 7 5
5 6 1
5 7 7
6 8 4
7 8 6
1 4 6
* */