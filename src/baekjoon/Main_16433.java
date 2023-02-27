import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16433 {

  static char [][] map;
  static int m;
  static int r,c;
  static int [] dx = {1,1,-1,-1};
  static int[] dy = {1, -1, 1, -1};
  static Queue<int []> q;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    map = new char [m+1][m+1];
    q = new LinkedList<>();
    int y = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    map[y][x] = 'v';
    q.add(new int[]{y,x});
    while(!q.isEmpty()){
      int[] yx = q.poll();
      for(int i=0; i<4; i++){
        int ny = yx[0] + dy[i];
        int nx = yx[1] + dx[i];
        if(ny<=0||ny>m||nx<=0||nx>m)continue;
        if(map[ny][nx]=='v')continue;
        q.add(new int[]{ny, nx});
        map[ny][nx] ='v';
      }
    }
    for(int i=1; i<=m; i++){
      for(int j=1; j<=m; j++){
        if(map[i][j]!='v')sb.append(".");
        else sb.append("v");
      }
      sb.append("\n");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
