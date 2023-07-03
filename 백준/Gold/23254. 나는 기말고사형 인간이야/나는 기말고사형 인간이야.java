import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static PriorityQueue<Subject> pq;
    static int n, m;
    static int time;
    static int [] score;
    static int [] scorePerTime;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        pq = new PriorityQueue<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        time = n*24;

        score = new int[m];
        scorePerTime = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) score[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)scorePerTime[i] = Integer.parseInt(st.nextToken());
        for(int i=0; i<m; i++){
            if(score[i]==100)answer+=100;
            else pq.add(new Subject(score[i], scorePerTime[i]));
        }

        while(time-->0&&!pq.isEmpty()){

            Subject s = pq.poll();
            if(s.score+s.scorePerTime>100){
                time++;
                pq.add(new Subject(s.score, 100-s.score));
            }
            else if(s.score+s.scorePerTime==100) answer+=100;
            else pq.add(new Subject(s.score+s.scorePerTime, s.scorePerTime));
        }
        while(!pq.isEmpty()){
            answer += pq.poll().score;
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Subject implements Comparable<Subject> {

        int score;
        int scorePerTime;

        public Subject(int score, int scorePerTime) {
            this.score = score;
            this.scorePerTime = scorePerTime;

        }
        public int compareTo(Subject s){

            if(s.scorePerTime == this.scorePerTime){
                return this.score - s.score;
            }
            return s.scorePerTime - this.scorePerTime;
        }
    }


}