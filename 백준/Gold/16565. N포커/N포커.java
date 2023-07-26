import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    //답지 봄
    //https://restudycafe.tistory.com/487
    static long [] dp;
    static int n;
    static int total = 52;
    static int mod = 10007;
    static int [][]comb ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        comb = new int[53][53];

        for(int i=0; i<=52; i++) comb[i][0] = 1;
        for(int i=1; i<+52; i++){
            for(int j=1; j<=52; j++){
                comb[i][j] = (comb[i-1][j]+comb[i-1][j-1])%mod;
            }
        }
        int answer = 0;
        for(int i=1; i<=13 && n-4*i>=0; i++){
            if(i%2 ==1) answer = (answer+comb[52-4*i][n-4*i]*comb[13][i])%mod;
            else answer = (answer - (comb[52-4*i][n-4*i]*comb[13][i]) % mod + mod)% mod;
        }
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}