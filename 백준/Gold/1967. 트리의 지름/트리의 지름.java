import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<int []> [] list;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b, c});
        }

        dfs(1);

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int cur){
        if(list[cur].size()==0)return 0;
        List<Integer> costList = new ArrayList<>();
        for (int i = 0; i < list[cur].size(); i++) {
            costList.add(dfs(list[cur].get(i)[0]) + list[cur].get(i)[1]);
        }
        Collections.sort(costList, (o1, o2) -> o2 - o1);
        if(costList.size()==1) answer = Math.max(answer, costList.get(0));
        if(costList.size()>=2) answer = Math.max(answer, costList.get(0) + costList.get(1));
        return costList.get(0);
    }
}