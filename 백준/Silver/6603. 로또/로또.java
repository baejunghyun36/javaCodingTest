import java.io.*;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int [] seq;
    static int [] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        seq = new int[6];
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n==0)break;
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static void comb (int start, int index){

        if(index==6){
            for (int i = 0; i < 6; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            seq[index] = arr[i];
            comb(i + 1, index + 1);
        }
    }

}