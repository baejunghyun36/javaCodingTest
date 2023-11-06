import java.io.*;
import java.util.*;

public class Main {


    static int n, m;
    static int [][] segementTree;
    static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        segementTree = new int[n * 3][2];
        initSegementTree(1, 1, n);
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (type == 2) {
                int[] temp = searchTree(1, 1, n, a, b);
                sb.append(temp[0]).append("\n");
            }
            else{
                updateTree(1,1, n, a, b );
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] searchTree(int index, int start, int end, int left, int right) {

        if(right < start || left > end) return new int[]{1000000000, 1000000000};
        if (left <= start && right >= end) {
            return segementTree[index];
        }
        int mid = (start+end)/2;
        int [] t1 = searchTree(index * 2, start, mid, left, right);
        int [] t2 = searchTree(index * 2 + 1, mid + 1, end, left, right);
        if (t1[1] > t2[1]) return t2;
        else if (t1[1] < t2[1])  return t1;
        else {
            if (t1[0] < t2[0]) return t1;
            else return t2;
        }
    }

    static int [] updateTree(int index, int start, int end, int destination, int updateNumber) {

        if(destination<start||destination>end)return segementTree[index];
        if(start==end) {
            segementTree[index][0] = destination;
            arr[start] = segementTree[index][1] = updateNumber;
            return segementTree[index];
        }
        int mid = (start+end)/2;
        int [] t1 = updateTree(index * 2, start, mid, destination, updateNumber);
        int [] t2 = updateTree(index*2+1, mid+1, end, destination, updateNumber);
        change(t1, t2, index);
        return segementTree[index];
    }

    static int[] initSegementTree(int index, int start, int end) {

        if (start == end) {
            segementTree[index][0] = start;
            segementTree[index][1] = arr[start];
            return segementTree[index];
        }
        int mid = (start+end)/2;
        int [] t1 = initSegementTree(index*2, start, mid);
        int [] t2 = initSegementTree(index * 2 + 1, mid + 1, end);
        change(t1, t2, index);
        return segementTree[index];
    }

    static void change(int[] t1, int []t2, int index) {
        if (t1[1] > t2[1]) {
            segementTree[index][0] = t2[0];
            segementTree[index][1] = t2[1];
        } else if (t1[1] < t2[1]) {
            segementTree[index][0] = t1[0];
            segementTree[index][1] = t1[1];
        } else {
            segementTree[index][1] = t2[1];
            if (t1[0] < t2[0]) segementTree[index][0] = t1[0];
            else segementTree[index][0] = t2[0];
        }
    }
}