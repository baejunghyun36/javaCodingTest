import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_16964 {

  static int n;
  static Set<Integer> []list;

  static int [] order;
  static int [] visited;
  static int index;
  static int answer;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());

    list = new HashSet[n+1];
    for(int i = 1; i<=n; i++){
      list[i] = new HashSet<>();
    }
    order = new int[n];
    visited = new int[n+1];
    for(int i=0; i<n-1; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list[a].add(b);
      list[b].add(a);
    }

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<n; i++){
      order[i] = Integer.parseInt(st.nextToken());
    }

    dfs(1);

    sb.append(answer);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static void dfs(int cur){

    if(index==n-1){
      answer= 1;
      return;
    }
    if(visited[cur]==1)return;
    visited[cur] = 1;
    for(int i = 0; i<list[cur].size(); i++ ){
      if(answer==0&&list[cur].contains(order[index+1])){
        dfs(order[++index]);
      }
    }
  }
}

