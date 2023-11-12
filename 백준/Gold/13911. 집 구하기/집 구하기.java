import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Node> pq;
    static int n, e;
    static int m, x, s, y;
    static ArrayList<Integer> mList, sList;
    static ArrayList <Node> [] list;
    static final int INF = 1000000001;
    static int [] mDist, sDist;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        mList = new ArrayList<>();
        sList = new ArrayList<>();
        set = new HashSet<>();
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        pq = new PriorityQueue<>();

        mDist = new int[n + 1];
        Arrays.fill(mDist, INF);

        for (int i = 0; i < m; i++) {
            mList.add(Integer.parseInt(st.nextToken()));
            mDist[mList.get(i)]= 0;
            set.add(mList.get(i));
            pq.add(new Node(mList.get(i), 0));
        }
        dijk(x, mDist);

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        sDist = new int[n + 1];
        Arrays.fill(sDist, INF);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            sList.add(Integer.parseInt(st.nextToken()));
            sDist[sList.get(i)]= 0;
            set.add(sList.get(i));
            pq.add(new Node(sList.get(i), 0));
        }
        dijk(y, sDist);
        int answer = INF;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                if (mDist[i] <= x && sDist[i] <= y) {
                    answer = Math.min(mDist[i] + sDist[i], answer);
                }
            }
        }
        if(answer==INF) answer = -1;
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijk(int threshold, int [] dist){
        int[] visited = new int[n + 1];
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(visited[cur.vertex]==1)continue;
            visited[cur.vertex] = 1;
            for (int i = 0; i < list[cur.vertex].size(); i++) {
                Node next = list[cur.vertex].get(i);
                if (dist[next.vertex] > dist[cur.vertex] + next.cost && dist[cur.vertex] + next.cost <= threshold) {
                    dist[next.vertex] = dist[cur.vertex] + next.cost;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
    }


    static class Node implements Comparable<Node>{
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

}