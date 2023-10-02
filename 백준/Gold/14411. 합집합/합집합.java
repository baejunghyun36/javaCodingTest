import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<int [] > pq = new PriorityQueue<>((o1, o2)-> {
            if(o1[0]==o2[0])return o2[1] - o1[1];
            return o2[0] - o1[0];
        });

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int x = pq.peek()[0];
        int y = pq.peek()[1];
        long area = (long)x*y;

        while (!pq.isEmpty()) {
            while(!pq.isEmpty()&&pq.peek()[1]<=y) pq.poll();
            if(pq.isEmpty())break;
            area += (long)(pq.peek()[1]-y)*pq.peek()[0];
            y = pq.poll()[1];
        }

        sb.append(area);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}