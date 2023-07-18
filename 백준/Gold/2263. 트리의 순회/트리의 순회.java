import java.io.*;
import java.util.*;

public class Main {
    static int n;
//    static List<Integer> inOrder, postOrder,
    static List<Integer> preOrder;
    static int [] inOrder, postOrder;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
 /*       inOrder = new ArrayList<>();
        postOrder = new ArrayList<>();
        preOrder = new ArrayList<>();*/

        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) inOrder[i] = Integer.parseInt(st.nextToken());
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


//        System.out.println("아니 왔짜나 ㅡㅡㅡ ");
        if(inEnd<inStart||postEnd<postStart)return;
        int rootNumber = postOrder[postEnd];
        preOrder.add(rootNumber);
        int rootIndex = -1;
        int cnt = 0;
        for(int i=inStart; i<=inEnd; i++){
            if(rootNumber == inOrder[i]){
                rootIndex = i;
                break;
            }
            cnt++;
        }
        dfs(inStart, rootIndex-1, postStart, postStart+cnt-1);
        dfs(rootIndex+1, inEnd, postStart+cnt, postEnd-1);
    }
}