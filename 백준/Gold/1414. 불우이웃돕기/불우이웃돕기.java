import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static PriorityQueue<Cable> pq;
    static int [] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        initParent();
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') pq.add(new Cable(i, j, c - 96));
                if (c >= 'A' && c <= 'Z') pq.add(new Cable(i, j, c - 38));
            }
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            Cable cable = pq.poll();
            if (union(cable.from, cable.to)) {
                answer += cable.length;
            }
        }

        int root = find(0);
        for (int i = 1; i < n; i++) {
            if(root!=find(i))answer = -1;
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void initParent(){

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i]= i;
        }
    }
    static int find(int a){

        if(parent[a]==a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b) {

        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return true;
        if(pa < pb) parent[pb] = pa;
        else parent[pa] = pb;
        return false;
    }

    static class Cable implements Comparable<Cable> {

        int from;
        int to;
        int length;

        public Cable(int from, int to, int length) {

            this.from = from;
            this.to = to;
            this.length = length;
        }

        public int compareTo(Cable cable) {
            return this.length - cable.length;
        }
    }

}