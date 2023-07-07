import java.io.*;
import java.util.*;

public class Main {

    static int testCase;
    static int n;
    static PriorityQueue <Integer> minHeap;
    static PriorityQueue <Integer> maxHeap;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            maxHeap = new PriorityQueue<>((o1, o2)-> o2 - o1);
            minHeap = new PriorityQueue<>();
            sb.append(n / 2 + 1).append("\n");
            int number = 0;
            for(int i=1; i<=n; i++){
                if(i%10==1) st = new StringTokenizer(br.readLine());
                number = Integer.parseInt(st.nextToken());
                if(maxHeap.size()<=minHeap.size()) maxHeap.add(number);
                else minHeap.add(number);
                if (!minHeap.isEmpty()&&maxHeap.peek() > minHeap.peek()) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(maxHeap.poll());
                }
                if(i%2==1) sb.append(maxHeap.peek()).append(" ");
                if(i%20==0){
                    sb.append("\n");
                }

            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}