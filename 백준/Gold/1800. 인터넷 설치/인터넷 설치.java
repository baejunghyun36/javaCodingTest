import java.io.*;
import java.util.*;

public class Main {

    static int n, p, k;
    static ArrayList<Node> [] list;
    static PriorityQueue<Node> pq;
    static int [] dist;
    static final int INF = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        sb.append(binarySearch());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean dijk(int cmp){
        Arrays.fill(dist, INF);
        dist[1] = 0;
        pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(1, 0));
        int[] visited = new int[n + 1];
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.vertex == n) {
                return true;
            }
            if(visited[cur.vertex]==1)continue;
            visited[cur.vertex] = 1;
            for (int i = 0; i < list[cur.vertex].size(); i++) {
                Node next = list[cur.vertex].get(i);
                if (cmp >= next.cost) {
//                    if(cmp==4) System.out.println("cur : " + cur.vertex+" next.vertex :  " +next.vertex+ " " + cur.cnt);
                    pq.add(new Node(next.vertex, cur.cost));
                } else if (cur.cost < k) {
//                        if(cmp==4) System.out.println("cmp " +next.vertex);
                    pq.add(new Node(next.vertex, cur.cost + 1));
                }
            }
        }

//        System.out.println();
//        if(dist[n]!=INF)return true;
        return false;
    }

    static int binarySearch() {

        int l = 0;
        int h = INF - 1;
        int answer = -1;
        while (l <= h) {
            int mid = (l+h)/2;
            if(dijk(mid)) {
                answer = mid;

                h = mid - 1;
            }
            else l = mid + 1;
        }
        return answer;
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