import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static ArrayList<Node> [] list;
    static Map <Integer, Integer> startMap;
    static int [][] dist;
    static int [] visited;
    static final int INF = 987654321;
    static int minCost = INF;
    static StringBuilder sb;
    static ArrayList<Integer> [] reverseRoute;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) startMap.put(Integer.parseInt(st.nextToken()), i);
        for (int key : startMap.keySet()) dijk(startMap.get(key), key);

        RouteDijk(findCenterPoint());
        reverseRouteSearch();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int findCenterPoint() {
        int point = 0;
        for (int i = 1; i <= n; i++) {
            if (startMap.getOrDefault(i, 0)==0) {
                int sum =0;
                for (int key : startMap.keySet()) sum += dist[startMap.get(key)][i];
                if (minCost > sum) {
                    point = i;
                    minCost = sum;
                }
            }
        }
        return point;
    }

    static void reverseRouteSearch(){
        Queue<Integer> q = new LinkedList<>();
        for (int key : startMap.keySet()) q.add(key);
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
        dist[start] = 0;
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

    static void dijk(int index, int start){
        Arrays.fill(dist[index], INF);
        dist[index][start] = 0;
        visited = new int[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.vertex]==1)continue;
            visited[cur.vertex]= 1;
            for (int i = 0; i < list[cur.vertex].size(); i++) {
                Node next = list[cur.vertex].get(i);
                if (dist[index][next.vertex] > dist[index][cur.vertex] + next.cost) {
                    dist[index][next.vertex] = dist[index][cur.vertex] + next.cost;
                    pq.add(new Node(next.vertex, dist[index][next.vertex]));
                }
            }
        }
    }

    static void init(){
        sb = new StringBuilder();
        list = new ArrayList[n + 1];
        reverseRoute = new ArrayList[n + 1];
        dist = new int[3][n + 1];
        startMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            reverseRoute[i] = new ArrayList<>();
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
