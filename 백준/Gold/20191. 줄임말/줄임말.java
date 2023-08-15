import java.io.*;
import java.util.*;

public class Main {

    static String s, t;
    static int [] listIndex;
    static ArrayList<Integer> [] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        list = new ArrayList[26];
        listIndex = new int[26];

        s = br.readLine();
        t = br.readLine();

        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < t.length(); i++) {
            list[t.charAt(i) - 'a'].add(i);
        }
        int cnt = 0;
        int curIndex = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i)-'a';
            if(list[c].size()==0){
                System.out.println(-1);
                System.exit(0);
            }
            int next = listIndex[c];
            next = list[c].get(next);
            if(curIndex>=next){
                cnt++;
            }
            curIndex = next;
            listIndex[c] = (listIndex[c]+1)%list[c].size();
        }
        sb.append(cnt);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}