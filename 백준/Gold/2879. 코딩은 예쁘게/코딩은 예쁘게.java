import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] arr1, arr2;
    static int [] updatedArr;
    static int answer;
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
        for (int i = 1; i <= n; i++) arr1[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr2[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) updatedArr[i] = arr1[i] - arr2[i];

        if(n==1) sb.append(updatedArr[1]);
        else sb.append(solution());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int solution(){

        int prev = updatedArr[1];
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (prev * updatedArr[i] < 0) {
                answer += Math.abs(prev);
            }
            else if (Math.abs(prev) > Math.abs(updatedArr[i])) {
                answer += Math.abs(prev) - Math.abs(updatedArr[i]);
            }
            prev = updatedArr[i];
        }
        return answer += Math.abs(prev);
    }
}