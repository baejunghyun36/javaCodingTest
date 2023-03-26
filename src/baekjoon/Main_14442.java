import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14442 {
  static int [] dy = {0,0,1,-1};
  static int [] dx = {1,-1,0,0};
  static int M, N, K;
  static int [][] map;
  static int [][][] visited;
  static Queue<int []> q;
  static int answer = 987654321;
  static int [][]wallPossible;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[M][N];
    visited = new int[M][N][K+2];
    wallPossible = new int[M][N];
    q = new LinkedList<>();

    for(int i=0; i<M; i++){
      String s = br.readLine();
      for(int j=0; j<N; j++){
        map[i][j] = s.charAt(j)-'0';
      }
    }

    q.add(new int[]{0, 0, K, 1});
    visited[0][0][K] = 1;
    wallPossible[0][0]= K;
    answer  = bfs();
    sb.append(answer);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  static int bfs(){

    while (!q.isEmpty()) {

      int [] yx = q.poll();
      int w = yx[2]; //부술 수 있는 벽의 개수
      int dist = yx[3]; // 현재 나의 움직인 거리
      if(yx[0]==M-1&&yx[1]==N-1){
        return dist; //도착
      }

      for(int i=0; i<4; i++){
        int ny = yx[0] + dy[i];
        int nx = yx[1] + dx[i];
        if(ny<0||ny>=M||nx<0||nx>=N)continue;
        if(map[ny][nx]==1&&w==0)continue;
        if(visited[ny][nx][w]==1)continue;
        if(wallPossible[ny][nx]!=0&&wallPossible[ny][nx]>=w)continue;
        if(map[ny][nx]==1&&w>0&&(visited[ny][nx][w-1]==0&&visited[ny][nx][w]==0)){
          visited[ny][nx][w-1] = 1;
          wallPossible[ny][nx] = w-1;
          q.add(new int []{ny, nx, w-1, dist+1});
        }
        if(map[ny][nx]==0){
          visited[ny][nx][w] = 1;
          wallPossible[ny][nx] = w;
          q.add(new int[]{ny, nx, w, dist+1});
        }
      }
    }
    return -1;
  }
}
