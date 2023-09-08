import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int [] seqOfAlpa, countOfAlpa;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        seqOfAlpa = new int[n + 1];
        countOfAlpa = new int[27];

        backTracking(1, 1, 0, 1);

        System.out.println(-1);
        br.close();
    }

    static void backTracking(int start, int end, int sum, int alpa){

        if(sum>n)return;
        if(sum==n){
            int prev = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if(seqOfAlpa[i]!=0) {
                    countOfAlpa[seqOfAlpa[i]]--;
                    sb.append((char)(64+seqOfAlpa[i]));
                }
                else{
                    countOfAlpa[prev]--;
                    sb.append((char) (64 + prev));
                }
                if(countOfAlpa[prev]==0) prev++;
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        for (int i = end; i >= start; i--) {

            seqOfAlpa[i] = alpa;
            countOfAlpa[alpa] = i;
            backTracking(i+1, end*2, sum+i, alpa + 1);
            seqOfAlpa[i] = 0;
            countOfAlpa[alpa] = 0;
        }
    }
}