import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List <Edge> [] graph;
    static Set <Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        int[] fromH = new int[n + 1];
        int[] fromS = new int[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(new Edge(b, 1));
            graph[b].add(new Edge(a, 1));
        }
        dijk(c, s, fromS);
        dijk(c, h, fromH);
        long answer = routeCheck(fromS, fromH, s, h, c);
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static long routeCheck(int[] fromS, int[] fromH, int s, int h, int c) {
        ArrayList<Integer> temp = new ArrayList<>();
        while (s != c) {
            temp.add(s);
            s = fromS[s];
        }
        temp.add(c);
        ArrayList<Integer> temp2 = new ArrayList<>();
        while (h != c) {
            temp2.add(h);
            h = fromH[h];
        }
        for (int i = temp2.size() - 1; i >= 0; i--) {
            temp.add(temp2.get(i));
        }

        Map<Integer, Integer> indexOfVertex = new HashMap<>();
        for (int i = 0; i < temp.size(); i++) {
            indexOfVertex.put(temp.get(i), indexOfVertex.getOrDefault(temp.get(i), 0) + 1);
        }
        long answer = 0;
        //1 2 3 5 3 4
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < temp.size(); i++) {
            if(!visited.contains(temp.get(i))) answer+= indexOfVertex.size() - 1;
            indexOfVertex.put(temp.get(i), indexOfVertex.getOrDefault(temp.get(i), 0) - 1);
            if(indexOfVertex.get(temp.get(i))==0) indexOfVertex.remove(temp.get(i));
            visited.add(temp.get(i));
        }
        return answer;
    }

    static void dijk(int start, int endPoint, int [] from){

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        int [] dist = new int[n+1];
        Arrays.fill(dist, 1000000);
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.vertex == endPoint) {
                return;
            }
            if(dist[cur.vertex] < cur.dist) continue;
            for (Edge next : graph[cur.vertex]) {
                if (dist[next.vertex] > dist[cur.vertex] + next.dist) {
                    from[next.vertex] = cur.vertex;
                    dist[next.vertex] = dist[cur.vertex] + next.dist;
                    pq.add(new Edge(next.vertex, dist[next.vertex]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge>{

        int vertex;
        int dist;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.dist = cost;
        }

        public int compareTo(Edge edge) {
            return this.dist - edge.dist;
        }
    }
}