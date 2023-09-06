import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int [] list;
    static int n, s, start, end, answer;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        list = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) list[i] = Integer.parseInt(st.nextToken());

        twoPoint();
        if(answer==INF) answer = 0;
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void twoPoint(){
        answer = INF;
        int sum = 0;
        while(end<n){
            while (end<n&&sum<s) sum += list[end++];
            if(end==n&&sum<s)break;
            while (start<=end && sum >= s ) {
                answer = Math.min(answer, end - start);
                sum -= list[start++];
            }
        }
    }
}