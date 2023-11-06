import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int [][] maxArr, minArr, parent;
    static int [] depth, visited;
    static int maxDepth;
    static ArrayList<int []> []list;
    static int [] answer;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        answer = new int[2];
        int offset = 0;
        while ((1<<(offset++)) < n) {
            maxDepth++;
        }
//        System.out.println(maxDepth);
        maxArr = new int[maxDepth][n + 1];
        minArr = new int[maxDepth][n + 1];
        parent = new int[maxDepth][n + 1];
        depth = new int[n + 1];
        visited = new int[n + 1];
        for (int i = 0; i < maxDepth; i++) {
            Arrays.fill(minArr[i], INF);
        }

        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }
        depth[1] = 0;
        dfs(1, 1);
        initTree();

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            LCA(a, b);
            sb.append(answer[0]).append(" ").append(answer[1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void LCA(int a, int b){

        int minNumber = INF;
        int maxNumber = -INF;

//        System.out.println(depth[a]+" "+ depth[b]);
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
//        System.out.println("-------------");
//        System.out.println(a+" " + b + " "+maxNumber+" "+ minNumber);

        for (int i = maxDepth-1; i >= 0; i--) {
            if (depth[a] - Math.pow(2, i) >= depth[b]) {
                maxNumber = Math.max(maxNumber, maxArr[i][a]);
                minNumber = Math.min(minNumber, minArr[i][a]);
                a = parent[i][a];
            }
        }
        if (a == b) {
            answer[0] = minNumber;
            answer[1] = maxNumber;
            return;
        }
//        System.out.println(a+" " + b + " "+maxNumber+" "+ minNumber);

        for (int i = maxDepth - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                maxNumber = Math.max(maxNumber, Math.max(maxArr[i][a], maxArr[i][b]));
                minNumber = Math.min(minNumber, Math.min(minArr[i][a], minArr[i][b]));
                a = parent[i][a];
                b = parent[i][b];

            }
        }
        maxNumber = Math.max(maxNumber, Math.max(maxArr[0][a], maxArr[0][b]));
        minNumber = Math.min(minNumber, Math.min(minArr[0][a], minArr[0][b]));

        answer[0] = minNumber;
        answer[1] = maxNumber;
    }



    static void initTree() {

        for (int i = 1; i < maxDepth; i++) {
            for (int j = 1; j <= n; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
        for (int i = 1; i < maxDepth; i++) {
            for (int j = 1; j <= n; j++) {
                maxArr[i][j] = Math.max(maxArr[i - 1][j], maxArr[i - 1][parent[i - 1][j]]);
            }
        }
        for (int i = 1; i < maxDepth; i++) {
            for (int j = 1; j <= n; j++) {
                minArr[i][j] = Math.min(minArr[i - 1][j], minArr[i - 1][parent[i - 1][j]]);
            }
        }
//
//        for (int i = 0; i < maxDepth; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(maxArr[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for (int i = 0; i < maxDepth; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(minArr[i][j]+" ");
//            }
//            System.out.println();
//        }
    }

    static void dfs(int level, int cur) {
        visited[cur] = 1;
        for (int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i)[0];
            int cost = list[cur].get(i)[1];
            if (visited[next] == 0) {
                depth[next] = level;
                parent[0][next] = cur;
                maxArr[0][next] = minArr[0][next] = cost;
                dfs(level + 1, next);
            }
        }
    }
}


/*
8
1 2 11
1 3 10
2 4 4
3 5 7
4 6 1
6 7 3
7 8 2
2
8 5
1 3
* */