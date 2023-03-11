import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2458 {

  static int [][] dist;
  static int n, m;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    dist = new int[n+1][n+1];

    for(int i=1; i<=n; i++){
      for(int j=1; j<=n; j++){
        dist[i][j] = 987654321;
      }
    }

    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      dist[a][b] = 1;
    }

    for(int k=1; k<=n; k++){
      for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
          if(dist[i][j]>dist[i][k] +dist[k][j]){
            dist[i][j] = dist[i][k]+dist[k][j];
          }
        }
      }
    }

    int answer = 0;

    for(int i=1; i<=n; i++){
      int cnt = 0;
      for(int j=1; j<=n; j++){
        if(dist[i][j]!=987654321||dist[j][i]!=987654321)cnt++;
      }
      if(cnt==n-1)answer++;
    }

    sb.append(answer);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
