import java.io.*;
import java.util.*;

public class Main {

    static int testCase;
    static Queue<Node> q;
    static int[] month = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static int [][][] visited;
    static int [] temp;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());
        visited = new int[102][13][32];
        temp = new int[3];

        bfs();

        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if(visited[y-1900][m][d]==1) sb.append("YES\n");
            else sb.append("NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){

        q = new LinkedList<>();
        q.add(new Node(101, 11, 4, true));
        visited[101][11][4] = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (method1(node.y, node.m, node.d)) {
                if (node.isSangbum&&visited[temp[0]][temp[1]][temp[2]]==0){
                    visited[temp[0]][temp[1]][temp[2]] = 1;
                    q.add(new Node(temp[0], temp[1], temp[2], node.isSangbum ^ true));
                }
                else if(!node.isSangbum){
                    visited[temp[0]][temp[1]][temp[2]] = 2;
                    q.add(new Node(temp[0], temp[1], temp[2], node.isSangbum ^ true));
                }
            }
            if (method2(node.y, node.m, node.d)) {
                if(visited[temp[0]][temp[1]][temp[2]]==0) {
                    if (node.isSangbum&&visited[temp[0]][temp[1]][temp[2]]==0){
                        visited[temp[0]][temp[1]][temp[2]] = 1;
                        q.add(new Node(temp[0], temp[1], temp[2], node.isSangbum ^ true));
                    }
                    else if(!node.isSangbum){
                        visited[temp[0]][temp[1]][temp[2]] = 2;
                        q.add(new Node(temp[0], temp[1], temp[2], node.isSangbum ^ true));
                    }
                }
            }
        }
    }

    //day--
    static boolean method1(int y, int m, int d){

        if(d-1>=1) {
            temp[0] = y;
            temp[1] = m;
            temp[2] = d-1;
        }
        else {
            if(m-1>=1){
                temp[0] = y;
                temp[1] = m-1;
                if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0&&temp[1]==2) temp[2] = 29;
                else temp[2] = month[temp[1]];
            }
            else{
                temp[0] = y-1;
                temp[1] = 12;
                temp[2] = 31;
            }
        }
        if(temp[0]<0)return false;
        return true;
    }

    // 10 30 시작
    // 10 31 -> 11 1 -> 11 2 -> 11 3 -> 11 4

    //month--
    static boolean method2(int y, int m, int d) {
        if(m-1>=1){
            if(m-1==2&&(y % 4 == 0 && y % 100 != 0) || y % 400 == 0&&d>29) return false;
            if(d>month[m-1])return false;
            temp[0] = y;
            temp[1] = m-1;
            temp[2] = d;
        }
        else{
            temp[0] = --y;
            temp[1] = 12;
            temp[2] = d;
        }
        if(temp[0]<0)return false;
        return true;
    }



    static class Node {

        int y;
        int m;
        int d;
        boolean isSangbum;

        public Node(int y, int m, int d, boolean isSangbum) {
            this.y = y;
            this.m = m;
            this.d = d;
            this.isSangbum = isSangbum;
        }
    }

}