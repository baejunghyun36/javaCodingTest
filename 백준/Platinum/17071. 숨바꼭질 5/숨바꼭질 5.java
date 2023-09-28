import java.io.*;
import java.util.*;

public class Main {

    static Queue<Integer> q;
    static int [][] subin;
    static int [] minjung;
    static int n, k, second;
    static ArrayList<Integer> seq;
    static final int range = 500000;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        init();

        if(n==k) {
            System.out.println(0);
            System.exit(0);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            second++;
            while (size-- > 0) {
                int cur = q.poll();
                insert(second%2, cur+1, second);
                insert(second%2, cur-1, second);
                insert(second%2, cur*2, second);
            }
        }

        int offset = 1;
        int answer = -1;

        while(true){
            k+=offset;
            if(k>range)break;
            if(offset>=subin[offset%2][k]){
                answer = offset;
                break;
            }
            offset++;
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void insert(int mod, int next, int second){

        if(next<0||next>range)return;
        if(subin[mod][next]>second) {
            subin[mod][next] = second;
            q.add(next);
        }
    }

    static void init(){

        minjung = new int[range+1];
        subin = new int[2][range+1];
        Arrays.fill(subin[0], INF);
        Arrays.fill(subin[1], INF);
        subin[0][n] = 0;
        q = new LinkedList<>();
        seq = new ArrayList<>();
        q.add(n);
    }
}