import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k;
    static long [] segementTree, info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        info = new long[n+1];
        segementTree = new long[n * 4];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            info[i] = x;
        }

        segementTreeInit(1, 1, n);


        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==1){
                segementTreeUpdate(b, c, 1, n, 1);

            }
            else{
                sb.append(segementTreeMultiplication(b, c, 1, n, 1)%1000000007).append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }


    static long segementTreeInit(int index, int start, int end){

        if(start==end) return segementTree[index] = info[start];
        long leftValue = segementTreeInit(index * 2, start, (start + end) / 2);
        long rightValue = segementTreeInit(index * 2 + 1, (start + end) / 2 + 1, end);
        return segementTree[index] = (leftValue * rightValue)%1000000007;
    }

    static long segementTreeUpdate(int targetIndex, int targetNumber, int start, int end, int segementIndex){


        if(targetIndex<start || targetIndex>end) return segementTree[segementIndex];
        if(start == end){
            return segementTree[segementIndex] = targetNumber;
        }
        int mid = (start + end) / 2;
        return segementTree[segementIndex] = (segementTreeUpdate(targetIndex, targetNumber, start, mid, segementIndex*2)*
                segementTreeUpdate(targetIndex, targetNumber, mid+1, end, segementIndex*2+1))% 1000000007;

    }


    static long segementTreeMultiplication(int targetStart, int targetEnd, int start, int end, int index){
        if(end<targetStart|| start>targetEnd) return 1;
        if(start>=targetStart && end <=targetEnd) return segementTree[index];
        long leftValue = segementTreeMultiplication(targetStart, targetEnd, start, (start + end) / 2, index * 2);
        long rightValue = segementTreeMultiplication(targetStart, targetEnd, (start + end) / 2 + 1, end, index * 2 + 1);
        return (leftValue*rightValue)%1000000007;
    }
}


/*
4 1 2
1000000
1000000
1000000
1000000
2 1 4
1 2 1
2 1 4


49000000
49






5 5 6
234235
34523
32425
76545
976566
2 1 5
1 4 999999
2 1 5
1 5 999999
2 1 5
1 3 999999
2 1 5
1 2 999999
2 1 5
1 1 999999
2 1 5

A)
277680725
763478291
995445806
88752617
691380465
759727496
* */