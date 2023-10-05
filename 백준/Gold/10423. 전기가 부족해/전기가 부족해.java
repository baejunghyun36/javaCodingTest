import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Node> list [];
    static int n, m, k;
    static PriorityQueue<Node> pq;
    static int answer;
    static int [] visited;
    static int visitedCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visitedCount = k;
        list = new ArrayList[n + 1];
        visited = new int[n + 1];
        pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> powerPlants = new ArrayList<>();

        for (int i = 0; i < k; i++) powerPlants.add(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));

        }

        for (int i = 0; i < powerPlants.size(); i++) {
            int number = powerPlants.get(i);
            visited[number] = 1;
            for (int j = 0; j < list[number].size(); j++) pq.add(list[number].get(j));
        }

        solution();

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void solution(){

        while (!pq.isEmpty()&&visitedCount<n) {
            Node next = pq.poll();
            int number = next.vertex;
            if(visited[number]==1)continue;
            visited[number]=1;
            answer+= next.cost;
            visitedCount++;
            for (int i = 0; i < list[number].size(); i++) {
                if(visited[list[number].get(i).vertex]==0) {
                    pq.add(list[number].get(i));
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