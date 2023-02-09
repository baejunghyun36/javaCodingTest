import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import org.w3c.dom.Node;

public class Main_1766 {

  static int N;
  static int testCase;
  static ArrayList <Node> list;
  static int index;
  static int [] order;
  static int [] number;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    testCase = Integer.parseInt(st.nextToken());
    list = new ArrayList<>();
    order = new int[N];
    number = new int[N+1];
    for(int i=0; i<testCase; i++){
      st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());
      Node node = new Node(first, second);
      list.add(node);
    }
    Collections.sort(list);
    sb.append(list.get(0).first).append(" ");
    number[list.get(0).first]++;
    int prev = list.get(0).second;
    for(int i=1; i<list.size(); i++){
      if(number[list.get(i).first]==1)continue;
      if(prev!=list.get(i).second){
        sb.append(prev).append(" ");
        number[prev]++;
        prev = list.get(i).second;
      }
      sb.append(list.get(i).first).append(" ");
      number[list.get(i).first]++;
    }
    sb.append(prev).append(" ");
    number[prev]++;

    for(int i=1; i<=N; i++){
      if(number[i]==0)sb.append(i).append(" ");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  static class Node implements Comparable <Node> {

    int first;
    int second;

    public Node(int first, int second){
      this.first = first;
      this.second = second;
    }

    public int compareTo(Node node){
      if(this.second == node.second){
        return this.first - node.first;
      }
      return this.second - node.second;
    }

  }
}
