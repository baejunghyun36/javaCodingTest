import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> [] list;
    static int n, k, m;
    static Queue<Integer> q;

    static int [] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] temp = new int[k];
        dist = new int[n + 2 + m];
        q = new LinkedList<>();
        list = new ArrayList[n + m+2];
        for (int i = 1; i <= n+m+1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int a = Integer.parseInt(st.nextToken());
                list[a].add(i + n + 1);
                list[i + n + 1].add(a);
            }
        }
        dist[1] = 1;
        q.add(1);
        sb.append(bfs());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {

                int cur = q.poll();
                if(cur==n)return dist[n];
                for (int a : list[cur]) {
                    if (dist[a] == 0) {
                        if (a >= n + 1) {
                            dist[a] = dist[cur];
                        }
                        else{
                            dist[a] = dist[cur]+1;
                        }
                        q.add(a);
                    }
                }
            }
        }
        return -1;
    }
}