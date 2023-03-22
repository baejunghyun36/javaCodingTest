import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1863 {

  static int n;
  static Stack<Integer> stack;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    stack = new Stack<>();
    int cnt = 0;
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if(b==0){stack = new Stack<>(); continue;}
      while(!stack.isEmpty()&&stack.peek()>b) stack.pop();
      if(stack.isEmpty()||!stack.isEmpty()&&stack.peek()<b){
        cnt++;
        stack.add(b);
      }
    }
    sb.append(cnt);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }
}
