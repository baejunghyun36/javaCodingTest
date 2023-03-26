import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_16396 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());

    List<Node> list = new ArrayList<>();
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      list.add(new Node(x, y));
    }
    Collections.sort(list);
    Stack<int[]> stack = new Stack<>();
    stack.add(new int[]{list.get(0).x, list.get(0).y});

    for(int i = 1; i<n; i++){
      if (stack.peek()[1] >= list.get(i).x){
        stack.peek()[1] = Math.max(stack.peek()[1], list.get(i).y);
      }

      else {
        stack.add(new int[]{list.get(i).x,list.get(i).y});
      }

    }
    int answer = 0;
    while (!stack.isEmpty()) {
      answer += (stack.peek()[1] - stack.peek()[0]);
      stack.pop();

    }

    sb.append(answer);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
  static class Node implements Comparable<Node>{
    int x;
    int y;

    public Node(int x, int y) {

      this.x = x;
      this.y = y;
    }

    public int compareTo (Node node){
      if(this.x == node.x)return this.y - node.y;
      return this.x - node.x;
    }
  }

}
