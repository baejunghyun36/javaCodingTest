import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for(int i=1; i<=n; i++) parent[i] = i;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if(find(i)==1)cnt++;
        }
        sb.append(cnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int a) {
        if(parent[a]==a)return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a!=b) {
            if(a<b)parent[b] = a;
            else parent[a] = b;

        }
    }

}