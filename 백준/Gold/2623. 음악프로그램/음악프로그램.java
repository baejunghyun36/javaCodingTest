import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> [] list;
    static int []indegree;
    static int n, m;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        indegree = new int[n+1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int before = start;
            for(int j=1; j<num; j++){
                int next = Integer.parseInt(st.nextToken());
                list[before].add(next);
                indegree[next]++;
                before = next;
            }

        }

        if(topologicalSort()){
            for (int x : answer) {
                sb.append(x + "\n");
            }

        } else sb.append(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean topologicalSort(){

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++){
            if(indegree[i]==0) q.add(i);
        }

        while (!q.isEmpty()) {

            int vertex = q.poll();
            answer.add(vertex);
            for (int i = 0; i < list[vertex].size(); i++) {
                int next = list[vertex].get(i);
                if(--indegree[next]==0) q.add(next);
            }
        }

        if(answer.size()==n) return true;
        return false;

    }
}