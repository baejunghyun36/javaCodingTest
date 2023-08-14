import java.io.*;
import java.util.*;

public class Main {



    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[1000001];
        Arrays.fill(arr, true);
        for (int i = 2; i <= Math.sqrt(b); i++) {
            if(arr[i]==true){
                for(int j=i+i; j<=b; j+=i)arr[j] = false;
            }
        }
        if(a==1) a = 2; 
        if(b==1) b = 2; 
        for (int i = a; i <= b; i++) {
            if(arr[i]) sb.append(i).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


}