import java.io.*;
import java.util.*;

public class Main {


    static int n, m;
    static double answer;
    static List<long[]> list;
    static List<int[]> distInfo;
    static int [] parent;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        list.add(new long[]{0, 0});
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new long[]{y, x});
        }
       init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a<b) union(a, b, 0);
            else union(b, a, 0);
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int a = node.from;
            int b = node.to;

            if(a<=b)union(a, b, node.dist);
            else union(b, a, node.dist);
        }
        System.out.printf("%.2f", answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void init(){
        parent = new int[n + 1];
        for(int i=1; i<=n; i++)parent[i] = i;
        pq = new PriorityQueue<>();
        for (int i = 1; i < list.size(); i++) {
            long[] from = list.get(i);
            for (int j = 1; j < list.size(); j++) {
                if(i==j)continue;
                long[] to = list.get(j);
                pq.add(new Node(i, j, Math.sqrt(Math.pow(Math.abs(from[0] - to[0]),2) + Math.pow(Math.abs(from[1] - to[1]),2) )));
            }
        }
    }

    static int find(int a) {
        if(parent[a]==a)return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b, double dist){
        int pa = find(a);
        int pb = find(b);
        if(pa==pb) return;
        parent[pb] = pa;
        answer+= dist;
    }

    static class Node implements Comparable<Node>{

        int from;
        int to;
        double dist;

        public Node(int from, int to, double dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        public int compareTo(Node node){
            return Double.compare(this.dist, node.dist);
        }

    }
}