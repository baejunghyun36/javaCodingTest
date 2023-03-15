import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9177 {

  static int n;
  static String a, b, c;
  static int [][] dp;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());


    for(int i=1; i<=n; i++){
      st = new StringTokenizer(br.readLine());
      a = st.nextToken();
      b = st.nextToken();
      c = st.nextToken();
      dp = new int[201][201];
      for(int j=0; j<=200; j++)Arrays.fill(dp[j],-1);
      if(dfs(0, 0, 0)==1) sb.append("Data set ").append(i).append(": ").append("yes\n");
      else sb.append("Data set ").append(i).append(": ").append("no\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static int dfs(int ai, int bi,   int ind){

    if(ind==c.length()){
      return 1;
    }
    if(dp[ai][bi]!=-1)return dp[ai][bi] ;
    dp[ai][bi] = 0;
    if(ai<a.length()&&c.charAt(ind)==a.charAt(ai)){
      dp[ai][bi] = Math.max(dp[ai][bi], dfs(ai+1, bi,  ind+1));
    }
    if(bi<b.length()&&c.charAt(ind)==b.charAt(bi)){
      dp[ai][bi] = Math.max(dp[ai][bi], dfs(ai, bi+1, ind+1));
    }
    return dp[ai][bi];
  }
}
