import java.io.*;
import java.util.*;

public class Main {

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        int answer = 0;
        char s[] = br.readLine().toCharArray();
        int count = 0;
        for(int i=1; i < m - 1; i++) {
            if(s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
                count++;

                if(count == n) {
                    count--;
                    answer++;
                }
                i++;
            }
            else {
                count = 0;
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}