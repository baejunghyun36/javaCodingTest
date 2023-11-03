import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int [][] accumArray;
    static int [][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][n + 1];
        accumArray = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                accumArray[i][j] = accumArray[i - 1][j] + accumArray[i][j - 1] - accumArray[i - 1][j - 1] + arr[i][j];
            }
        }
        int maxNum = -999999999;
        for (int offset = 0; offset < n; offset++) {
            for (int i = 1; i <= n-offset; i++) {
                for (int j = 1; j <= n-offset; j++) {
                    maxNum = Math.max(maxNum, accumArray[i + offset][j + offset] - (accumArray[i + offset][j - 1] + accumArray[i - 1][j + offset]) + accumArray[i - 1][j - 1]);
                }
            }
        }
        sb.append(maxNum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}