import java.io.*;
import java.lang.reflect.GenericDeclaration;
import java.util.*;

public class Main {


    static long [] arr;
    static int [] visited;
    static long [] answer;
    static int n;
    static long minNumber = 3000000001l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[n];
        visited = new int[n];
        answer = new long[3];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        search();
        Arrays.sort(answer);
        for (int i = 0; i < 3; i++) {
            sb.append(answer[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static void search(){

        int l = 0;
        int h = n-1;
        int mid = l+1;

        while(true){

            long sum = arr[l] + arr[h] + arr[mid];
            if (minNumber > Math.abs(sum)|| sum==0) {
                minNumber = Math.abs(sum);
                answer[0] = arr[l];
                answer[1] = arr[h];
                answer[2] = arr[mid];
                if(sum==0) return;
            }
            if(sum>0) h--;
            else if(sum<0) mid++;
            if (mid == h) {
                l++;
                mid = l+1;
                h = n-1;
            }
            if(l+1 >=h)break ;

        }
    }
}