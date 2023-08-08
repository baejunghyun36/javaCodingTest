import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static char [] number;
    static int [] visited;
    static int answer;
    static CallInfo [] callInfos ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        callInfos = new CallInfo[n];
        visited = new int[10];
        number = new char[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char[] num = st.nextToken().toCharArray();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            callInfos[i] = new CallInfo(num, strike, ball);
        }

        bruteForce(0);

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void gameStart(){

        Map<Character, Integer> alpaIndex = new HashMap<>();
        for (int i = 0; i < 3; i++) alpaIndex.put(number[i], i);

        for (CallInfo callInfo : callInfos) {
            int ball = 0;
            int strike = 0;
            char [] temp = callInfo.callNumber;
            for (int i = 0; i < 3; i++) {
                if(alpaIndex.get(temp[i])==null)continue;
                if(alpaIndex.get(temp[i]) == i) strike ++;
                else ball++;
            }
            if(strike!= callInfo.strike ||ball!= callInfo.ball)return;
        }
        answer++;
    }

    static void bruteForce(int index){
        if(index==3){
            gameStart();
            return;
        }
        for(int i=1; i<=9; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            number[index] = (char)(i+'0');
            bruteForce(index + 1);
            visited[i] = 0;
        }
    }

    static class CallInfo {

        char [] callNumber;
        int strike;
        int ball;

        public CallInfo(char [] callNumber, int strike, int ball){
            this.callNumber = callNumber;
            this.strike = strike;
            this.ball = ball;
        }
    }
}