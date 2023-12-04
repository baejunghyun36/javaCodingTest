import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int testCase;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] to = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                to[i] = Integer.parseInt(br.readLine());
            }
            sb.append(binary(to, n)).append("\n");
            // 1 2 3 4 5 6
            // 4 2 6 3 1 5
            //   2 3 5
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int binary(int [] to, int n){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int end = list.size() -1;
            int num = to[i];
            if(list.size()==0||list.get(end) < num) list.add(num);
            else{
                int l = 0;
                int h = end;
                int idx = 0;
                while (l <= h) {
                    int mid = (l+h)/2;
                    if(list.get(mid) > num){
                        idx = mid;
                        h = mid -1;
                    }
                    else l = mid + 1;
                }
                if(h<0) list.set(0, num);
                else list.set(idx, num);
            }
        }

        return list.size();
    }

}