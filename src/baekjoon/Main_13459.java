//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.util.Arrays;
//import java.util.PriorityQueue;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Main_13459 {
//
//  static int m, n;
//  static char [][] map;
//
//  static int[] dx = {0,0,-1,1};
//  static int[] dy = {-1, 1, 0, 0};
//  static int [] end;
//  static int answer;
//  static PriorityQueue <Ball> q;
//  public static void main(String[] args) throws IOException {
//
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    StringBuilder sb = new StringBuilder();
//    StringTokenizer st = new StringTokenizer(br.readLine());
//    m = Integer.parseInt(st.nextToken());
//    n = Integer.parseInt(st.nextToken());
//    map = new char[m][n];
//    q = new PriorityQueue<>();
//    int [] blue = null;
//    int [] red = null;
//    for(int i=0; i<m; i++){
//      map[i] = br.readLine().toCharArray();
//      for(int j=0; j<n; j++){
//        if (map[i][j] == 'B') blue = new int[]{i, j};
//        else if (map[i][j] == 'R') red = new int[]{i, j};
//        else if(map[i][j]=='O')end = new int[]{i,j};
//      }
//    }
//    q.add(new Ball(blue[0], blue[1], red[0], red[1], 0));
//    bfs();
//    sb.append(answer);
//    bw.write(sb.toString());
//    bw.flush();
//    bw.close();
//    br.close();
//  }
//  static void bfs(){
//
//    int [][]  visited = new int[m][n];
//
//    while(!q.isEmpty()){
//      int n = q.size();
//      while(n-->0){
//        Ball ball = q.poll();
//        for(int i=0; i<4; i++) {
//
//          int nextBy = ball.by;
//          int nextBx = ball.bx;
//          int nextRy = ball.ry;
//          int nextRx = ball.rx;
//
//          boolean flag = false;
//
//          while (map[nextBy + dy[i]][nextBx + dx[i]] == '.') {
//            nextBy += dy[i];
//            nextBx += dx[i];
//            if (nextBy == end[1] && nextBx == end[0]) {
//              flag = true;
//              break;
//            }
//          }
//          if (flag == true)continue;
//          flag = false;
//          while (map[nextRy + dy[i]][ball.rx] == '.') {
//            nextRy += dy[i];
//            if (ball.rx == end[1] && ball.ry == end[0]) {
//              flag = true;
//              break;
//            }
//          }
//          if (flag == true) {
//            answer = 1;
//            continue;
//          }
//          if(nextRy==nextBy)
//        }
//
//      }
//
//
//
//    }
//
//
//  }
//  static class Ball {
//    int by;
//    int bx;
//    int ry;
//    int rx;
//    int cnt;
//
//    public Ball(int by, int bx, int ry, int rx, int cnt) {
//      this.by = by;
//      this.bx = bx;
//      this.ry = ry;
//      this.rx = rx;
//      this.cnt = cnt;
//    }
//  }
//
//
//  /*
//
//  ######
//  #RB..#
//  ###.##
//  ###.O#
//  ######
//
//  ######
//  #..o.#
//  #....#
//  #.R.B#
//  ######
//
//
//
//  상 하 좌 우 할 때 누가 먼저인지 체크
//
//  */
//
//
//
//}
