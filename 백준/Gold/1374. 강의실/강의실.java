import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<Lecture> q;
    static PriorityQueue<Integer> endTime;
    static int n;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        endTime = new PriorityQueue<>();
        q = new PriorityQueue<>((o1, o2)-> {
            return o1.startTime - o2.startTime;
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            q.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        minRoomCheck();

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void minRoomCheck(){

        while (!q.isEmpty()) {
            Lecture lec = q.poll();
            if (!endTime.isEmpty() && endTime.peek() <= lec.startTime) {
                answer = Math.max(answer, endTime.size());
                while (!endTime.isEmpty() && endTime.peek() <= lec.startTime) {
                    endTime.poll();
                }
            }
            endTime.add(lec.endTime);
        }
        answer = Math.max(answer, endTime.size());
    }

    static class Lecture {

        int startTime;
        int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}