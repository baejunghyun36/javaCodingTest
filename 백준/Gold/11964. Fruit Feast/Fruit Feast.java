import java.io.*;
import java.util.*;

public class Main {


    static int [][] visited;
    static int t, a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        visited = new int[2][t + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int []{1, 0});
        visited[1][0] = 0;
        int answer = 0;
        while (!q.isEmpty()) {
            int [] info = q.poll();
            int water = info[0];
            int cur = info[1];
            answer = Math.max(answer, cur);
            if(cur+a<=t&&visited[water][cur+a]==0){
                q.add(new int [] {water, cur+a});
                visited[water][cur+a] = 1;
            }
            if(cur+b<=t&&visited[water][cur+b]==0){
                q.add(new int [] {water, cur+b});
                visited[water][cur+b] = 1;
            }
            if(water==1&&visited[0][cur/2]==0){
                q.add(new int [] {0, cur / 2});
                visited[0][cur/2] = 1;
            }
        }

        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}