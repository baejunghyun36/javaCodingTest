import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725 {

;
  static int vertex;
  static ArrayList<Integer> [] list;
  static int [] visited;
  static int [] parent;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    vertex = Integer.parseInt(st.nextToken());
    list = new ArrayList[vertex+1];
    visited = new int[vertex+1];
    parent = new int[vertex+1];
    for(int i=0; i<=vertex; i++) list[i] = new ArrayList<>();
    for(int i = 1; i<vertex; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list[a].add(b);
      list[b].add(a);
    }
    dfs(0, 1);
    for(int i=2; i<=vertex; i++){
      sb.append(parent[i]).append("\n");
    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static void dfs(int par, int cur){

    parent[cur] = par;
    for(int i=0; i<list[cur].size(); i++){
      int next = list[cur].get(i);
      if(visited[next]==1)continue;
      visited[next] = 1;
      dfs(cur, next);
    }
  }


}
