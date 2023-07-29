import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {


    static int n;
    static int [] visited;
    static int [] numberArray;
    static int maxNumber = Integer.MIN_VALUE;
    static PriorityQueue<Integer> minHeap, maxHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        n = Integer.parseInt(st.nextToken());
        numberArray = new int[n];
        for (int i = 0; i < n; i++) {
            numberArray[i] = Integer.parseInt(br.readLine());
            if(numberArray[i]>0) maxHeap.add(numberArray[i]);
            else minHeap.add(numberArray[i]);
        }
        /*
        * 1. 양수 가장 큰 값끼리 곱해
        * 2. 음수 가장 작은 값끼리 곱해
        * 3. 음수에서 0이 나오면 음수 0으로 없애
        * 4. 양수에서 만약에 1이 나오면 그냥 더해
        * */
        int answer = 0;
        while (!maxHeap.isEmpty()) {
            int a = maxHeap.poll();
            int b = 0;
            if (!maxHeap.isEmpty()) b = maxHeap.poll();
            else {
                answer+= a;
                break;
            }
            if(a==1||b==1)  answer+=a+b;

            else answer += a*b;
        }
        while (!minHeap.isEmpty()) {
            int a = minHeap.poll();
            int b = 1;
            if (!minHeap.isEmpty()) b = minHeap.poll();
            answer += (a * b);
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}