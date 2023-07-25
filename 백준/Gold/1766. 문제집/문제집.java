import java.io.*;
import java.util.*;

public class Main {


    static int n, m;
    static int [] indegree;
    static ArrayList<Integer> answer;
    static ArrayList<Integer> [] list;
    static int [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        indegree = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            indegree[b]++;
        }
        answer = new ArrayList<>();
        visited = new int[n + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<=n; i++){
            if(indegree[i]==0) pq.add(i);
        }
        while (!pq.isEmpty()) {
            int number = pq.poll();
            answer.add(number);
            for(int i=0; i<list[number].size(); i++){
                int cur = list[number].get(i);
                if(--indegree[cur]==0) {
                    pq.add(cur);
                }
            }
        }

        for (int x : answer) {
            sb.append(x + " ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}