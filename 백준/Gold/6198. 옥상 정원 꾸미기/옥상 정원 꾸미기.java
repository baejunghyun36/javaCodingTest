import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int [] arr;
    static int n;
    static long answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

        Stack<Node> stack = new Stack<>();

        for(int i=n-1; i>=0; i--){
            int x = arr[i];
            int cnt = 0;
            while (!stack.isEmpty() && x > stack.peek().height) {
                cnt+=stack.pop().cnt+1;
            }
            stack.add(new Node(x, cnt));
            answer+=cnt;
        }

        sb.append(answer);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        int height;
        int cnt;

        public Node(int height, int cnt){
            this.height = height;
            this.cnt = cnt;
        }
    }

}