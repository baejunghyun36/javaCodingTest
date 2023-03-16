import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1613 {
  static int n, k;
  static int [][] se, es;
  static int inf = 987654321;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    se = new int[n+1][n+1];
    es = new int[n+1][n+1];

    for(int i=1; i<=n; i++){
      Arrays.fill(se[i], inf);
      Arrays.fill(es[i], inf);
    }

    for(int i=0; i<k;i++){
      st =new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      se[a][b] = 1;
      es[b][a] = 1;
    }

    for(int k = 1; k<=n; k++){
      for(int i=1; i<=n; i++){
        for(int j=1; j<=n; j++){
          if(se[i][j]>se[i][k] + se[k][j]){
            se[i][j] = se[i][k] + se[k][j];
          }if(es[i][j]>es[i][k] + es[k][j]) {
            es[i][j] = es[i][k] + es[k][j];
          }
        }
      }
    }

    int output = Integer.parseInt(br.readLine());
    for(int i=0; i<output; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if(se[a][b]!=inf)sb.append(-1).append("\n");
      else if(es[a][b]!=inf)sb.append(1).append("\n");
      else sb.append(0).append("\n");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
