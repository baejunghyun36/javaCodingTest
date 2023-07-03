import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<int []> timeQueue;
    static PriorityQueue<Integer> endTimeQueue;
    static int start, cnt, maxCnt;
    static int end =  2100000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        timeQueue = new PriorityQueue<>((o1, o2)-> {
            if(o1[0]==o2[0])return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        endTimeQueue = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            timeQueue.add(new int[]{s, e});
        }

        while(!timeQueue.isEmpty()){

            while(!endTimeQueue.isEmpty()&&timeQueue.peek()[0]>=endTimeQueue.peek()){
                endTimeQueue.poll();
            }
            int[] se = timeQueue.poll();
            endTimeQueue.add(se[1]);
            if(maxCnt==endTimeQueue.size()) if(end==se[0])end = se[1];
            if(maxCnt<endTimeQueue.size()){
                start = se[0];
                end = endTimeQueue.peek();
                maxCnt = endTimeQueue.size();
            }
        }
        sb.append(maxCnt).append("\n").append(start).append(" ").append(end);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }


}