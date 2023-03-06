
import java.util.*;
import java.io.*;
public class Main_10775 {
  static int g, p;
  static int [] parent;
  static int answer;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    g = Integer.parseInt(br.readLine());
    p = Integer.parseInt(br.readLine());
    parent = new int[g + 1];

    init();

    for(int i=0; i<p; i++){
      int x = Integer.parseInt(br.readLine());
      if(!union(x))break;
      answer++;
    }

    sb.append(answer);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static void init(){
    for(int i=0; i<=g; i++) parent[i] = i;
  }

  static int find(int a){
    if(parent[a] == a) return a;
    return parent[a] = find(parent[a]);
  }

  static boolean union(int x){
    if(find(x)==0)return false;
    int a = find(x)-1;
    int b = find(x);
    parent[find(b)]= find(a);
    return true;
  }
}
