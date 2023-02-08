//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.PriorityQueue;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class Main_13415 {
//
//  static int N;
//  static int [] number;
//  public static void main(String[] args) throws IOException {
//
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    StringBuilder sb = new StringBuilder();
//    StringTokenizer st = new StringTokenizer(br.readLine());
//
//    N = Integer.parseInt(st.nextToken());
//    number = new int[N+1];
//    st = new StringTokenizer(br.readLine());
//    for(int i=1; i<=N; i++){
//      number[i] = Integer.parseInt(st.nextToken());
//    }
//
//    Stack<Integer> stack = new Stack<>();
//    PriorityQueue<Integer> q = new PriorityQueue<>();
//
//    int test = Integer.parseInt(br.readLine());
//    for(int i=0; i<test; i++){
//      st = new StringTokenizer(br.readLine());
//      int asc = Integer.parseInt(st.nextToken());
//      int desc = Integer.parseInt(st.nextToken());
//      for(int j=1; j<=asc; j++){
//        q.add(number[j]);
//      }
//      while(desc-->0){
//        stack.add(q.poll());
//      }
//      int idx = 1;
//      while(stack.size()>0){
//        number[idx++] = stack.pop();
//      }
//      while(q.size()>0){
//        number[idx++] = q.poll();
//      }
//    }
//    for(int i=1; i<=N; i++){
//      sb.append(number[i]).append(" ");
//    }
//
//    bw.write(sb.toString());
//    bw.flush();
//    bw.close();
//    br.close();
//  }
//}
