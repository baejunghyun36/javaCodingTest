import java.io.*;
import java.util.*;

public class Main {

    static int testCase;
    static char [] name;
    static ArrayList<Integer> indexList;
    static int answer, n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());

        while (testCase-- > 0) {
            name = br.readLine().toCharArray();
            indexList = new ArrayList<>();
            answer = 0;
            indexList.add(0);
            n = name.length;
            for (int i = 0; i < n; i++) {
                if (name[i] != 'A') {
                    answer += 'N' < name[i] ? 'Z' - name[i] + 1 : name[i] - 'A';
                    if(i!=0) indexList.add(i);
                }
            }
            solution();
            sb.append(answer + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void solution(){

        int minMove = indexList.get(indexList.size() - 1);
        for (int i = 0; i < indexList.size() - 1; i++) {
            minMove = Math.min(minMove, indexList.get(i) * 2 + n - indexList.get(i + 1));
        }
        for (int i = indexList.size()-1; i > 0; i--) {
            minMove = Math.min(minMove, (n-indexList.get(i)) * 2 + indexList.get(i -1));
        }
        answer += minMove;
    }
}