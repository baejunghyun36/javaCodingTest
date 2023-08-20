import java.io.*;
import java.util.*;

public class Main {

    static char [][] map;
    static int m, n;
    static char [][] aroundMap;
    static int [] start, end;
    static int [][] visited;
    static PriorityQueue<Node> q;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        start = new int[2];
        visited = new int [m][n];
        q = new PriorityQueue<>();
        end = new int[2];
        map = new char[m][n];
        aroundMap = new char[m][n];


        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {

                if(map[i][j]=='S'){
                    start[0] = i;
                    start[1] = j;
                }
                else if(map[i][j]=='F'){
                    end[0] = i;
                    end[1] = j;
                }
                else if(map[i][j] == 'g'){
                    for (int d = 0; d < 4; d++) {
                        int nx = dx[d] + j;
                        int ny = dy[d] + i;
                        if(ny<0||ny>=m||nx<0||nx>=n)continue;
                        aroundMap[ny][nx] = 'a';
                    }
                }
            }
        }
        aroundMap[start[0]][start[1]] = '.';
        aroundMap[end[0]][end[1]] = '.';
        visited[start[0]][start[1]] = 1;
        q.add(new Node(0, 0, start[0], start[1]));
        Node endNode = dijk();
        sb.append(endNode.garbage + " " +endNode.around);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static Node dijk(){
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.y==end[0]&&cur.x == end[1]) return cur;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if(ny<0||ny>=m||nx<0||nx>=n||visited[ny][nx]==1)continue;
                Node next = new Node(cur.garbage, cur.around, ny, nx);
                if(map[ny][nx]=='g') next.garbage++;
                else if(aroundMap[ny][nx]=='a')next.around++;
                q.add(next);
                visited[ny][nx] = 1;
            }
        }
        return new Node(0,0,0,0);
    }

    static class Node implements Comparable<Node> {

        int garbage;
        int around;
        int y;
        int x;

        public Node( int garbage, int around, int y, int x) {
            this.garbage = garbage;
            this.around = around;
            this.y = y;
            this.x = x;
        }

        public int compareTo(Node node) {
            if(this.garbage == node.garbage) return this.around - node.around;
            return this.garbage - node.garbage;
        }
    }
}