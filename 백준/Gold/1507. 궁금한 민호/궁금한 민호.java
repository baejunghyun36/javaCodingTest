import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int [][] dist;
    static int [][] updatedDist;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        updatedDist = new int[n + 1][n + 1];
        dist = new int[n + 1][n + 1];
        for(int i=1; i<=n; i++) Arrays.fill(updatedDist[i], INF);
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int [] > pq = new PriorityQueue<>((o1, o2)-> {
            return o1[2] - o2[2];
        });

        for (int i = 1; i <= n-1; i++) {
            for(int j=i+1; j<=n; j++){
                pq.add(new int[]{i, j, dist[i][j]});
            }
        }
        boolean flag = false;
        int answer = 0;
        for(int i=1; i<=n; i++) updatedDist[i][i] = 0;

        int cnt = 0;

        while (!pq.isEmpty()) {
            int[] d = pq.poll();
            int a = d[0];
            int b = d[1];
            int c = d[2];
            if(floydWarshall(a, b, c)){
                answer += c;
                cnt ++;
                boolean check = true;
                out:for (int i = 1; i <= n-1; i++) {
                    for (int j = 1; j <= n; j++) {
                        if(dist[i][j]!=updatedDist[i][j]) {
                            check = false;
                            break out;
                        }
                    }
                }
                if(check){
                    flag = true;
                    break;
                }
            }
            else updatedDist[a][b] = updatedDist[b][a] = dist[a][b];
        }
        if(cnt== n*n+1/2) flag = false;
        if(flag)sb.append(answer);
        else System.out.println(-1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean floydWarshall(int a, int b, int c){

        boolean flag = false;
        if(updatedDist[a][b]>c){
            updatedDist[a][b] = updatedDist[b][a] = c;
            flag = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(updatedDist[i][j]>updatedDist[i][k]+updatedDist[k][j]) {
                        flag = true;
                        updatedDist[j][i] = updatedDist[i][j] = updatedDist[i][k] + updatedDist[k][j];
                    }
                }
            }
        }

        return flag;
    }
}