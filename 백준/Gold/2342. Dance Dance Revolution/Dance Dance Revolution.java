import java.io.*;
import java.util.*;

public class Main {

    static int [][][] dp;
    static ArrayList<Integer> seq;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        seq = new ArrayList<>();

        while(st.hasMoreTokens()){
            int number = Integer.parseInt(st.nextToken());
            if(number==0)break;
            seq.add(number);
        }

        int n = seq.size();
        dp = new int[n+1][5][5];
        for(int i=0; i<=n; i++){
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }

        dfs(0, 0, 0);
        sb.append(dp[0][0][0]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int index, int prevLeft, int prevRight){

        if(index==seq.size()) return 0;
        if(dp[index][prevLeft][prevRight]!=INF) return dp[index][prevLeft][prevRight];

        int num = seq.get(index);
        int leftCost = calculateCost(prevLeft, num);
        int rightCost = calculateCost(prevRight, num);

        return dp[index][prevLeft][prevRight] = Math.min(dfs(index + 1, num, prevRight) + leftCost, dfs(index + 1, prevLeft, num) + rightCost);
    }

    static int calculateCost(int prev, int num){

        int cost = 1;
        if(prev!= num){
            if(prev==0)cost++;
            if(prev==1||prev==3){
                if(num==2||num==4) cost += 2;
                else cost += 3;
            }
            if(prev==2||prev==4){
                if(num==1||num==3) cost +=2;
                else cost +=3;
            }
        }
        return cost;
    }
}
