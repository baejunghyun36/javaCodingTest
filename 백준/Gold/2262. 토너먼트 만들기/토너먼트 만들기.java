import java.io.*;
import java.util.*;

public class Main {


    static ArrayList<Integer> list;
    static int n, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) list.add(Integer.parseInt(st.nextToken()));
        solution();

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void solution(){
        int ranking = n;
        while (list.size() >= 2) {
            int index = list.indexOf(ranking);
            if(index==0) answer += ranking - list.get(1);
            else if(index==list.size()-1) answer += ranking - list.get(index-1);
            else answer += list.get(index - 1) > list.get(index + 1) ? ranking - list.get(index - 1) : ranking - list.get(index + 1);
            list.remove(index);
            ranking--; 
        }
    }
}