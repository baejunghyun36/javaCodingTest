import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m, n;
    static int [][] map;
    static int [][][]visited;
    static Queue<int[]> q;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();

        map = new int[m][n];
        visited = new int[2][m][n];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = 1;
        int minTime = 987654321;

        out:while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int [] yx = q.poll();
                int y = yx[0];
                int x = yx[1];

                int dist = yx[3];
                if(yx[0]==m-1&&yx[1]==n-1) {
                    minTime = dist;
                    break out;
                }
                for(int i=0; i<4; i++){
                    int nx = dx[i] + x;
                    int ny = dy[i] + y;
                    int existNife = yx[2];
                    if(ny<0||ny>=m||nx<0||nx>=n)continue;
                    if(map[ny][nx]==2)existNife = 1;
                    if(visited[existNife][ny][nx]==1)continue;
                    if(existNife==0){
                        if(map[ny][nx]==1)continue;
                    }
                    visited[existNife][ny][nx] = 1;
                    q.add(new int[]{ny, nx, existNife, dist+1});
                }
            }
        }

        if(minTime<=time) sb.append(minTime);
        else sb.append("Fail");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}