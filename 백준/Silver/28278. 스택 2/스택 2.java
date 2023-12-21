import java.io.*;
import java.util.*;

public class Main {


    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            switch (a){
                case 1 :
                    stack.add(Integer.parseInt(st.nextToken()));
                    break;
                case 2 :
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case 3 :
                    sb.append(stack.size()).append("\n");
                    break;
                case 4 :
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                default:
                    sb.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}