import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] arr = new char[n];
        int [] alpa = new int [26];
        Arrays.fill(arr, ' ');

        int index = 0;
        for (int i = 0; i < k; i++) {

            st = new StringTokenizer(br.readLine());
            int move = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            index = (index+move)%n;
            if(arr[index]!=c&&arr[index]!=' '){
                sb = new StringBuilder();
                sb.append("!");
                break ;
            }
            if(arr[index]!=c&&alpa[c-65]==1){
                sb = new StringBuilder();
                sb.append("!");
                break ;
            }
            arr[index] = c;
            alpa[c-65] = 1;
            if (i == k - 1) {

                for (int j = 0; j < n; j++) {
                    if(arr[index]==' ') sb.append("?");
                    else sb.append(arr[index]);
                    index--;
                    if(index==-1)index = n-1;
                }
            }
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}