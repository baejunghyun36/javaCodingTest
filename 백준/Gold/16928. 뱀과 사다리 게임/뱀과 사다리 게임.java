import java.io.*;
import java.util.*;

public class Main {

    static Map <Integer, Integer> moveTo;
    static int n, m;
    static int [] dp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[101];
        Arrays.fill(dp, 999999999);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        moveTo = new HashMap<>();
        for(int i=0; i<n+m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            moveTo.put(from, to);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        dp[1] = 0;
        while (!q.isEmpty()) {
            int[] info = q.poll();
            int cur = info[0];
            int cnt = info[1];
            if(cur==100) break;
            for (int i = 1; i <= 6; i++) {
                int next = moveTo.getOrDefault(cur+i, cur + i);
                if(next>100||dp[next]<=cnt+1)continue;
                dp[next] = cnt + 1;
                q.add(new int[]{next, cnt + 1});
            }
        }
        sb.append(dp[100]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}