import java.io.*;
import java.util.*;

public class Main {
    static int k, n;
    static char [][] bridge;
    static char [] seq;
    static int row;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        seq = br.readLine().toCharArray();

        bridge = new char[n][k - 1];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if(s.charAt(0)=='?') row = i;
            bridge[i] = s.toCharArray();
        }

        seqFromTopBottom();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void seqFromTopBottom(){

        int [] fromTop = new int[k];
        int [] fromBottom = new int[k];
        for (int i = 0; i < k; i++) {
            fromTop[i] = i;
            fromBottom[i] = seq[i] - 'A';
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < k - 1; j++) {
                if(bridge[i][j]=='-'){
                    int temp = fromTop[j];
                    fromTop[j] = fromTop[j + 1];
                    fromTop[j+1] = temp;
                }
            }
        }

        for (int i = n - 1; i > row; i--) {
            for (int j = 0; j < k - 1; j++) {
                if(bridge[i][j]=='-'){
                    int temp = fromBottom[j];
                    fromBottom[j] = fromBottom[j + 1];
                    fromBottom[j+1] = temp;
                }
            }
        }

        check(fromTop, fromBottom);

    }

    static void check(int [] fromTop, int[] fromBottom){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            if(fromTop[i]==fromBottom[i]) sb.append("*");
            else if(fromTop[i]==fromBottom[i+1]) {
                sb.append("-");
                if(i<k-2) sb.append("*");
                i++;
            }
            else {
                sb = new StringBuilder();
                for (int j = 0; j < k - 1; j++) {
                    sb.append('x');
                }
                break;
            }
        }
        System.out.println(sb.toString());
    }

}