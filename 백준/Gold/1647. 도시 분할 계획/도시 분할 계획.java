import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int [] parent;
    static int maxNumber;
    static PriorityQueue<Node> pq;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();
        parent = new int[n + 1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, c));
        }

        initParent();
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            union(node.a, node.b, node.cost);
        }
        
        answer-=maxNumber;
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static void union(int a, int b, int cost){

        int parentA = find(a);
        int parentB = find(b);

        if(parentA != parentB) {
            parent[parentB] = parentA;
            answer+=cost;
            maxNumber = cost;
        }
    }



    static int find(int a){

        if(a==parent[a])return a;
        return parent[a] = find(parent[a]);
    }



    static void initParent(){
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
    }

    static class Node implements Comparable<Node>{

        int a;
        int b;
        int cost;

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        public int compareTo(Node node){
            return this.cost - node.cost;
        }

    }


}