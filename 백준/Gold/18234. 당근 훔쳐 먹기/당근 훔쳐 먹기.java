import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, t;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken())-1;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            pq.add(new int[]{w, p});
        }
        
        long answer = 0;
        while (n-- > 0) answer += (long)pq.peek()[1] * (t--) + pq.poll()[0];
        System.out.println(answer);
    }
}