import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, Integer> map;
    static int n, type, seq, coupon;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        type = Integer.parseInt(st.nextToken());
        seq = Integer.parseInt(st.nextToken());
        coupon = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        int[] arr = new int[n*2];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        for (int i = n; i < 2 * n; i++) arr[i] = arr[i - n];
        for (int i = 0; i < seq; i++)  map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        int start = 0;
        int end = seq-1;
        updateAnswer();
        while(true){
            end++;
            map.put(arr[end], map.getOrDefault(arr[end], 0)+1);
            map.put(arr[start], map.getOrDefault(arr[start], 0)-1);
            if(map.get(arr[start])==0) map.remove(arr[start]);
            updateAnswer();
            start++;
            if(start==n)break;
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void updateAnswer(){
        if(map.getOrDefault(coupon, 0)==0) answer = Math.max(answer, map.size()+1);
        else answer = Math.max(answer, map.size());
    }
}