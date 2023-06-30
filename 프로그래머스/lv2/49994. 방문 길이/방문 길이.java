class Solution {
    
    static int [] dx = {0, 0, -1, 1}; 
    static int [] dy = {-1, 1, 0, 0}; 
    static int [][][] visited; 
    static int [][] map; 
    static int n = 10; 
    static String dir = "UDLR"; 
    public int solution(String dirs) {
        int answer = 0;
        visited = new int[4][11][11]; 
        map = new int [11][11]; 
        int y = 5; 
        int x = 5; 
        for(int i =0; i<dirs.length(); i++){
            char c = dirs.charAt(i); 
            int index = dir.indexOf(c+"");
            int ny = dy[index] + y; 
            int nx = dx[index] + x; 
         
            if(ny<0||ny>n||nx<0||nx>n)continue; 
            if(visited[index][ny][nx]==1){
                x = nx; 
                y = ny; 
                continue;
            }             
            if(index==0) visited[1][y][x] = visited[0][ny][nx] = 1; 
            if(index==1) visited[0][y][x] = visited[1][ny][nx] = 1; 
            if(index==2) visited[3][y][x] = visited[2][ny][nx] = 1; 
            if(index==3) visited[2][y][x] = visited[3][ny][nx] = 1; 

            answer++; 
            x = nx; 
            y = ny; 
        }
        return answer;
    }
}