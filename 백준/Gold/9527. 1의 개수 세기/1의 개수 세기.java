import java.io.*;
import java.util.*;

public class Main {

    static long [] dp ;

    //답 봄
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        dp = new long[55];
        dp[0] = 1;
        for(int i=1;i<55;i++) dp[i] = (dp[i-1] << 1) + (1L << i);

        long result = check(b) - check(a-1);
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static long check (long N) {
        long count = N & 1;

        int size = (int) (Math.log(N)/Math.log(2));

        for(int i=size;i>0;i--) {
            if((N & (1L<<i)) != 0L) {
                count += dp[i-1] +(N - (1L<<i) + 1);
                N -= (1L << i);
            }
        }
        return count;
    }

}