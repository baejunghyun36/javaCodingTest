import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_16954 {

  static int[] dy = {0, 0, 0, 1, -1, 1, 1, -1, -1};
  static int[] dx = {0, 1, -1, 0, 0, 1, -1, 1, -1};
  static int [][] map;
  static Queue<int[]> q;
  static LinkedList<Wall> wallList;
  static int desY = 0;
  static int desX = 7;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    map = new int[8][8];
    wallList = new LinkedList<>();
    q = new LinkedList<>();
    for (int i = 0; i < 8; i++) {
      String s = br.readLine();
      for(int j=0; j<8; j++){
        if(s.charAt(j)=='.'){
          map[i][j] = 0;
        }
        else {
          map[i][j] = 1;
          wallList.add(new Wall(i, j));
        }
      }
    }
    q.add(new int[]{7, 0});
    sb.append(bfs());
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  static int bfs(){

    int [][] temp = map;
    while (!q.isEmpty()) {
      int size = q.size();
      while(size-->0){
        int []yx = q.poll();
        if(temp[yx[0]][yx[1]]==1)continue;
        for(int j=0; j<=8; j++){
          int ny = yx[0] + dy[j];
          int nx = yx[1] + dx[j];
          if(ny<0||ny>=8||nx<0||nx>=8)continue;
          if(temp[ny][nx] == 1)continue;
          if(ny==desY&&nx==desX) {
            return 1;
          }
          q.add(new int[]{ny, nx});
        }
      }
      temp = new int[8][8];
      for(int i = 0; i<wallList.size(); i++){
        Wall wall = wallList.get(i);
        wall.y++;
        if(wall.y >= 8){
          wallList.remove(i);
          i--;
        }
        else{
          temp[wall.y][wall.x] = 1;
        }
      }
    }
    return 0;
  }

  static class Wall{

    int y;
    int x;

    public Wall(int y, int x) {
      this.y = y;
      this.x = x;
    }

  }
}
