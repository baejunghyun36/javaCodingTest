import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static int [][] visited;
    static char [][] map;
    static Queue<Node> q;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static Queue<Node> iceQueue;
    static int [][] secondMap;
    static int [] parent;
    static int number = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        iceQueue = new LinkedList<>();
        secondMap = new int[m][n];
        map = new char[m][n];
        visited = new int[m][n];
        q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if(map[i][j]=='L') {
                    visited[i][j] = number;
                    q.add(new Node(i, j, number++));
                }
            }
        }
        initBfs();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++){
                if(map[i][j]=='.'&&visited[i][j]==0){
                    visited[i][j] = number;
                    q.add(new Node(i, j, number++));
                    initBfs();
                }
            }
        }

        initParent();
        bfs();

    }

    static void initParent() {
        parent = new int[number];
        for (int i = 1; i < number; i++) {
            parent[i] = i;
        }
    }

    static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static void bfs(){

        int second = 1;
        while (!iceQueue.isEmpty()) {
            int size = iceQueue.size();
            while (size--> 0) {
                Node node = iceQueue.poll();
                int a = find(node.number);
                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if(ny<0||ny>=m||nx<0||nx>=n)continue;

                    if(visited[ny][nx]!=0) {
                        int b = find(visited[ny][nx]);
                        if(a+b==3){
                            if(second>secondMap[ny][nx]) System.out.println(second-1);
                            else System.out.println(second);
                            System.exit(0);
                        }
                        if(a<=b)parent[b] = a;
                        else parent[a] = b;
                    }
                    else{
                        secondMap[ny][nx] = second;
                        iceQueue.add(new Node(ny, nx, a));
                        visited[ny][nx] = a;
                    }
                }
            }
            second++;
        }
    }

    static void initBfs(){

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];
                if(ny<0||ny>=m||nx<0||nx>=n)continue;
                if(visited[ny][nx]!=0&&visited[ny][nx]+node.number==3){
                    System.out.println(0);
                    System.exit(0);
                }
                if(visited[ny][nx]!=0)continue;
                if(map[ny][nx]=='X') iceQueue.add(new Node(node.y, node.x, node.number));
                else {
                    q.add(new Node(ny, nx, node.number));
                    visited[ny][nx] = node.number;
                }
            }
        }
    }

    static class Node {

        int y;
        int x;
        int number;

        public Node(int y, int x, int number) {
            this.y = y;
            this.x = x;
            this.number = number;
        }
    }
}