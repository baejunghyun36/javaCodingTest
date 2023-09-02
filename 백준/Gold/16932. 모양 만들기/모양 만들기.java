import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer> sizeOfAreaNumber;
    static ArrayList<Integer> areaNumber;
    static int [][] map, visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static Queue <int [] > q;
    static int m, n;
    static int seq = 2;
    static Set<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        init();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        calculateArea();
        sb.append(output());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static int output(){
        int maxNumber = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==0){
                    set = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if(ny<0||ny>=m||nx<0||nx>=n)continue;
                        set.add(map[ny][nx]);
                    }
                    int sum = 0;
                    for(int x : set) sum+= sizeOfAreaNumber.get(x);
                    maxNumber = Math.max(maxNumber, sum + 1);
                }
            }
        }
        return maxNumber;
    }

    static void calculateArea(){

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 ) {
                    q.add(new int[] {i, j});
                    map[i][j] = seq;
                    sizeOfAreaNumber.add(bfs());
                    seq++;
                }
            }
        }
    }

    static int bfs(){

        int size = 1;
        while(!q.isEmpty()){
            int [] yx = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + yx[1];
                int ny = dy[i] + yx[0];
                if(ny<0||ny>=m||nx<0||nx>=n)continue;
                if(map[ny][nx]==seq||map[ny][nx]==0)continue;
                q.add(new int[]{ny, nx});
                map[ny][nx] = seq;
                size++;
            }
        }
        return size;
    }

    static void init(){

        map = new int[m][n];
        visited = new int[m][n];
        q = new LinkedList<>();
        areaNumber = new ArrayList<>();
        sizeOfAreaNumber = new ArrayList<>();
        sizeOfAreaNumber.add(0);
        sizeOfAreaNumber.add(0);
    }
}