import java.io.*;
import java.util.*;

public class Main {

    static int [] A, B;
    static int t, n, m;
    static Map <Integer, Integer> numberExistenceMap;
    static int []cumulativeSumA, cumulativeSumB;
    static long answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());

        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        cumulativeSumA = new int[n + 1];
        A = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        cumulativeSumB = new int[m + 1];
        B = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) B[i] = Integer.parseInt(st.nextToken());
        numberExistenceMap = new HashMap<>();

        cumlativeSum();
        initExistenceMap();
        calculate();
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void cumlativeSum(){

        for (int i = 1; i <= n; i++) cumulativeSumA[i] = cumulativeSumA[i - 1] + A[i];
        for (int i = 1; i <= m; i++) cumulativeSumB[i] = cumulativeSumB[i - 1] + B[i];
    }

    static void initExistenceMap(){

        numberExistenceMap = new HashMap<>();

        for(int i=1; i<=m; i++){
            for(int j=i-1; j>=0; j--){
                int number = cumulativeSumB[i] - cumulativeSumB[j];
                numberExistenceMap.put(number, numberExistenceMap.getOrDefault(number, 0) + 1);
            }
        }
    }

    static void calculate(){

        for(int i=1; i<=n; i++){
            for(int j=i-1; j>=0; j--){
                int number = t - (cumulativeSumA[i] - cumulativeSumA[j]);
                answer+=numberExistenceMap.getOrDefault(number, 0);
            }
        }
    }
}