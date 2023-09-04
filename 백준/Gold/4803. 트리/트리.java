import java.io.*;
import java.util.*;

public class Main {

    static int [] parent;
    static int n, m, testCase;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n==0&&m==0)break;

            testCase++;
            initParent();

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            Set<Integer> set = new HashSet<>();

            for (int i = 1; i <= n; i++) {
                int root = find(i);
                if(root !=0) set.add(root);
            }

            output(set.size());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void initParent(){

        parent = new int[n + 1];
        for(int i=0; i<=n; i++) parent[i] = i;
    }

    static int find(int a){

        if(parent[a]==a)return a;
        return parent[a] = find(parent[a]);
    }

    static void union(int a, int b) {

        int pa = find(a);
        int pb = find(b);

        if(pb < pa){
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        if(pa==pb) parent[pa] = 0;
        else parent[pb] = pa;

    }

    static void output(int cnt){

        sb.append("Case ").append(testCase).append(": ");
        switch (cnt){
            case 0 :
                sb.append("No trees.\n");
                break;
            case 1 :
                sb.append("There is one tree.\n");
                break;
            default:
                sb.append("A forest of ").append(cnt).append(" trees.\n");
        }
    }
}