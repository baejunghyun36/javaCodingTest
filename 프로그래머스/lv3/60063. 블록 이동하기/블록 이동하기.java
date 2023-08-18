import java.util.*; 
class Solution {
    static int [] dx = {0,0,-1,1}; 
    static int [] dy = {1,-1,0,0};  
    static int [][][] visited; 
    static int n; 
    static int [][] map; 
    static Queue<Robot> q; 

    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        map = board; 
        visited = new int[2][n][n]; 
        visited[0][0][0] = 1; 
        q = new LinkedList<>(); 
        q.add(new Robot(0, 0, 0)); 
        answer = bfs(); 
        return answer-1;
    }
    
    static int bfs(){
        
        while(!q.isEmpty()){
            Robot r = q.poll(); 
            int dist = visited[r.isVertical][r.y][r.x]; 
            int rrx = 0; 
            int rry = 0; 
            if(r.isVertical==1){
                rrx = r.x; 
                rry = r.y+1; 
                if(rry==n-1&&rrx==n-1)return dist; 
            }
            else{
                rrx = r.x+1; 
                rry = r.y; 
                if(rry==n-1&&rrx==n-1)return dist; 
            }
            for(int i=0; i<4; i++){
                int lx = r.x + dx[i]; 
                int ly = r.y + dy[i]; 
                int rx = rrx + dx[i]; 
                int ry = rry + dy[i]; 
                
                if(lx<0||lx>=n||rx<0||rx>=n||ly<0||ly>=n||ry<0||ry>=n)continue; 
                if(map[ly][lx]==1||map[ry][rx]==1)continue; 
                if(visited[r.isVertical][ly][lx]==0){
                    visited[r.isVertical][ly][lx] = dist + 1; 
                    q.add(new Robot(ly, lx, r.isVertical));
                }
                int isV = r.isVertical^1; 
                if(i==0&&r.isVertical==0){
                    //아래일 때 
                    rangeCheck(isV, r.y, r.x, dist+1); 
                    rangeCheck(isV, r.y, r.x+1, dist+1); 
                }
                else if(i==1&&r.isVertical==0){
                    //위로일 때 
                    rangeCheck(isV, r.y-1, r.x, dist+1); 
                    rangeCheck(isV, r.y-1, r.x+1, dist+1); 
                }
                else if(i==2&&r.isVertical==1){
                    //왼쪽
                    rangeCheck(isV, r.y, r.x-1, dist+1); 
                    rangeCheck(isV, r.y+1, r.x-1, dist+1); 
                }
                else if(i==3&&r.isVertical==1){
                    //오른쪽
                    // System.out.println("hi"); 
                    rangeCheck(isV, r.y, r.x, dist+1); 
                    rangeCheck(isV, r.y+1, r.x, dist+1); 
                }
            }
            // for(int i=0; i<n; i++)System.out.println(Arrays.toString(visited[1][i])); 
            // System.out.println(); 
        }
        return -1; 

    }
    static void rangeCheck(int isVertical, int y, int x, int dist){

        if(visited[isVertical][y][x]==0){
            visited[isVertical][y][x] = dist; 
            q.add(new Robot(y, x, isVertical)); 
             // System.out.println(ly+ " " + lx + " "+ ry+ " "+ rx); 
        }
    }
    
    static class Robot {
        int y; 
        int x; 
        int isVertical; 
        
        public Robot(int y, int x, int isVertical){
            this.y = y; 
            this.x = x; 
            this.isVertical = isVertical; 
        }
    }
}