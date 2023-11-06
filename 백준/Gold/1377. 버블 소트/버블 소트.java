import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(i, Integer.parseInt(br.readLine())));
        }
        Collections.sort(list);
        int maxNumber = 0;
        for (int i = 0; i < list.size(); i++) {
            maxNumber = Math.max(maxNumber, list.get(i).index - i);
        }
        sb.append(maxNumber+1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node>{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int compareTo(Node node) {
            return this.value - node.value;
        }


    }

}