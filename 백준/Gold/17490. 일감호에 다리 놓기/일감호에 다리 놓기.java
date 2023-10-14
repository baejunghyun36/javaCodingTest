import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static long k;
    static int [] stoneOfPoint;
    static int [] impossible;
    static Map<Integer, Integer> minStoneOfArea;
    static long stoneCount;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());

        minStoneOfArea = new HashMap<>();
        stoneOfPoint = new int[n];
        impossible = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) stoneOfPoint[i] = Integer.parseInt(st.nextToken());
        int start = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int[] arr = new int[]{a, b};
            Arrays.sort(arr);
            if (arr[0] == 0 && arr[1] == n-1) {
                impossible[arr[0]] = 1;
                start = arr[0];
            }
            else {
                impossible[arr[1]] = 1;
                start = arr[1];
            }
        }
        if(m>1){
            solution(start);
            output();
        }
        else sb.append("YES");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void solution(int start){

        int prev = start;
        int offset = 0;

        while(offset<n){
            int i = (start + offset) % n;
            if(impossible[i]==1) prev = i;
            minStoneOfArea.putIfAbsent(prev, stoneOfPoint[prev]);
            minStoneOfArea.put(prev, Math.min(minStoneOfArea.get(prev), stoneOfPoint[i]));
            offset++;
        }
    }

    static void output(){

        for (int key : minStoneOfArea.keySet()) stoneCount += minStoneOfArea.get(key);

        if(stoneCount<=k)sb.append("YES");
        else sb.append("NO");
    }

    /*
    *
3 1 0
1 1 1
1 2
    * */
}