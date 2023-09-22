import java.io.*;
import java.util.*;

public class Main {

    static int m, n, k, answer;
    static String [] map;
    static int [][] temp;
    static Map<String, Integer> countOfString;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new String[m];
        temp = new int[m][n];
        countOfString = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map[i] = br.readLine();
            countOfString.put(map[i], countOfString.getOrDefault(map[i], 0) + 1);
        }
        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            int zeroCount = 0;
            for (int j = 0; j < n; j++) if(map[i].charAt(j)=='0')zeroCount++;
            if (zeroCount <= k && zeroCount % 2 == k % 2) answer = Math.max(answer, countOfString.get(map[i]));
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}