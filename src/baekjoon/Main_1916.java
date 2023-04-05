import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916 {

  static int vertex;
  static int n;
  static int s, e;
  static int dis[][];
  static PriorityQueue<Node> q;
  static int []visited;
  static final int inf = 987654321;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    vertex = Integer.parseInt(br.readLine());
    n = Integer.parseInt(br.readLine());
    visited = new int[vertex+1];
    dis = new int[vertex+1][vertex+1];
    for (int i = 1; i <= vertex; i++) {
      Arrays.fill(dis[i], inf);
    }
    q = new PriorityQueue<>();
    StringTokenizer st = null;
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      dis[s][e] = Math.min(dis[s][e], w);
    }

    st = new StringTokenizer(br.readLine());
    s = Integer.parseInt(st.nextToken());
    e = Integer.parseInt(st.nextToken());

    visited[s] = 1;
    for(int i=1; i<=vertex; i++){
      if(i!=s&&dis[s][i]!=inf)q.add(new Node(dis[s][i], i));
    }
    while(!q.isEmpty()){
      Node node = q.poll();
      int curVertex = node.to;
      if(visited[curVertex]==1)continue;
      visited[curVertex] = 1;
      for(int i=1; i<=vertex; i++){
        if(visited[i]==1||i==curVertex)continue;
        if(dis[s][i]> dis[s][curVertex] + dis[curVertex][i]){
          dis[s][i] = dis[s][curVertex] + dis[curVertex][i];
          q.add(new Node(dis[s][i], i));
        }
      }
    }
    if(s==e)sb.append(0);
    else sb.append(dis[s][e]);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static class Node implements Comparable<Node>{

    int w;
    int to;
    @Override
    public int compareTo(Node o) {
      return this.w - o.w;
    }
    public Node(int w, int to) {
      this.w = w;
      this.to = to;
    }
  }
}
