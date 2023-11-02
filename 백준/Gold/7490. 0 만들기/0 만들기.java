import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int testCase;
    static int n;
    static char [] num;
    static char [] op;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            n = Integer.parseInt(br.readLine());
            num = new char[n + 1];
            op = new char[n + 1];
            dfs(1, 1, 1, 0, "1");
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static void dfs(int level, int num, int sign, int sum , String s){
        if (level == n) {
            sum = sum + (num * sign);
            if(sum==0) sb.append(s + "\n");
            return;
        }

        dfs(level + 1, num*10+(level+1), sign, sum,  s+' '+(level+1));
        dfs(level + 1 , level+1, 1, sum+(num*sign),  s+'+'+(level+1));
        dfs(level + 1, level+1, -1, sum+(num*sign),  s+'-'+(level+1));
    }
}