import java.io.*;
import java.util.Arrays;
import java.util.*;

public class Main {
    static int [][] accumArr;
    static String s;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        s = br.readLine();
        n = Integer.parseInt(br.readLine());
        initAccum();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken())+1;
            sb.append(accumArr[index][r] - accumArr[index][l]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void initAccum(){
        accumArr = new int[26][s.length() + 1];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < s.length(); j++) {
                accumArr[i][j + 1] = accumArr[i][j];
                if (s.charAt(j) - 'a' == i) {
                    accumArr[i][j + 1]++;
                }
            }
        }
    }
}