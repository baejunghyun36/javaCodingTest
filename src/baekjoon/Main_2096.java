import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2096 {

    static int [] dx = {-1,0,1};
    static int [][] dp;
    static int [][] info;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        info = new int[N+1][3];
        dp = new int[N+1][3];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        dfs(1);
       // for(int i=0; i<N; i++) System.out.println(Arrays.toString(dp[i]));
        for(int i=0; i<3; i++){
            answer = Math.max(answer, dp[N][i]);
        }
        sb.append(answer).append(" ");
        for(int i=1; i<=N; i++) Arrays.fill(dp[i], 987654321);
        Arrays.fill(dp[0], 0);
        mindfs(1);
        answer = 987654321;

        for(int i=0; i<3; i++){
            answer = Math.min(answer, dp[N][i]);
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int i){

        if (i == N+1) {
            return;
        }
        for(int j = 0; j<3; j++){
            for(int d = 0; d<3; d++){
                int prev = dx[d]+j;
                if(prev<0||prev>2)continue;
                dp[i][j] = Math.max(dp[i][j], dp[i-1][prev]+info[i][j]);
            }
        }
        dfs(i+1);
    }

    static void mindfs(int i) {
        if (i == N+1) {
            return;
        }
        for(int j = 0; j<3; j++){
            for(int d = 0; d<3; d++){
                int prev = dx[d]+j;
                if(prev<0||prev>2)continue;
                dp[i][j] = Math.min(dp[i][j], dp[i-1][prev]+info[i][j]);
            }
        }
        mindfs(i+1);
    }
}
