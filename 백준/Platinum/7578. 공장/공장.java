import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long answer;
    static Map<Integer, Integer> fromToIndex;
    static int [] from;
    static long [] segementTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        segementTree = new long[n * 4];
        from = new int[n];
        fromToIndex = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            from[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            fromToIndex.put(key, i);
        }
        for (int i = 0; i < n; i++) {
            answer += getCrossPoint(1, 0, n - 1, fromToIndex.get(from[i]) + 1, n-1);
            updateSegement(1, 0, n - 1, fromToIndex.get(from[i]));
//            System.out.println(Arrays.toString(segementTree));
        }
        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static long getCrossPoint(int index, int start, int end, int left, int right) {

        if(start>right||left>end) return 0;
        if (left <= start && right >= end) {
            return segementTree[index];
        }
        int mid = (start+end)/2;
        long a = getCrossPoint(index * 2, start, mid, left, right);
        long b = getCrossPoint(index * 2 + 1, mid + 1, end, left, right);
        return a + b;
    }

    static void updateSegement(int index, int start, int end, int destination) {

        if(start>destination||destination>end) return;
        if (start == end && start == destination) {
            ++segementTree[index];
            return;
        }
        int mid = (start+end)/2;
        updateSegement(index * 2, start, mid,  destination);
        updateSegement(index * 2 + 1, mid + 1, end, destination);
        segementTree[index]++;
        return;
    }

}