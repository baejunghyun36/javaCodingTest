import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int [] arr;
    static ArrayList<Integer> list;
    static int [] dp;
    static int [] reverseIndex;
    static int start;
    static int maxValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        arr = new int[n];
        dp = new int[n];
        reverseIndex = new int[n];
        Arrays.fill(reverseIndex, -1);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++) {
            int a = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                int b = arr[j];

                if(a>b){
                    if(dp[i]<dp[j]+1){
                        dp[i] = dp[j] + 1;
                        if(maxValue<dp[i]){
                            maxValue = dp[i];
                            start = i;
                        }
                        reverseIndex[i] = j;
                    }
                }
            }
        }

        ArrayList<Integer> list;
        list = new ArrayList<>();
        while (reverseIndex[start] != -1) {
            list.add(arr[start]);
            start = reverseIndex[start];
        }
        list.add(arr[start]);
        sb.append(list.size()).append("\n");
        Collections.sort(list);
        for (int x : list) {
            sb.append(x).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


}