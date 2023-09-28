import java.io.*;
import java.util.*;

public class Main {

    static int [] visited;
    static Queue<Integer> q;
    static int [] reverseIndex;
    static int n, k, second;
    static ArrayList<Integer> seq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        init();

        out:while (!q.isEmpty()) {
            int size = q.size();
            second++;
            while (size-- > 0) {
                int cur = q.poll();
                if(cur==k){
                    sb.append(second-1).append("\n");
                    while(cur!=n){
                        seq.add(cur);
                        cur = reverseIndex[cur];
                    }
                    seq.add(cur);
                    break out;
                }
                insert(cur+1, second, cur);
                insert(cur-1, second, cur);
                insert(cur*2, second, cur);
            }

        }

        for(int i=seq.size()-1; i>=0; i--) sb.append(seq.get(i)).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void insert(int next, int second, int prev){
        if(next<0||next>200000||visited[next]<second)return;
        visited[next] = second;
        reverseIndex[next] = prev;
        q.add(next);
    }

    static void init(){

        visited = new int[200001];
        reverseIndex = new int[200001];
        Arrays.fill(visited, 999999);
        visited[n] = 0;
        q = new LinkedList<>();
        seq = new ArrayList<>();
        q.add(n);
    }
}