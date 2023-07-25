import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int [] info, dp;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        //StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        info = new int[n + 1];
        dp = new int[n + 1];

        for(int i=1; i<=n; i++){
            int a = Integer.parseInt(br.readLine());
            info[i] = a;
        }

        dp[1] = info[1];
        if(n>=2) dp[2] = info[1]+info[2];
        if(n>=3) dp[3] = Math.max(info[1]+info[2],Math.max(info[1] + info[3], info[2] + info[3]));
        for(int i=4; i<=n; i++){
            dp[i] = Math.max(dp[i -2] + info[i], Math.max(dp[i-4],dp[i - 3]) + info[i - 1]+info[i]);
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

//        System.out.println(Arrays.toString(dp));
        sb.append(dp[n]);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}