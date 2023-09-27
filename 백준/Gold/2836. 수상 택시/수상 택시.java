import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static long n, m, answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        m = Long.parseLong(st.nextToken());

        PriorityQueue<int []> pq = new PriorityQueue<>((o1, o2)-> {
            if(o1[1]==o2[1]) return o2[0] - o1[0];
            return o1[1] - o2[1];
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a>b) pq.add(new int[]{a, b});
        }
        answer = m;
        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            long start = info[0];
            long end = info[1];
            while(!pq.isEmpty()&&end<=pq.peek()[1]&&start>=pq.peek()[1]) {
                if(start<pq.peek()[0])start = pq.peek()[0];
                pq.poll();
            }
            answer += (start - end) * 2;
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
