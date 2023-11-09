import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int start, end;
    static int [] in, maxDist, routeCount;
    static ArrayList<int[]> []list;
    static ArrayList<Integer> [] reverseRoute;
    static Set<String> []set;
    static int [] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        reverseRoute = new ArrayList[n + 1];
        set = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) set[i] = new HashSet<>();
        list = new ArrayList[n + 1];
        in = new int[n + 1];
        maxDist = new int[n + 1];
        routeCount = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            reverseRoute[i] = new ArrayList<>();
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
            in[b]++;
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        solution();
        check();
        sb.append(maxDist[end]).append("\n").append(check());
//        for(String s : set[end]) System.out.println(s);
//        for (int i = 1; i <= n; i++) {
//            System.out.print(routeCount[i]+" ");
//        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int check(){
        visited = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(end);

        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < reverseRoute[cur].size(); i++) {
                int next = reverseRoute[cur].get(i);
                if(visited[next]==0){
                    q.add(next);
                }
                visited[next] = 1;
                cnt++;

            }
        }
        return cnt;
    }


    static void solution(){

        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{start, 0, 0});
        while (!q.isEmpty()) {
            int[] info = q.poll();
            int cur = info[0];
            int dist = info[1];
            for (int i = 0; i < list[cur].size(); i++) {
                int[] next = list[cur].get(i);
                int nextVertex = next[0];
                int nextDist = next[1];
                in[nextVertex]--;
                if(maxDist[nextVertex]<dist+nextDist){
                    maxDist[nextVertex] = dist + nextDist;
                    reverseRoute[nextVertex] = new ArrayList<>();
                    reverseRoute[nextVertex].add(cur);
//                    routeCount[nextVertex] = routeCount[cur] + 1;
                } else if (maxDist[nextVertex] == dist + nextDist) {

                    reverseRoute[nextVertex].add(cur);
//                    routeCount[nextVertex] += routeCount[cur] + 1;
                }
                if(in[nextVertex]==0){
                    q.add(new int[]{nextVertex, maxDist[nextVertex], routeCount[nextVertex]});
                }
            }
        }
    }
}