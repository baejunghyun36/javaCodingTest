import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(" ", 0, 0, 0));
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(name, d, m, y));
        }
        Collections.sort(list);
        int start = 1;
        int end = n;
        sb.append(list.get(end).name).append("\n");
        sb.append(list.get(start).name);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node> {

        String name;
        int d;
        int m;
        int y;

        public Node(String name, int d, int m, int y) {

            this.name = name;
            this.d = d;
            this.m = m;
            this.y = y;
        }

        public int compareTo(Node node) {

            if (this.y == node.y) {
                if (this.m == node.m) {
                    return this.d- node.d;
                }
                return this.m - node.m;
            }
            return this.y - node.y;
        }
    }
}