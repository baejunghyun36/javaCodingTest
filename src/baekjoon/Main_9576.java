import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_9576 {
  static int n, m;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int testCase = Integer.parseInt(st.nextToken());
    for(int t = 1; t<=testCase; t++){

      st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      PriorityQueue<Node> q = new PriorityQueue<>();
      for(int i = 0; i<m; i++){
        st = new StringTokenizer(br.readLine());
        q.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
      }

      int cnt = 0;
      while(!q.isEmpty()){
        cnt++;
        Node node = q.poll();
        while(!q.isEmpty()&&q.peek().a==node.a){
          Node temp = q.poll();
          temp.a++;
          if(temp.a>temp.b)continue;
          q.add(temp);
        }
      }
      sb.append(cnt).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }


  static class Node implements Comparable<Node>{

    int a;
    int b;

    public Node(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public int compareTo(Node o) {
      if(this.a == o.a) return this.b - o.b;
      return this.a- o.a;
    }
  }
}
