import java.io.*;
import java.util.*;

public class Main {

    static String a, b;
    static int n;
    static int [] index;
    static Map<String, ArrayList<String>> map;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        index = new int[n + 1];
        for(int i=0; i<=n; i++) index[i] = i;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            if(n==0)break;
            if(map.get(a)==null) map.putIfAbsent(a, new ArrayList<>());
            if(map.get(b)==null) map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(b);
        }

        check(a, b);
        check(b, a);

        if(flag) sb.append(1);
        else sb.append(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void check(String cur, String findName) {
        for (int i = 0; i < map.get(cur).size(); i++) {
            String next = map.get(cur).get(i);
            if(next.equals(findName)) {
                flag = true;
                return;
            }
            if(!flag) check(next, findName);
        }
    }

}