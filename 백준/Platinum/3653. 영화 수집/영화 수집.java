import java.io.*;
import java.util.*;

public class Main {
    static int testCase;
    static int n, m;
    static int [] segementTree;
    static int top;
    static Map<Integer, Integer> bookIndex;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            top = m-1;
            bookIndex = new HashMap<>();
            segementTree = new int[(n + m) * 4];
            initSegementTree(1, 0, n + m - 1, m, n + m - 1);
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < m; i++) {
                int number = Integer.parseInt(st.nextToken());
                int index = bookIndex.get(number);
                sb.append(find(1, 0, n + m - 1, 0, index - 1)).append(" ");
                remove(1, 0, n + m - 1, index);
                update(1, 0, n + m - 1, top);
                bookIndex.put(number, top--);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    static void update(int index, int start, int end, int des) {
        if (start == end) {
            segementTree[index]++;
            return;
        }
        int mid = (start+end)/2;
        if(start<=des&&mid>=des) update(index*2, start, mid, des);
        if(mid+1<=des&&end>=des) update(index*2+1, mid+1, end, des);
        segementTree[index]++;
    }

    static void remove(int index, int start, int end, int des) {
        if (start == end) {
            segementTree[index]--;
            return;
        }
        int mid = (start+end)/2;
        if(start<=des&&mid>=des) remove(index*2, start, mid, des);
        if(mid+1<=des&&end>=des) remove(index*2+1, mid+1, end, des);
        segementTree[index]--;
    }
    
    static int find(int index, int start, int end, int left, int right) {
        if(right<start||left>end) return 0;
        if (left <= start && end <= right) {
            return segementTree[index];
        }
        int mid = (start+end)/2;
        int a = find(index*2, start, mid, left, right);
        int b = find(index * 2 + 1, mid + 1, end, left, right);
        return a + b;
    }

    static int initSegementTree(int index, int start, int end, int left, int right){
        if(right<start||left>end) return 0;
        if (start == end) {
            segementTree[index] = 1;
            bookIndex.put(start - m + 1, start);
            return 1;
        }

        int mid = (start+end)/2;
        int a = initSegementTree(index*2, start, mid, left, right);
        int b = initSegementTree(index * 2 + 1, mid + 1, end, left, right);
        return segementTree[index] = a + b;
    }
}