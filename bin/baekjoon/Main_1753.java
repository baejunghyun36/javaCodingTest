
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753 {

  static ArrayList<Node> [] list;
  static int n, m;
  static int start;
  static int [] dist;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    start = Integer.parseInt(br.readLine());


    list = new ArrayList[n+1];
    for(int i=1; i<=n; i++){
      list[i] = new ArrayList<>();
    }
    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      list[a].add(new Node(w, b));
    }
    dijkstra();
    for(int i=1; i<=n; i++){
      if(dist[i]==987654321)sb.append("INF\n");
      else sb.append(dist[i]+"\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static void dijkstra(){
    dist = new int [n+1];
    Arrays.fill(dist, 987654321);
    dist[start] = 0;
    int [] visited = new int[n+1];

    PriorityQueue<Node> q = new PriorityQueue<>();
    q.add(new Node(0, start));
    while(!q.isEmpty()){

      Node node = q.poll();
      int cur = node.to;
      int w = node.w;
      if(visited[cur]==1)continue;
      visited[cur] = 1;
      for(int i=0; i<list[cur].size(); i++){
        Node next = list[cur].get(i);
        if(dist[next.to] > w + next.w ){
          dist[next.to] = w + next.w;
          q.add(new Node(dist[next.to], next.to));
        }
      }
    }
  }
  static class Node implements Comparable<Node>{

    int w;
    int to;

    public Node(int w, int to) {
      this.w = w;
      this.to = to;
    }

    @Override
    public int compareTo(Node o) {
      return this.w - o.w;
    }
  }
}
