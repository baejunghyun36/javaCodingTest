import java.io.*;
import java.util.*;

public class Main {

    static int n, s;
    static Map <Integer, Integer> map;
    static int [] dp;
    static ArrayList<Picture> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a, Math.max(map.getOrDefault(a, 0), b));
        }
        for (int key : map.keySet()) {
            list.add(new Picture(key, map.get(key)));
        }
        Collections.sort(list, (o1, o2) -> o1.height - o2.height);
        dp = new int[list.size()];
        dp[0] = list.get(0).cost;
        for (int i = 1; i < list.size(); i++) {
            int index = binarySearch(i, list.get(i).height - s);
            if (index == -1) {
                dp[i] = Math.max(list.get(i).cost, dp[i-1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[index] + list.get(i).cost);
            }
        }
        sb.append(dp[list.size() - 1]);
//        System.out.println(Arrays.toString(dp));
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static int binarySearch(int index, int height) {

        int l = 0;
        int h = index-1;
        int saveIndex = -1;
        while (l <= h) {
            int mid = (l + h)/2;
            Picture p = list.get(mid);
            if (p.height <= height) {
                saveIndex = mid;
                l = mid + 1;
            } else {
                h = mid -1;
            }
        }
        return saveIndex;
    }


    static class Picture {
        int height;
        int cost;

        public Picture(int height, int cost) {
            this.height = height;
            this.cost = cost;
        }
    }
}