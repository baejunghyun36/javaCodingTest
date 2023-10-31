import java.io.*;
import java.util.*;

public class Main {

    static int testCase;
    static int n;
    static int [] preorder;
    static Map <Integer, Integer> indexOfNumber;
    static int postIndex;
    static int preIndex;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        testCase = Integer.parseInt(st.nextToken());

        while (testCase-- > 0) {
            n = Integer.parseInt(br.readLine());
            preorder = new int[n];
            indexOfNumber = new HashMap<>();
            preIndex = postIndex = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) preorder[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) indexOfNumber.put(Integer.parseInt(st.nextToken()), i);
            makePostorder(0, n-1);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void makePostorder(int start, int end) {

        if (preIndex >= n) return;

        int cur = preorder[preIndex];
        int mid = indexOfNumber.get(cur);
        if (start < mid) {
            preIndex++;
            makePostorder(start, mid-1);
        }
        if (mid < end) {
            preIndex++;
            makePostorder(mid + 1, end);
        }
        sb.append(cur).append(" ");
    }
}