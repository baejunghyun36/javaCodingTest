import java.io.*;
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
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        out:for(int i=0; i<n; i++){
            for (int j = 0; j < n; j++) {
                if(i==j)continue;
                long a = arr[i];
                long b = arr[j];
                visited[i] = visited[j] = 1;
                int index = binarySearch(a+b);
                if(index!=-1){
                    answer[0] = arr[i];
                    answer[1] = arr[j];
                    answer[2] = arr[index];
                }
                visited[i] = visited[j] = 0;
                if(minNumber==0)break out;
            }
        }
        Arrays.sort(answer);
        for (int i = 0; i < 3; i++) {
            sb.append(answer[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static int binarySearch(long sum){

        int l = 0;
        int h = n-1;
        boolean flag = false;
        int index = 0;
        out:while (l <= h) {
            int mid = (l+h)/2;
            while(l<=mid&&visited[mid]==1){
                mid--;
            }
            if(mid < l)break out;
            if(minNumber>Math.abs(sum+arr[mid])){
                flag = true;
                index = mid;
                minNumber = Math.abs(sum + arr[mid]);
                h= mid-1;
            }
            if(sum+arr[mid]>0) h = mid - 1;
            else l = mid + 1;
        }
        if(flag) return index;
        return -1;

    }

}