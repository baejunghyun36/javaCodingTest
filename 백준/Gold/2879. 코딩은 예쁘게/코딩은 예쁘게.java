import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int [] arr1, arr2;
    static int [] updatedArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr1 = new int[n+1];
        arr2 = new int[n+1];
        updatedArr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            updatedArr[i] = arr1[i] - arr2[i];
        }

        int answer = 0;
        for (int i = 1; i <= 80; i++) {
            boolean flag = false;
            for (int j = 1; j <= n; j++) {
                if(updatedArr[j]<=0) {
                    if(flag)answer++;
                    flag = false;
                    continue;
                }
                updatedArr[j]--;
                flag = true;
            }
            if(flag) answer++;
        }
        for (int i = 1; i <= 80; i++) {
            boolean flag = false;
            for (int j = 1; j <= n; j++) {
                if(updatedArr[j]>=0) {
                    if(flag)answer++;
                    flag = false;
                    continue; 
                }
                updatedArr[j]++;
                flag = true;
            }
            if(flag) answer++;
        }

        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}