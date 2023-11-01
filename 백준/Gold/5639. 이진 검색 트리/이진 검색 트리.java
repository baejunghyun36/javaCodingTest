import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;
    static ArrayList<Integer> preorder;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        preorder = new ArrayList<>();
        while (true){
            String s = br.readLine();
            if(s==null||s.equals("")) break;
            preorder.add(Integer.parseInt(s));
        }
        n = preorder.size();
        sb = new StringBuilder();

        dfs(0, n-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int index, int end) {

        //50 30 24 5 28 45 98 52 60
        if(index>end)return;
        int mid = index+1;
        int number = preorder.get(index);
        for (int i = index + 1; i <=end; i++) {
            if(number<preorder.get(i)){
                mid = i;
                break ;
            }
        }
        dfs(index + 1, mid - 1);
        dfs(mid, end);
        sb.append(number).append("\n");

    }

}