import java.io.*;
import java.util.*;

public class Main {

    static Queue<Integer> q;
    static int n;
    static int[] reverseIndex = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        q = new LinkedList<>();
        n = Integer.parseInt(st.nextToken());
        q.add(n);
        int cnt = 0;
        out:while (!q.isEmpty()) {
            int size = q.size();
            while(size-->0){
                int x = q.poll();
                if(x==1)break out;
                if(x%3==0&&reverseIndex[x/3]==0){
                    reverseIndex[x/3] = x;
                    q.add(x/3);
                }
                if(x%2==0&&reverseIndex[x/2]==0){
                    reverseIndex[x/2] = x;
                    q.add(x/2);
                }
                if(reverseIndex[x-1]==0)reverseIndex[x-1] = x;
                q.add(x - 1);
            }
            cnt++;
        }
        int x = 1;
        ArrayList<Integer> answer = new ArrayList<>();

        while(reverseIndex[x]!=0){
            answer.add(x);
            x = reverseIndex[x];
        }
        answer.add(n);
        sb.append(cnt + "\n");
        Collections.sort(answer, Collections.reverseOrder());
        for (int value : answer) {
            sb.append(value).append(" ");
        }



        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}