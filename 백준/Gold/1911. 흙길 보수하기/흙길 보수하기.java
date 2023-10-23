import java.io.*;
import java.util.*;

public class Main {

    static int n, l;
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken())-1;
            list.add(new int[]{a, b});
        }
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        sb.append(solution());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int solution(){
        int answer = 0;
        int cnt = 0;
        int endPoint = 0;
        for (int i = 0; i < n; i++) {
            if (endPoint < list.get(i)[0]) {
                cnt = (list.get(i)[1] - list.get(i)[0] + l) / l;
                endPoint = list.get(i)[0] + cnt * l - 1;
            }
            else{
                cnt = (list.get(i)[1] - (endPoint + 1) + l) / l;
                endPoint = endPoint + cnt * l;
            }
            answer+=cnt;
        }
        return answer;
    }
}
/*
3 1000000
1 1000
10000 400000
500000 900000
* */