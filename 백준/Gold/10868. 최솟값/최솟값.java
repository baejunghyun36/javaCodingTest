import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int [] tree;
    static int [] arr;
    public static void main(String[] args) throws IOException {

        //https://blog.naver.com/ndb796/221282210534 개념 공부 

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tree = new int[(int)Math.pow(2, 19)];
        arr = new int[n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        segmentTree(1, n, 1);

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(segementSearch(1, n, a, b, 1)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int segementSearch(int start, int end, int a, int b, int index) {


        if(start==a&&end==b)return tree[index];

        int leftEnd = (start+end)/2;
        int rightStart = leftEnd +1;
        int x = 1987654321;
        if(leftEnd>=b){
            x = Math.min(segementSearch(start, leftEnd, a, b, index*2), x);
        }
        else if(rightStart<=a){
            x = Math.min(segementSearch(rightStart, end, a, b, index*2+1), x);
        }
        else{
            x = Math.min(segementSearch(start, leftEnd, a, leftEnd, index*2), x);
            x = Math.min(segementSearch(rightStart, end, rightStart, b, index*2+1), x);

        }
        return x;
    }



    static int segmentTree(int start, int end, int index){

        if(start==end) return tree[index]=arr[start];
        int leftValue = segmentTree(start, (start+end)/2, index*2);
        int rightValue = segmentTree((start + end) / 2 + 1 , end, index * 2 + 1);
        tree[index] = Math.min(leftValue , rightValue);
        return tree[index];
    }
}