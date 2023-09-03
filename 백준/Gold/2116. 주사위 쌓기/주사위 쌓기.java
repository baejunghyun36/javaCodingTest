import java.io.*;
import java.util.*;

public class Main {


    static int n;
    static int [][] info;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        info = new int[n][6];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) info[i][j] = Integer.parseInt(st.nextToken());
            int temp = info[i][1];
            info[i][1] = info[i][5];
            info[i][5] = info[i][2];
            info[i][2] = temp;
        }
        for (int i = 0; i <= 5; i++) {
            int index = i;
            int surface = info[0][index];
            int maxSum = 0;
            for (int j = 0; j <= 5; j++) {
                if(i%2==0&&i+1==j)continue;
                if(i%2==1&&i-1==j)continue;
                if(i==j)continue;
                maxSum = Math.max(maxSum, info[0][j]);
            }
            for (int j = 1; j < n; j++) {
                int maxNum = 0;
                for (int k = 0; k < 6; k++) {
                    if(info[j][k]==surface)index = k;
                }
                if(index%2==0)surface = info[j][index+1];
                else surface = info[j][index-1];
                int floor = info[j][index];
                for (int k = 0; k < 6; k++) {
                    if(info[j][k]==surface||info[j][k]==floor) continue;
                    maxNum = Math.max(maxNum, info[j][k]);
                }
                maxSum+=maxNum;
            }
            answer = Math.max(answer, maxSum);
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}