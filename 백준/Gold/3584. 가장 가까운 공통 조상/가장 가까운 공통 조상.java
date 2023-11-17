import java.io.*;
import java.util.*;

public class Main {

    static int testCase, n;
    static int [] depth, parent, visited;
    static ArrayList<Integer> [] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {

            n = Integer.parseInt(br.readLine());
            init();
            for (int i = 0; i < n-1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                parent[b] = a;
            }
            int root = findRoot();

            initDepth(root, 0);
            st = new StringTokenizer(br.readLine());

            int answer = findParent(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int findParent(int a, int b) {

        while (depth[a] != depth[b]) {
            if(depth[a] < depth[b]) b = parent[b];
            else a = parent[a];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
    
    static void initDepth(int cur, int level) {
        visited[cur] = 1;
        depth[cur] = level;
        for (int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i);
            if (visited[next] == 0) {
                initDepth(next, level + 1);
            }
        }
    }

    static int findRoot(){
        for (int i = 1; i <= n; i++) {
            if(parent[i]==0)return i;
        }
        return 0;
    }

    static void init(){
        depth = new int[n + 1];
        parent = new int[n + 1];
        visited = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
    }
}