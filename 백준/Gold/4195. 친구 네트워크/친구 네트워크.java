import java.io.*;
import java.util.*;

public class Main {

    static int testCase;
    static int n;
    static Map<String, Integer> numberOfName;
    static Map<Integer, Integer> countOfRoot;
    static int [] parent;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = null;
        testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            n = Integer.parseInt(br.readLine());
            parent = new int[n * 2 + 1];
            numberOfName = new HashMap<>();
            countOfRoot = new HashMap<>();
            initParent();
            int number = 1;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                if(numberOfName.get(s1)==null) numberOfName.put(s1, number++);
                if(numberOfName.get(s2)==null) numberOfName.put(s2, number++);
                int a = numberOfName.get(s1);
                int b = numberOfName.get(s2);
                if(a<b) union(a, b);
                else union(b, a);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int num, boolean isA){

        if(parent[num]==num) return num;
        return parent[num] = find(parent[num], isA);
    }

    static void union(int a, int b){

        int parentA = find(a, true);
        int parentB = find(b, false);
        if(parentA!=parentB){
            parent[parentB] = parentA;
            countOfRoot.put(parentA, countOfRoot.getOrDefault(parentA, 1) + countOfRoot.getOrDefault(parentB, 1));
        }
        sb.append(countOfRoot.get(parentA)).append("\n");
    }

    static void initParent(){
        for(int i=0; i<2*n; i++)parent[i] = i;
    }
}