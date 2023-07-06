import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  static int N;
  static int [][] map;
  static int [][] visited;
  static int[] dy = {0, 0, 1, -1};
  static int[] dx = {1, -1, 0, 0};
  static Queue<int[]> q;
  static List<Start> list;
  static int answer;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    answer = Integer.MAX_VALUE;
    N = Integer.parseInt(st.nextToken());
    map = new int[N][N];
    list = new ArrayList<>();
    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    landCheck();

    makeBridge();
    sb.append(answer);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  static void makeBridge(){
    int [][] distMap = new int[N][N];
    for(Start start : list){
      visited = new int[N][N];
      int y = start.y;
      int x = start.x;
      int landNumber = map[y][x];
      q = new LinkedList<>();
      q.add(new int[]{y,x,0});
      visited[y][x] = 1;
      out:while (!q.isEmpty()) {
        int [] yx = q.poll();
        for(int i=0; i<4; i++){
          int ny = dy[i]+yx[0];
          int nx = dx[i]+yx[1];
          int dist = yx[2];
          if(ny<0||ny>=N||nx<0||nx>=N)continue;
          if(visited[ny][nx] == 1 || map[ny][nx]==landNumber)continue;
          if(map[ny][nx]!=0&&map[ny][nx]!=landNumber){
            answer = Math.min(dist, answer);
            break out; 
          }
          visited[ny][nx] = 1;
          q.add(new int[]{ny, nx, dist+1});
        }

      }
    }
  }

  static void landCheck(){
    visited = new int[N][N];
    int landNumber = 2;
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        if(map[i][j]==1&&visited[i][j]==0){
          q = new LinkedList<>();
          q.add(new int[]{i,j});
          visited[i][j] = 1;
          map[i][j] = landNumber;
          while(!q.isEmpty()){
            int [] yx = q.poll();
            for(int k = 0; k<4; k++){
              int nx = yx[1]+dx[k];
              int ny = yx[0]+dy[k];
              if(ny<0||ny>=N||nx<0||nx>=N)continue;
              if(visited[ny][nx]==1)continue;
              if(map[ny][nx] ==0){
                list.add(new Start(yx[0], yx[1]));
                continue;
              }
              map[ny][nx] = landNumber;
              visited[ny][nx] = 1;
              q.add(new int[]{ny, nx});
            }
          }
          landNumber++;
        }
      }
    }
  }

  static class Start{
    int y;
    int x;

    public Start(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}
