import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int [] info, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int [n+2];
        info = new int [n+2];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i<=n; i++) info[i] = Integer.parseInt(st.nextToken());

        while(m-->0){

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken())+1;
            int v = Integer.parseInt(st.nextToken());

            dp[a] +=v;
            dp[b] -=v;

        }
        for(int i=1; i<=n; i++) dp[i]+=dp[i-1];
        for(int i=1; i<=n; i++) sb.append(info[i]+dp[i]).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
