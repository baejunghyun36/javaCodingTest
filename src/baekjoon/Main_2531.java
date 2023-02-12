import java.io.*;
import java.util.StringTokenizer;

public class Main_2531 {


    static int N, seqDish,totalType, cuponNumber;
    static int [] info;
    static int [] riceType;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        totalType = Integer.parseInt(st.nextToken());
        seqDish = Integer.parseInt(st.nextToken());
        cuponNumber = Integer.parseInt(st.nextToken());
        info = new int[N];
        riceType = new int[totalType+1];
        int answer = 0;
        for(int i=0; i<N; i++) info[i] = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int i=0; i<seqDish; i++){
            if(riceType[info[i]]==0)cnt++;
            riceType[info[i]]++;
        }
        answer = cnt;
        int end = seqDish;
        for(int i=0; i<N-1; i++){
            if(riceType[info[i]]==1) cnt--;
            riceType[info[i]]--;
            if(riceType[info[end%N]]==0) cnt++;
            riceType[info[end%N]]++;
            if(riceType[cuponNumber]==0)answer = Math.max(cnt+1,answer);
            else answer = Math.max(cnt, answer);
            end++;
        }


        //대규모 시스템 설계

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
