import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2457 {
  static int [] month = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
  static int end = 274;
  static int cnt;
  static boolean flag;
  static PriorityQueue<Flower> pq;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    pq = new PriorityQueue<>();
    int n = Integer.parseInt(st.nextToken());
    for(int i= 0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      int m1 = Integer.parseInt(st.nextToken());
      int d1 = Integer.parseInt(st.nextToken());
      int m2 = Integer.parseInt(st.nextToken());
      int d2 = Integer.parseInt(st.nextToken());
      int day1 = -60 + month[m1-1] + d1 >= 0 ? -60 + month[m1-1] + d1 : 0;
      int day2 = -61 + month[m2-1] + d2 >= 0 ? -61 + month[m2-1] + d2 : 0;
      pq.add(new Flower(day1, day2));
    }

    if(pq.peek().start==0){
      while(!pq.isEmpty()){
        cnt++;
        Flower flower = pq.poll();
        if(flower.end>=end)break;
        int max = 0;
        Flower temp = null;
        while(!pq.isEmpty()&&pq.peek().start<=flower.end+1){
          Flower f = pq.poll();
          if(f.end>max){
            temp = f;
            max = f.end;
          }
        }
        if(temp==null){
          flag = true;
          break;
        }
        pq.add(temp);
      }
    }

    if(flag)sb.append(0);
    else sb.append(cnt);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  static class Flower implements Comparable<Flower>{

    int start;
    int end;

    public Flower(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Flower o) {
      if(this.start==o.start) return (o.end - o.start)-(this.end - this.start);
      return this.start - o.start;
    }
  }
}
