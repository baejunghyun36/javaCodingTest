import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<int []> list = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) list.add(new int []{i, Integer.parseInt(st.nextToken())});
        int cur = 0;
        while(true) {
            sb.append(list.get(cur)[0]+" ");
            int offset = list.get(cur)[1];
            list.remove(cur);
            if(list.size()==0) break ;
            if(offset>0) cur = (offset-1+ cur) % list.size();
            else cur = (cur + offset) % list.size();
            if(cur<0) cur += list.size();
            if(cur>=list.size()) cur -= list.size();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}