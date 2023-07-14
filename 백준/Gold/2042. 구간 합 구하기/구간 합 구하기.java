import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {


    static int n, m, k;
    static long [] info, tree;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        info = new long[n + 1];
        tree = new long[n * 4];

        for(int i=1; i<=n; i++) info[i] = Long.parseLong(br.readLine());

        segementTree(1, n, 1);

        for(int j=0; j<m+k; j++){

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a==1) segementTreeEdit(1, n, b, c, 1);
            else sb.append(segementTreeSum(1, n, b, (int)c, 1)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static long segementTreeSum(int start, int end, int a, int b, int index) {


        int leftEnd = (start+end)/2;
        int rightStart = leftEnd + 1;

        if(start==a&&end==b) return tree[index];
        long sum = 0;
        if(b<=leftEnd) sum+=segementTreeSum(start, leftEnd, a, b, index*2);
        else if(rightStart<=a) sum+=segementTreeSum(rightStart, end, a, b, index*2+1);
        else{
            sum+=segementTreeSum(start, leftEnd, a, leftEnd, index*2);
            sum+=segementTreeSum(rightStart, end, rightStart, b, index*2+1);
        }
        return sum;
    }


    static long segementTreeEdit(int start, int end, int b, long c, int index) {


        int leftEnd = (start+end)/2;
        int rightStart = leftEnd + 1;
        if(start==end){

            long dif = c - info[b];
            info[b] = tree[index] = c;
            return dif;
        }
        long dif = 0;
        if(b<=leftEnd) dif = segementTreeEdit(start, leftEnd, b, c, index * 2);
        else dif = segementTreeEdit(rightStart, end, b, c, index * 2 + 1);
        tree[index] += dif;
        return dif;

    }


    static long segementTree(int start, int end, int index){

        if(start==end) return tree[index] = info[start];
        long leftValue = segementTree(start, (start+end)/2, index*2);
        long rightValue = segementTree((start + end) / 2 + 1, end, index * 2 + 1);
        return tree[index] = leftValue + rightValue;

    }
}