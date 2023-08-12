import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int [] in;
    static Queue<Integer> q;
    static ArrayList<Integer> [] list;
    static int [] weight;
    static int [] seconds;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        list = new ArrayList [n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();

        in = new int[n+1];
        q = new LinkedList<>();
        weight = new int[n + 1];
        seconds = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            int w = 0;
            while (st.hasMoreTokens()) {
                if(cnt==0){
                    w = Integer.parseInt(st.nextToken());
                    weight[i] = w;
                    cnt = 1;
                }
                else{
                    int num = Integer.parseInt(st.nextToken());
                    if(num==-1)break;
                    list[num].add(i);
                    in[i]++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if(in[i]==0){
                seconds[i] = weight[i];
                q.add(i);
            }
        }


        while (!q.isEmpty()) {
            int num = q.poll();
            for (int i = 0; i < list[num].size(); i++) {
                int next = list[num].get(i);
                seconds[next] = Math.max(seconds[num],seconds[next]);
                in[next]--;
                if(in[next]==0){
                    seconds[next] = seconds[next] + weight[next];
//                    System.out.println("next : " + next );
                    q.add(next);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(seconds[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}