import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k, K;
    static PriorityQueue<Friend> q;
    static int [] visited;
    static List<Integer> [] relations;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        K = k = Integer.parseInt(st.nextToken());

        relations = new ArrayList[n + 1];
        visited = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        q = new PriorityQueue<>();
        for (int i = 1; i <= n; i++)  relations[i] = new ArrayList<>();
        for(int i=0; i<n; i++) q.add(new Friend(i + 1, Integer.parseInt(st.nextToken())));

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations[a].add(b);
            relations[b].add(a);
        }

        String answer = "Oh no";

        while (!q.isEmpty()) {
            Friend f = q.poll();
            if(visited[f.number]==1)continue;
            if(k-f.cost<0) break;
            k-=f.cost;
            friendCheck(f.number);
            if(count==n){
                answer = String.valueOf(K-k);
                break;
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void friendCheck(int number){

        visited[number] = 1;
        count++;
        for(int i=0; i<relations[number].size(); i++){
            if(visited[relations[number].get(i)]==1)continue;
            friendCheck(relations[number].get(i));
        }
    }

    static class Friend implements Comparable<Friend>{

        int number;
        int cost;

        public Friend(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }

        public int compareTo(Friend freind){
            return this.cost - freind.cost;
        }
    }
}