import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int [] tree;
    static int endPoint = 1000000;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tree = new int[endPoint * 4];
        int nn = n;
 
        while (nn-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                find(1, endPoint, 1, b);
            }
            else{
                int c = Integer.parseInt(st.nextToken());
                updateTree(1, endPoint, 1, b, c);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int find(int left, int right, int index, int target){

        tree[index]--;
        if(left==right) {
            sb.append(left).append("\n");
            return left;
        }
        int mid = (left+right)/2;
        if(tree[index*2]>=target){
            return find(left, mid, index * 2, target);
        }
        else return find(mid + 1, right, index * 2 + 1, target - tree[index * 2]);
    }


    static void updateTree(int start, int end, int index, int mid, int cnt){

        if(mid<start||mid>end)return;
        tree[index] +=cnt;
        if (start == mid && end == mid) {
            return ;
        }
//        System.out.println(start + " " + end+ " tree : " +tree[index]);
        updateTree(start, (start+end)/2, index*2, mid, cnt);
        updateTree((start+end)/2+1, end, index*2+1, mid, cnt);
    }
}