import java.io.*;
import java.util.*;

public class Main {

    static int testCase;
    static int m, n;
    static char [][] map;
    static ArrayList<Node> []doorList;
    static int [][] visited;
    static int count;
    static int[] dx = {0, 0, -1, 1};
    static int answer;
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        testCase = Integer.parseInt(st.nextToken());

        while (testCase-- > 0) {

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            count = 1;
            answer = 0;
            doorList = new ArrayList[26];
            for (int i = 0; i < 26; i++) doorList[i] = new ArrayList<>();
            visited = new int[m][n];
            map = new char[m][n];

            for (int i = 0; i < m; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    char c = map[i][j];
                    if(c>='A'&&c<='Z') {
                        doorList[c - 'A'].add(new Node(i, j));
                    }
                }
            }

            String keyString = br.readLine();
            if(!keyString.equals("0")){
                for (int i = 0; i < keyString.length(); i++) {
                    updateMap(keyString.charAt(i)-97);
                }
            }

            while(rotate());
            sb.append(answer).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean rotate(){

        boolean flag = false;
        for(int i=0; i<m; i++){
            flag |= bfs(i, 0);
            flag |= bfs(i, n-1);
        }
        for (int j = 1; j < n-1; j++) {
            flag |= bfs(0, j);
            flag |= bfs(m - 1, j);
        }
        return flag;
    }


    static boolean bfs(int yy, int xx){
        if(map[yy][xx]=='*')return false;
        if(map[yy][xx]>='A'&&map[yy][xx]<='Z')return false;
        boolean flag = false;
        if(visited[yy][xx]==0)flag=true;
        if(map[yy][xx]=='$'){
            answer++;
            map[yy][xx] = '.';
        }
        if(map[yy][xx]>='a'&&map[yy][xx]<='z'){
            updateMap(map[yy][xx]-97);
            map[yy][xx] = '.';
        }
        
        count++;
        visited[yy][xx] = count;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{yy, xx});
        while (!q.isEmpty()) {
            int [] yx = q.poll();
            int y = yx[0];
            int x = yx[1];
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (ny < 0 || ny >= m || nx < 0 || nx >= n) continue;
                if(visited[ny][nx]==count||map[ny][nx]=='*')continue;
                if(map[ny][nx]>='A'&&map[ny][nx]<='Z')continue;
                if(map[ny][nx]>='a'&&map[ny][nx]<='z'){
                    updateMap(map[ny][nx]-97);
                    map[ny][nx] = '.';
                }
                if(map[ny][nx]=='$'){
                    answer++;
                    map[ny][nx] = '.';
                }
                if(visited[ny][nx]==0) flag = true;
                visited[ny][nx] = count;
                q.add(new int[]{ny, nx});
            }
        }
        return flag;
    }

    static void updateMap(int c){

        for (int j = 0; j < doorList[c].size(); j++) {
            int y = doorList[c].get(j).y;
            int x = doorList[c].get(j).x;
            map[y][x] = '.';
        }
    }

    static class Node {

        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}