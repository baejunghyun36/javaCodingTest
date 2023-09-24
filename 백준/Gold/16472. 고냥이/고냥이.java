import java.io.*;
import java.util.*;

public class Main {

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        int start = 0;
        int end = -1;
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (true) {
            while (end < s.length() - 1) {
                end++;
                map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
                if (map.size() > n) break;
                answer = Math.max(answer, end - start + 1);
            }
            if (end == s.length() - 1) break;
            while (map.size() > n) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                if (map.get(s.charAt(start)) == 0) map.remove(s.charAt(start));
                start++;
            }
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}