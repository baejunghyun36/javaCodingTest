import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(m==0&&n==0)break;
            int sum = 0;
            int [][]map = new int[m][n];
            int [][] visited = new int[m][n];
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0 && map[i][j]==1) {
                        sum++;
                        visited[i][j] = 1;
                        q.add(new int[]{i, j});
                        while (!q.isEmpty()) {
                            int [] yx = q.poll();
                            for (int d = 0; d < 8; d++) {
                                int nx = dx[d] + yx[1];
                                int ny = dy[d] + yx[0];
                                if(ny<0||ny>=m||nx<0||nx>=n) continue;
                                if(visited[ny][nx]==1)continue;
                                if(map[ny][nx]==0)continue;
                                visited[ny][nx] = 1;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
            sb.append(sum + "\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}