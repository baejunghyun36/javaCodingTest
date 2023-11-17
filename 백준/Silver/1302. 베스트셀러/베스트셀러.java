import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        while (n-->0) {
            String s = br.readLine();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (String key : map.keySet()) {
            pq.add(new Node(key, map.get(key)));
        }
        sb.append(pq.poll().key);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static class Node implements Comparable<Node>{

        String key;
        int cnt;

        public Node(String key, int cnt) {
            this.key = key;
            this.cnt = cnt;
        }

        public int compareTo(Node node) {
            if (node.cnt == this.cnt) {
                return this.key.compareTo(node.key);
            }
            return node.cnt - this.cnt;
        }
    }


}