import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17404 {
  static int n;
  static int [][] dp;
  static int [][] map;
  static int answer = 987654321;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    map = new int [n+2][3];
    dp = new int [n+2][3];
    for(int i = 1; i<=n; i++){
      st = new StringTokenizer(br.readLine());
      map[i][0] = Integer.parseInt(st.nextToken());
      map[i][1] = Integer.parseInt(st.nextToken());
      map[i][2] = Integer.parseInt(st.nextToken());
    }

    for(int j=0; j<=n; j++){
      Arrays.fill(dp[j], -1);
    }
    for(int i=0; i<3; i++) {
      for(int j=0; j<3; j++){
        if(i!=j){
          answer = Math.min(answer,dfs(i, 2, j)+map[1][i] ) ;
        }
      }
      for(int j=0; j<=n; j++) Arrays.fill(dp[j], -1);

    }

    sb.append(answer);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static int dfs(int startColor, int level, int cur){

    if(level==n){
      if(cur==startColor)return 987654321;
      else return map[level][cur];
    }
    if(dp[level][cur]!=-1) return dp[level][cur];
    dp[level][cur] = 987654321;
    for(int i=0; i<3; i++){
      if(cur==i)continue;
      dp[level][cur] = Math.min(dp[level][cur], dfs(startColor, level + 1, i)+map[level][cur]);
    }
    return dp[level][cur];
  }
}