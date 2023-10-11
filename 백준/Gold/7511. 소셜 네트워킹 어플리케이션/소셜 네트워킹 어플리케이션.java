import java.io.*;
import java.util.StringTokenizer;
public class Main {
    static int testCase, n, k, m;
    static int [] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        testCase = Integer.parseInt(st.nextToken());
        int number = 1;
        while (testCase-- > 0) {
            sb.append("Scenario "+number+++":\n");
            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());
            parent = new int[n];
            for(int i=0; i<n; i++)parent[i] = i; 
            for(int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(find(a)==find(b))sb.append("1\n");
                else sb.append("0\n");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int a) {
        if(a==parent[a])return a;
        return parent[a] = find(parent[a]);
    }
    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa==pb)return;
        if(pa<pb)parent[pb] = pa;
        else parent[pa] = pb;
    }
}