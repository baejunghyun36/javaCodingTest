import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6087 {


  static int M, N;
  static char[][] map;
  static int [] dx = {0, 0, -1, 1};
  static int [] dy = {-1, 1, 0, 0};
  static int [] start;
  static int [] end;
  static int [][][] mirror;
  static int answer = 987654321;
  static Queue<int []> q;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    q = new LinkedList<>();
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[M][N];
    start = new int[2];
    end = new int[2];
    mirror = new int [M][N][4];
    boolean check = false;
    for(int i=0; i<M; i++) map[i] = br.readLine().toCharArray();
    for(int i=0; i<M; i++){

      for(int j=0; j<N; j++){
        if(map[i][j] == 'C'){
          if(check==false){
            check = true;
            start[0] = i;
            start[1] = j;
          }
          else{
            end[0] = i;
            end[1] = j;
          }
        }
      }
    }
    for(int i=0; i<M; i++){
      for(int j=0; j<N; j++){
        Arrays.fill(mirror[i][j], 987654321);
      }
    }
    q.add(new int[]{start[0], start[1], -1, 0});  //prevDir, cnt
    bfs();
    sb.append(answer);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static void bfs(){

    while(!q.isEmpty()){

      int [] yx = q.poll();

      for(int i=0; i<4; i++){
        int ny = yx[0] + dy[i];
        int nx = yx[1] + dx[i];
        if(ny<0||ny>=M||nx<0||nx>=N)continue;
        if(map[ny][nx]=='*')continue;
        if(ny==start[0]&&nx==start[1])continue;
        if(yx[2]==i||yx[2]==-1){
          if(mirror[ny][nx][i]>yx[3]){
            mirror[ny][nx][i] = yx[3];
            q.add(new int []{ny, nx, i, yx[3]});
          }
        }
        else if(yx[2]!=i){
          if(mirror[ny][nx][i]>yx[3]+1){
            mirror[ny][nx][i]=yx[3]+1;
            q.add(new int[]{ny, nx, i, yx[3]+1});
          }
        }
      }
    }
    for(int i=0; i<4; i++){
      if(mirror[end[0]][end[1]][i]<answer){
        answer = mirror[end[0]][end[1]][i];
      }
    }
  }
}
