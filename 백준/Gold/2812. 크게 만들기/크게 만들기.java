import java.io.*;
import java.util.*;

public class Main {

    static int l, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        Stack <Integer>stack = new Stack();
        char [] arr = br.readLine().toCharArray();
        for (int i = 0; i < l; i++) {
            int number = arr[i] - '0';
            while(!stack.isEmpty()&&stack.peek()<number&&n!=0){
                n--;
                stack.pop();
            }
            if(stack.isEmpty()||stack.peek()>=number||n==0) stack.add(number);
        }
        while(n-->0)stack.pop();
        while(!stack.isEmpty()) sb.append(stack.pop());
        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
        br.close();
    }
}