import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int [][] updatedDist;
    static Map <Integer, ArrayList<Integer>> groupOfBoss;
    static int [] parent;
    static ArrayList<Integer> minBossNumberList;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        initParent();
        minBossNumberList = new ArrayList<>();
        groupOfBoss = new HashMap<>();
        updatedDist = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(updatedDist[i], INF);
            updatedDist[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a<b) union(a, b);
            else union(b, a);
            updatedDist[a][b] = updatedDist[b][a] = 1;
        }
        initGroupOfBoss();
        initFloydWarshall();
        selectBossOfGroup();
        sb.append(k).append("\n");
        for (int i = 0; i < minBossNumberList.size(); i++) {
            sb.append(minBossNumberList.get(i)).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void selectBossOfGroup(){

        for(int key : groupOfBoss.keySet()){
            int maxCost = INF;
            int bossNumber = -1;
            ArrayList<Integer> subsetList = groupOfBoss.get(key);
            for (int i = 0; i < subsetList.size(); i++) {
                int a = subsetList.get(i);
                int cost = 0;
                for (int j = 0; j < subsetList.size(); j++) {
                    int b = subsetList.get(j);
                    if(a==b)continue;
                    cost = Math.max(cost, updatedDist[a][b]);
                }
                if(maxCost>cost){
                    maxCost = cost;
                    bossNumber = a;
                }
            }
            minBossNumberList.add(bossNumber);
        }
        k = groupOfBoss.size();
        Collections.sort(minBossNumberList);
    }

    static void initFloydWarshall() {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (updatedDist[i][j] > updatedDist[i][k] + updatedDist[k][j]) {
                        updatedDist[i][j] = updatedDist[i][k] + updatedDist[k][j];
                    }
                }
            }
        }
    }

    static void initGroupOfBoss() {
        for (int i = 1; i <= n; i++) {
            int root = find(i);
            groupOfBoss.putIfAbsent(root, new ArrayList<>());
            groupOfBoss.get(root).add(i);
        }
    }

    static int find(int cur) {
        if(parent[cur]==cur) return cur;
        return parent[cur] = find(parent[cur]);
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa!=pb) parent[pb] = pa;
        return;
    }

    static void initParent(){
        parent = new int[n + 1];
        for(int i=1; i<=n; i++) parent[i] = i;
    }
}



/*
input
8
7
1 2
2 3
4 5
5 6
4 6
6 7
7 4

output
3
2
4
8
* */