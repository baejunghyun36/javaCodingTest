import java.io.*;
import java.util.StringTokenizer;

public class Main {

    //두번째 풀이 - 스택없이  
    //answer type long
    
    static int [] dp;
    static int [] index;
    static int [] arr;
    static int n;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        dp = new int[n];
        index = new int[n];
        arr = new int[n];

        dp[n-1] = 0;
        index[n-1] = -1;

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());
        for(int i=n-2; i>=0; i--) dfs(i, i+1);
        for(int i=0; i<n; i++) answer+=dp[i];

        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int curIndex, int prev){

        if(prev==-1){
            index[curIndex] = -1;
            return;
        }
        if(arr[curIndex]<=arr[prev]) index[curIndex] = prev;
        else{
            dp[curIndex] += dp[prev] +1;
            dfs(curIndex, index[prev]);
        }
    }

}