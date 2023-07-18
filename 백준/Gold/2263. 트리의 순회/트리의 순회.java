import java.io.*;
import java.util.*;

public class Main {
    static int n;
//    static List<Integer> inOrder, postOrder,
    static List<Integer> preOrder;
    static int [] inOrder, postOrder;
    static Map<Integer, Integer> inOrderIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
 /*       inOrder = new ArrayList<>();
        postOrder = new ArrayList<>();
        preOrder = new ArrayList<>();*/

        inOrderIndex = new HashMap<>();
        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) inOrderIndex.put(Integer.parseInt(st.nextToken()), i);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) postOrder[i] = Integer.parseInt(st.nextToken());

        dfs(0, n-1, 0, n-1);

        for(int i=0; i<preOrder.size(); i++) sb.append(preOrder.get(i)).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int inStart, int inEnd, int postStart, int postEnd) {

        if(inEnd<inStart||postEnd<postStart)return;
        preOrder.add(postOrder[postEnd]);
        int rootIndex = inOrderIndex.get(postOrder[postEnd]);
        int cnt = rootIndex - inStart;
        dfs(inStart, rootIndex-1, postStart, postStart+cnt-1);
        dfs(rootIndex+1, inEnd, postStart+cnt, postEnd-1);
    }
}