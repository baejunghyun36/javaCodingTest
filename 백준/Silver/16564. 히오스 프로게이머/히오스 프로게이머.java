import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int [] levelInfo;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        levelInfo = new int[n + 1];
        for (int i = 0; i < n; i++) levelInfo[i] = Integer.parseInt(br.readLine());
        sb.append(binarySearch(k));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static long binarySearch(int k){
        long l = 1;
        long h = 2000000000;
        long answer = 1;
        while (l <= h) {
            long level = (l+h)/2;
            if(check(level, k)){
                answer = level;
                l = level+1;
            }
            else h = level-1;
        }
        return answer;
    }

    static boolean check(long level, long k){

        for (int i = 0; i < n; i++) {
            if(levelInfo[i]>=level)continue;
            k-=(level-levelInfo[i]);
            if(k<0)return false;
        }
        if(k<0)return false;
        return true;
    }
}