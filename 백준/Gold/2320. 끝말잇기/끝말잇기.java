import java.io.*;
import java.util.*;

public class Main {

    static int [][] dp;
    static int n;
    static int answer;
    static ArrayList<Str> words;
    static String cmp = "AIEOU";
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        words = new ArrayList<>();
        dp = new int[1<<n][5];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words.add(new Str(i, word.charAt(0), word.charAt(word.length() - 1), word.length()));
        }
        for (int i = 0; i < 5; i++) {
            dfs(0, 0, cmp.charAt(i));
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int visited, int length, char end){
        int endNum = changeToNumber(end);
        if(dp[visited][endNum]!=0) return;
        answer = Math.max(dp[visited][endNum] = length, answer);
        for (int i = 0; i < n; i++) {
            if((visited&(1<<i))==0&&end==words.get(i).start){
                dfs(visited | (1 << i), length + words.get(i).length, words.get(i).end);
            }
        }
        return;
    }

    static int changeToNumber(char end){
        if(end=='A') return 0;
        else if(end == 'I') return 1;
        else if (end =='E') return 2;
        else if (end =='O') return 3;
        else return 4;
    }


    static class Str {
        int idx;
        char start;
        char end;
        int length;

        public Str(int idx, char start, char end, int length) {
            this.idx = idx;
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
}