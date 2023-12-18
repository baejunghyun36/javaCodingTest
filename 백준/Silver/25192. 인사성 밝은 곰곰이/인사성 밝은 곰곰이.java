import java.io.*;
import java.util.HashSet;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        Set<String> set = new HashSet<>();
        while (n-- > 0) {
            String s = br.readLine();
            if (s.equals("ENTER")) {
                answer += set.size();
                set = new HashSet<>();
            } else set.add(s);
        }
        answer += set.size();
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}