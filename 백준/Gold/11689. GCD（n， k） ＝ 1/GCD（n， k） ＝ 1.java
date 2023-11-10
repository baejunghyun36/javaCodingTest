import java.io.*;
import java.util.StringTokenizer;

public class Main {

    //답봄.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long pi = n;
        for(long i=2; i*i<=n; i++) {
            if(n%i==0) pi = pi/i*(i-1);
            while(n%i==0) n/=i;
        }
        if(n!=1) pi = pi/n*(n-1);
        sb.append(pi);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}