import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<Integer> [] list;
    static int [] visited;
    static int [] nodesOfColor;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        nodesOfColor = new int[n + 1];
        visited = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            nodesOfColor[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        childCountDfs(1, 0);
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void childCountDfs(int cur, int prevColor){

        visited[cur] = 1;
        if(prevColor!=nodesOfColor[cur]) answer++;
        for (int i = 0; i < list[cur].size(); i++) {
            int next = list[cur].get(i);
            if(visited[next]==0)childCountDfs(next, nodesOfColor[cur]);
        }
    }
}