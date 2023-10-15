import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Queue<int []> q;
    static int [] bit;
    static char [][] result;
    static StringBuilder sb;
    static int [] prev;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        bit = new int[n];
        prev = new int[n];
        q = new LinkedList<>();
        q.add(new int[]{0, n - 1});
        result = new char[7][n];

    
        dfs(0, 0, n - 1);
        for (int i = 0; i < 7; i++) {
            if(!String.valueOf(result[i]).contains("B")) result[i][0] = 'B';
            sb.append(String.valueOf(result[i])).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int level, int start, int end){

        if(level==7){
            return;
        }
        if(start>end)return;
        int mid = (start+ end)/2;

        for (int i = start; i <= mid; i++) {
            result[level][i] = 'A';
        }
        for (int i = mid + 1; i <= end; i++) {
            result[level][i] = 'B';
        }

        dfs(level + 1, start, mid);
        dfs(level + 1, mid + 1, end);
        
    }



}