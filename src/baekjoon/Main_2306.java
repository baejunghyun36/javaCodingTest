import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_2306 {

  static int minus, length;
  static char[] arr;
  static Stack<Character> stack;
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    arr = br.readLine().toCharArray();
    length = arr.length;
    stack = new Stack<>();
    int answer = 0;
    for(int i=0; i<length; i++){
      char c = arr[i];

      if((c=='a'||c=='g')){
        stack.add(c);
        continue;
      }

      if(c=='t'&&!stack.isEmpty()){
        if(stack.peek()=='a'){
          stack.pop();
          answer+=2;
        }
      }
      if(c=='c'&&!stack.isEmpty()){
        if(stack.peek()=='g'){
          stack.pop();
          answer+=2;
        }
      }
    }

    sb.append(answer);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

}
