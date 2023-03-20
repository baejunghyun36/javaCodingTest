import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1719 {
  static int [][] map;
  static int n,m;
  static int inf = 987654321;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new int[n+1][n+1];
    for(int i=1; i<=n; i++) Arrays.fill(map[i], inf);

    int [][] point = new int[n+1][n+1];
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      map[a][b] = c;
      map[b][a] = c;
      point[a][b] = b;
      point[b][a] = a;
    }

    for(int k=1; k<=n; k++){
      for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
          if(map[i][j]>map[i][k]+map[k][j]){
            map[i][j] = map[i][k] +map[k][j];
            point[i][j] = point[i][k];
          }
        }
      }
    }

    for(int i=1; i<=n; i++){
      for(int j=1; j<=n; j++){
        if(i==j)sb.append("- ");
        else sb.append(point[i][j]).append(" ");
      }
      sb.append("\n");
    }


    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

}
