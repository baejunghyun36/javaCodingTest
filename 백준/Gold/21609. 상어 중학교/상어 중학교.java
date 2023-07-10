import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int [][] map;
    static int [][] temp;
    static boolean flag;
    static Queue<int []> q;
    static Queue <BlockGroup> blockGroupList;
    static Queue <int []> removeQueue;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int [][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map =new int[n][n];
        temp = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        while(true){

            flag = false;
            blockGroupList = new PriorityQueue<>();
            q = new LinkedList<>();

            //블록 찾기
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                   if(map[i][j]>0){
                       visited = new int[n][n];
                       visited[i][j] = 1;
                       bfs(map[i][j], i, j, 0);
                   }
                }
            }

            if(flag==false)break;

            temp = new int[n][n];
            visited = new int[n][n];

            removeQueue = new LinkedList<>();
            BlockGroup group = blockGroupList.poll();
            removeQueue.add(new int[]{group.standardY, group.standardX});
            visited[group.standardY][group.standardX] = 1;

            bfs(map[group.standardY][group.standardX], group.standardY, group.standardX, 1);
            answer += removeBlock();
            gravity();
            rotate();
            gravity();
        }

        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int color, int y, int x, int check){
        q.add(new int[]{y, x});
        BlockGroup group = new BlockGroup(1, 0, y, x);
        while (!q.isEmpty()) {
            int [] yx = q.poll();
            for(int i=0; i<4; i++){
                int nx = dx[i] + yx[1];
                int ny = dy[i] + yx[0];
                if(ny<0||ny>=n||nx<0||nx>=n)continue;
                if(visited[ny][nx]==1||map[ny][nx]<0||(map[ny][nx]>0&&map[ny][nx]!=color))continue;
                if(map[ny][nx]==0)group.rainbowCnt++;
                group.size++;
                visited[ny][nx] = 1;
                if(map[ny][nx]!=0){
                    if(group.standardY> ny){
                        group.standardY = ny;
                        group.standardX = nx;
                    }
                    else if(group.standardY==ny&&group.standardX>nx){
                        group.standardX = nx;
                    }
                }
                if(check==1) removeQueue.add(new int[]{ny, nx});
                q.add(new int[]{ny, nx});
            }
        }
        if (group.size >= 2) {
            flag = true;
            blockGroupList.add(group);
        }
    }


    // 2. 모든 블럭 제거
    static int removeBlock(){
        int score = removeQueue.size();
        while(!removeQueue.isEmpty()){
            int [] yx = removeQueue.poll();
            map[yx[0]][yx[1]] = -2;
        }
        return (int)Math.pow(score, 2);
    }


    //3. 중력 == 5. 중력
    static void gravity(){
        //열
        for(int j=0; j<n; j++){
            for (int i = n - 1; i >= 0; i--) {
                if(map[i][j]==-2||map[i][j]==-1)continue;
                int k = i+1;
                while(k<n){
                    if(map[k][j]!=-2) break;
                    k++;
                }
                map[k-1][j] = map[i][j];
                if(k-1!=i)map[i][j] = -2;
            }
        }
    }

    //4. 회전 (반시계)
    static void rotate(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                temp[i][j] = map[j][n-i-1];
            }
        }
        map = temp;
    }

    static class BlockGroup implements Comparable<BlockGroup> {

        int size;
        int rainbowCnt;
        int standardY;
        int standardX;

        public BlockGroup(int size, int rainbowCnt, int standardY, int standardX) {
            this.size = size;
            this.rainbowCnt = rainbowCnt;
            this.standardY = standardY;
            this.standardX = standardX;
        }

        public int compareTo(BlockGroup blockGroup) {

            if(blockGroup.size==this.size){
                if (blockGroup.rainbowCnt == this.rainbowCnt) {
                    if (blockGroup.standardY == this.standardY) {
                        return blockGroup.standardX - this.standardX;
                    }
                    return blockGroup.standardY - this.standardY;
                }
                return blockGroup.rainbowCnt - this.rainbowCnt;
            }
            return blockGroup.size - this.size;
        }
    }
}