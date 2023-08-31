import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> list[];
    static int n, k, testCase, endOfBuilding;
    static int [] indegree, accumulate, timeToBuild;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());
        while (testCase-->0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            timeToBuild = new int[n + 1];
            accumulate = new int[n + 1];
            indegree = new int[n + 1];
            list = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) timeToBuild[i] = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                indegree[b] ++;
            }
            endOfBuilding = Integer.parseInt(br.readLine());
            topologySort();
            sb.append(accumulate[endOfBuilding]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void topologySort(){

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) if(indegree[i]==0) {
            accumulate[i] = timeToBuild[i];
            q.add(i);
        }
        while (!q.isEmpty()) {
            int numOfBuilding = q.poll();
            int secondOfBuilding = accumulate[numOfBuilding];
            for (int i = 0; i < list[numOfBuilding].size(); i++) {
                int next = list[numOfBuilding].get(i);
                accumulate[next] = Math.max(timeToBuild[next] + secondOfBuilding, accumulate[next]);
                indegree[next]--;
                if(indegree[next]==0) q.add(list[numOfBuilding].get(i));
            }
        }

    }
}