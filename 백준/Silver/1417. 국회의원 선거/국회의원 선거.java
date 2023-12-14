import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[n-1];
        for (int i = 0; i < n-1; i++) arr[i] = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (true) {
            Arrays.sort(arr);
            if (arr[n-2] < a) break;
            cnt++;
            arr[n-2]--;
            a++;
        }
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}