import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) q.add(i + 1);
        
        while (true) {
            sb.append(q.poll()+" ");
            if(q.isEmpty())break;
            q.add(q.poll());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}