import java.io.*;
import java.util.*;

public class Main {

    static int n, m, L;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[n] = L;
        Arrays.sort(arr);

        sb.append(binarySearch());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(){

        int l = 1;
        int h = L;
        int maxArea = 0;
        while (l <= h) {
            int mid = (l+h)/2;
            int prev = 0;
            int cnt = 0;
            for (int i = 0; i <= n; i++) {
                if(prev+mid>=arr[i]) prev = arr[i];
                else {
                    cnt+= (arr[i]-prev-1)/mid;
                    prev = arr[i];
                }
            }
            if(cnt<=m){
                maxArea = mid;
                h = mid-1;
            }
            else l = mid +1;
        }
        return maxArea;
    }
}

/*
3 5 1000
300 600 900
*
* */