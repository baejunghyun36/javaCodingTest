import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minHeap = new PriorityQueue<>();

        n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int x = Integer.parseInt(br.readLine());
            if(maxHeap.size()==minHeap.size()) maxHeap.add(x);
            else minHeap.add(x);
            if(!minHeap.isEmpty()&&minHeap.peek()<maxHeap.peek()){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(minHeap.poll());
            }

            sb.append(maxHeap.peek()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}