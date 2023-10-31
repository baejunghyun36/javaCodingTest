import java.io.*;
import java.util.*;

public class Main {

    static int testCase;
    static int n;
    static int [] preorder, inorder, postorder;
    static Map <Integer, Integer> indexOfNumber;
    static int postIndex;
    static int preIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {

            n = Integer.parseInt(br.readLine());

            preorder = new int[n];
            inorder = new int[n];
            postorder = new int[n];
            indexOfNumber = new HashMap<>();
            preIndex = postIndex = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                preorder[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                inorder[i] = Integer.parseInt(st.nextToken());
                indexOfNumber.put(inorder[i], i);
            }
            makePostorder(preorder[0], 0, n-1);
            for (int i = 0; i < n; i++) {
                sb.append(postorder[i]).append(" ");
            }
            sb.append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void makePostorder(int curNumber, int start, int end) {

        if(start>end) {
            preIndex--;
            return;
        }
        if (start == end) {
            postorder[postIndex++] = inorder[start];
            return;
        }
        int mid = indexOfNumber.get(curNumber);
        if(preIndex<n-1)makePostorder(preorder[++preIndex], start, mid-1);
        if(preIndex<n-1)makePostorder(preorder[++preIndex], mid + 1, end);
        postorder[postIndex++] = curNumber;
    }
}