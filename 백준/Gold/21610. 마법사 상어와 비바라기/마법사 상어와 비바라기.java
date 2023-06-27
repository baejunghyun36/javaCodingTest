import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int [][] map;
    static int [] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int [] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static List<Cloud> cloudList;
    static int [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int [n+1][n+1];
        cloudList = new ArrayList<>();

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cloudList.add(new Cloud(n, 1));
        cloudList.add(new Cloud(n, 2));
        cloudList.add(new Cloud(n-1, 1));
        cloudList.add(new Cloud(n-1, 2));

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            visited = new int[n+1][n+1];
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            Queue <int []> q = new LinkedList<>();

            for(int i=0; i<cloudList.size(); i++){
                Cloud cloud = cloudList.get(i);
                int nx = cloud.x + dx[d]*(s%n);
                int ny = cloud.y + dy[d]*(s%n);
                if(nx<=0) nx += n;
                if(nx>n) nx -= n;
                if(ny<=0) ny += n;
                if(ny>n) ny -= n;
                map[ny][nx]+=1;
                visited[ny][nx] = 1;
                q.add(new int[]{ny, nx});
            }

            cloudList = new ArrayList<>();
            while(!q.isEmpty()){
                int [] yx = q.poll();
                int cnt = 0;
                for(int i=2; i<=8; i+=2){
                    int ny = yx[0] + dy[i];
                    int nx = yx[1] + dx[i];
                    if(ny<=0||ny>n||nx<=0||nx>n)continue;
                    if(map[ny][nx]>=1) cnt++;
                }
                map[yx[0]][yx[1]]+=cnt;
            }

            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(map[i][j]>=2&&visited[i][j]==0){
                        map[i][j]-=2;
                        cloudList.add(new Cloud(i, j));
                    }
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                answer += map[i][j];
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static class Cloud {

        int y;
        int x ;

        public Cloud(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}