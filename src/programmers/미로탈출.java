import java.util.*;

class 미로탈출 {
  static int [] dx = {0,0,1,-1};
  static int [] dy = {1,-1,0,0};
  static int [][] visited;
  static String[] map;
  static Queue<int[]> q;

  public int solution(String[] maps) {
    int answer = 0;
    map = maps;
    q = new LinkedList<>();
    visited = new int [maps.length][maps[0].length()];
    for(int i=0; i<maps.length; i++){
      for(int j=0; j<maps[i].length(); j++){
        if(maps[i].charAt(j)=='S'){
          q.add(new int[]{i,j, 0});
          visited[i][j] =1;
        }
      }
    }
    return bfs();
  }
  static int bfs(){
    boolean L = false;
    while(!q.isEmpty()){
      int [] yx = q.poll();
      for(int i=0; i<4; i++){
        int ny = dy[i]+yx[0];
        int nx = dx[i]+yx[1];
        if(ny<0||ny>=map.length||nx<0||nx>=map[0].length())continue;
        if(map[ny].charAt(nx)=='X')continue;
        if(visited[ny][nx]==1)continue;
        if(L==true&&map[ny].charAt(nx)=='E')return yx[2]+1;
        if(L==false&&map[ny].charAt(nx)=='L'){
          L=true;
          for(int k=0; k<map.length; k++) Arrays.fill(visited[k], 0);
          q = new LinkedList<>();
          i=4;
        }
        visited[ny][nx] = 1;
        q.add(new int[]{ny,nx, yx[2]+1});
      }
    }
    return -1;
  }
}