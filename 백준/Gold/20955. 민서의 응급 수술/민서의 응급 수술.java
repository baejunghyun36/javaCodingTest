import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static Set <Integer> set;
    static int[] parent;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        initParent();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            findUnion(a, b);
        }
        set = new HashSet<>();
        for (int i = 1; i <= n; i++) set.add(find(i));
        sb.append(answer+set.size()-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void initParent(){

        for(int i=1; i<=n; i++)parent[i] = i;
    }

    static int find(int cur) {

        if(parent[cur]== cur) return cur;
        return parent[cur] = find(parent[cur]);
    }

    static void findUnion(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);
        if(parentA == parentB) answer++;
        else parent[parentB] = parentA;
    }
}