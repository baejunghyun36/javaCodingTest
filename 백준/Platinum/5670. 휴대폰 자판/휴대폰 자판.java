import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static ArrayList<String> list;

    static class TrieNode {
        Map<Character, TrieNode> child = new HashMap<>();
        boolean isLast;
    }

    static class Trie {

        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(char [] alpa) {

            TrieNode cur = root;
            for (int i = 0; i < alpa.length; i++) {
                cur.child.putIfAbsent(alpa[i], new TrieNode());
                cur = cur.child.get(alpa[i]);
            }
            cur.isLast = true;
        }

        public int contains(char[] alpa) {

            TrieNode cur = root;
            int cnt = 1;
            cur = cur.child.get(alpa[0]);
            for (int i = 1; i < alpa.length; i++) {
                if (cur.child.size() >= 2) cnt++;
                if(cur.child.size() == 1 && cur.isLast) cnt++;
                cur = cur.child.get(alpa[i]);
            }
            return cnt;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null) {
            n = Integer.parseInt(input);
            list = new ArrayList<>();
            Trie trie = new Trie();

            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                trie.insert(word.toCharArray());
                list.add(word);
            }

            double sum = 0;
            for (int i = 0; i < n; i++) {
                String word = list.get(i);
                sum += trie.contains(word.toCharArray());
            }
            double avg = sum / n;
            sb.append(String.format("%.2f", avg)).append("\n");
//            System.out.println(String.format("%.2f", avg));
//            System.out.println();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}