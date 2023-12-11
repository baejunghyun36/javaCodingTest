import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Set<String> cmp = new HashSet<>();
        for (int i = 0; i < n; i++) {
            cmp.add(br.readLine());
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (cmp.contains(br.readLine())) {
                cnt++;
            }
        }
        sb.append(cnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}