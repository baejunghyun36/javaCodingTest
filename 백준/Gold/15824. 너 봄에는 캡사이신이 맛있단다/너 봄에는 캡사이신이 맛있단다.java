import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int [] arr;
    static final int mod = 1000000007;
    //해설 참고..
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long answer = 0;

        for (int i = 0; i < n; i++) {
            answer += arr[i] * division(i) - arr[i] * division(n - i - 1);
            answer %= mod;
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static long division( int x) {
        if(x == 0) return 1;
        long half = division(x/2);
        if(x%2 == 0) return half*half % mod;
        return half*half*2 % mod;
    }
}