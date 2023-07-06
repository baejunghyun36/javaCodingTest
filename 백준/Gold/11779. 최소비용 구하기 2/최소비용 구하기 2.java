import java.io.*;
import java.util.*;

public class Main {


    static int [] visited;
    static int [] dist;
    static int n, m;
    static final int INF = 987654321;
    static int pointOfStart, pointOfEnd;
    static ArrayList<Node> [] list;
    static PriorityQueue<Node> q;
    static int [] route;
    static ArrayList<Integer> routeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new int[n+1];
        dist = new int[n+1];
        list = new ArrayList[n+1];
        route = new int[n + 1];

        for(int i=1; i<=n; i++) list[i] = new ArrayList<>();
        q = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        StringTokenizer st = null;
        Arrays.fill(dist, INF);

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        pointOfStart = Integer.parseInt(st.nextToken());
        pointOfEnd = Integer.parseInt(st.nextToken());

        q.add(new Node(pointOfStart, 0));
        dist[pointOfStart] = 0;
        route[pointOfStart] = 0;

        dij();
        sb.append(dist[pointOfEnd]).append("\n");

        routeList = new ArrayList<>();
        int index = pointOfEnd;
        while(index!=0){
            routeList.add(index);
            index = route[index];
        }
 

        sb.append(routeList.size()).append("\n");
        for (int i = routeList.size()-1; i >=0; i--) {
            sb.append(routeList.get(i)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dij(){

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(visited[cur.vertex]==1)continue;
            visited[cur.vertex] = 1;
            for(int i=0; i<list[cur.vertex].size(); i++){
                Node next = list[cur.vertex].get(i);
                if(dist[next.vertex]>dist[cur.vertex]+next.cost){
                    dist[next.vertex] = dist[cur.vertex] + next.cost;
                    q.add(new Node(next.vertex, dist[next.vertex]));
                    route[next.vertex] = cur.vertex;
                }
            }
        }
    }

    static class Node {


        int vertex;
        int cost;

        public Node(int to, int cost) {

            this.vertex = to;
            this.cost = cost;
        }

    }
}