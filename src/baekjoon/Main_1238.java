import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238 {

  static int n,m,x;
  static int inf = 987654321;
  static PriorityQueue<Node> q;
  static int [] visited;
  static ArrayList<int[]> [] list1, list2;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());

    list1 = new ArrayList[n+1];
    list2 = new ArrayList[n+1];

    for (int i = 1; i <= n; i++) {
      list1[i] = new ArrayList<>();
      list2[i] = new ArrayList<>();
    }

    for(int i=0; i<m; i++){
      st = new StringTokenizer(br.readLine());
      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());
      list1[from].add(new int[]{to, cost});
      list2[to].add(new int[]{from, cost});
    }

    int [] dist1 = dijkstra(list1);
    int [] dist2 = dijkstra(list2);

    int answer = 0;
    for(int i=1; i<=n; i++){
      if(i!=x)answer = Math.max(answer, dist1[i]+dist2[i]);
    }

    sb.append(answer);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static int [] dijkstra (ArrayList<int[]> [] list){

    q = new PriorityQueue<>();
    q.add(new Node(0, x));

    visited = new int[n+1];
    int[]dist = new int[n+1];
    Arrays.fill(dist, inf);
    dist[x] = 0;

    while(!q.isEmpty()){
      Node node = q.poll();
      int cur = node.to;
      if(visited[node.to]==1)continue;
      visited[node.to] = 1;

      for(int i=0; i<list[node.to].size(); i++){
        int []next = list[cur].get(i);
        int to = next[0];
        int w = next[1];
        if(visited[to]==1)continue;
        if(dist[to]>dist[cur]+ w){
          dist[to] = dist[cur] + w;
          q.add(new Node(dist[to], to));
        }
      }
    }
    return dist;
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
