import java.io.*;
import java.util.*;

public class Main {

    static int testCase;
    static char [][] map;
    static ArrayList<Pin> list;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int m = 5;
    static int n = 9;
    static int minMove, minCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());
        map = new char[5][9];
        while (testCase-- > 0) {
            int number = 0;

            list = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < 9; j++) {
                    if(map[i][j]=='o'){
                        map[i][j] = (char)('0' + number++);
                        list.add(new Pin(i, j, true));
                    }
                }
            }

            minCount = list.size();
            minMove = 987654321;
            backTracking(minCount, 0, 0);
            sb.append(minCount).append(" ").append(minMove).append("\n");
            br.readLine();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void backTracking(int pinCount, int moveCount, int level){
//        System.out.println(pinCount + " " + moveCount +" " + level);
        if(minCount>pinCount){
            minCount = pinCount;
            minMove = moveCount;
        } else if (minCount == pinCount) {
            minMove = Math.min(minMove, moveCount);
        }
//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
//        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            Pin p = list.get(i);
            if(p.isExist==false)continue;
            int y = p.y;
            int x = p.x;

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(ny<0||ny>=m||nx<0||nx>=n)continue;

                if (map[ny][nx] >= '0' && map[ny][nx] <= '7') {
                    int mx = nx + dx[j];
                    int my = ny + dy[j];

                    if(my<0||my>=m||mx<0||mx>=n)continue;

                    if(map[my][mx]!='.') continue;
                    char prev = map[ny][nx];
                    map[y][x] = '.';
                    map[my][mx] = (char) ('0' + i);
                    Pin remove = list.get(map[ny][nx]-'0');
                    map[ny][nx] = '.';
                    p.y = my;
                    p.x = mx;

                    remove.isExist = false;
                    backTracking(pinCount-1, moveCount+1, level+1);
                    map[my][mx] = '.';
                    map[y][x] = (char) ('0' + i);
                    p.y = y;
                    p.x = x;
                    map[ny][nx] = prev;
                    remove.isExist = true;
                }
            }
        }
    }

    static class Pin {

        int y;
        int x;
        boolean isExist;

        public Pin(int y, int x, boolean isExist) {
            this.y = y;
            this.x = x;
            this.isExist = isExist;
        }
    }
}