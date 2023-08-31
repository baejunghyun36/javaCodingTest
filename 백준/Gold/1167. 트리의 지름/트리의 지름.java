import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<Node> list [];
    static int [] visited;
    static Queue<Integer> q;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        q = new LinkedList<>();
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        int size = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int edgeNum = Integer.parseInt(st.nextToken());
                if(edgeNum==-1) break;
                int dist = Integer.parseInt(st.nextToken());
                list[num].add(new Node(edgeNum, dist));
            }
            size = Math.min(size, list[num].size());
        }

        int num1 = bfs(1);
        int num2 = bfs(num1);
        answer = visited[num2];
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int x){
        int num = 0;
        visited = new int[n + 1];
        Arrays.fill(visited, -1);
        q.add(x);
        visited[x] = 0;
        int dist = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                Node node = list[cur].get(i);
                if(visited[node.num]!=-1)continue;
                visited[node.num] = visited[cur] + node.dist;
                if(dist<visited[node.num]){
                    dist = visited[node.num];
                    num = node.num;
                }
                q.add(node.num);
            }
        }
        return num;
    }

    static class Node {
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }


}