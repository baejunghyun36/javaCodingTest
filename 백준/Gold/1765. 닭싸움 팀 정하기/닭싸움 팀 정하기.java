import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int [] parent;
    static int [] enemy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        StringTokenizer st = null;
        enemy = new int[n + 1];
        initParent();

        for(int i=0; i<m; i++){

            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(s.equals("F")) union(a, b);
            else enemyCheck(a, b);
        }

        for (int i = 1; i <= n; i++) find(i);

        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=n; i++) set.add(parent[i]);

        sb.append(set.size());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void enemyCheck(int a, int b){

        if(enemy[b]!=0) union(a, enemy[b]);
        if(enemy[a]!=0) union(b, enemy[a]);
        enemy[b] = a;
        enemy[a] = b;
    }

    static void union(int a, int b){

        int parentA = find(a);
        int parentB = find(b);
        if(parentA!=parentB) parent[parentB] = parentA;
    }

    static void initParent(){

        for(int i=1; i<=n; i++) parent[i] = i;
    }

    static int find(int a){

        if(parent[a]==a) return a;
        return parent[a] = find(parent[a]);
    }
}