import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1736 {
  static int m, n;
  static PriorityQueue<Info> q;
  static PriorityQueue<Info>  temp;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    q = new PriorityQueue<>();
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<n; j++) if (Integer.parseInt(st.nextToken()) == 1) q.add(new Info(i, j));
    }
    int cnt = 0;
    while(!q.isEmpty()){
      temp = new PriorityQueue<>();
      Info prev = q.poll();
      while(!q.isEmpty()){
        Info cur = q.poll();
        if(prev.x<=cur.x)prev = cur;
        else temp.add(cur);
      }
      cnt++; q = temp;
    }
    System.out.println(cnt);
  }

  static class Info implements Comparable <Info> {

    int y;
    int x;

    public Info(int y, int x) {
      this.y = y;
      this.x = x;
    }

    @Override
    public int compareTo(Info o) {
      if(this.y==o.y) return this.x - o.x;
      return this.y - o.y;
    }
  }
}
