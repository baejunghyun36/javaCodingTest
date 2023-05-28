import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int [] dp = new int[n+1];
    st = new StringTokenizer(br.readLine());

    for(int i=1; i<=n; i++){
      dp[i] = Integer.parseInt(st.nextToken());
      dp[i]+=dp[i-1];
    }

    int a = 0;
    int b = 0;
    for(int i=1; i<=m; i++){
      st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      sb.append(dp[b]-dp[a-1]).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();

  }
}