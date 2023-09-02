import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int [] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        initParent();
        boolean flag = true;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(!union(a, b)){
                flag = false;
                sb.append(i+1);
                break;
            }
        }
        if(flag) sb.append(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean union (int a, int b){

        int parentA = find(a);
        int parentB = find(b);
        if(parentA==parentB) return false;
        parent[parentB] = parentA;
        return true;
    }

    static int find(int num){
        if(parent[num]==num)return num;
        return parent[num] = find(parent[num]);
    }

    static void initParent(){
        parent = new int[n];
        for(int i=0; i<n; i++)parent[i] = i;
    }
}