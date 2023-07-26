import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static double answer;
    static Star[] starList;
    static PriorityQueue<EdgeCost> pq ;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        pq = new PriorityQueue<>();
        n = Integer.parseInt(st.nextToken());
        starList = new Star[n];
        parent = new int[n];
        initParent();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            starList[i] = new Star(a, b);
        }
        for(int i=0; i<n-1; i++){
            Star starA = starList[i];
            for (int j = i + 1; j < n; j++) {
                Star starB = starList[j];
                double cost = Math.sqrt(Math.pow(Math.abs(starB.y - starA.y),2)+Math.pow(Math.abs(starB.x - starA.x), 2));
                pq.add(new EdgeCost(i, j, cost));
            }
        }
        while (!pq.isEmpty()) {
            EdgeCost e = pq.poll();
            union(e.from, e.to, e.cost);
        }

        System.out.printf("%.2f", answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static int find(int a){

        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b, double cost){

        int parentA = find(a);
        int parentB = find(b);
        
        if(parentA != parentB){
            parent[parentB] = parentA;
            answer += cost;
        }
    }

    static void initParent (){

        for(int i=0; i<n; i++){
            parent[i] = i;
        }
    }


    static class Star {

        double y;
        double x;

        public Star(double y, double x){
            this.y = y;
            this.x = x;
        }
    }

    static class EdgeCost implements Comparable<EdgeCost> {
        
        int from;
        int to;
        double cost;

        public EdgeCost(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(EdgeCost e) {

            return Double.compare(this.cost , e.cost);
        }
    }
}