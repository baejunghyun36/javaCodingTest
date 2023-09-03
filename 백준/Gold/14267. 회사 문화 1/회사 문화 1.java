import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int [] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> []relations =new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) relations[i] = new ArrayList<>();
        info = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= n; i++) relations[Integer.parseInt(st.nextToken())].add(i);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            info[index] += weight;
        }
        int[] answer = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            answer[i] += info[i];
            for (int j = 0; j < relations[i].size(); j++) answer[relations[i].get(j)] += answer[i];
        }
        for (int i = 1; i <= n; i++) sb.append(answer[i] + " ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


}