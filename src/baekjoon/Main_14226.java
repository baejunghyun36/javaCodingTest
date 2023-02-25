import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main_14226 {

  static int [][] visitedEmoticon;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    visitedEmoticon = new int[1001][1001];
    visitedEmoticon[1][0] = 1;
    int des = Integer.parseInt(br.readLine());
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(1, 0));
    int cnt = 0;
    out:while (!q.isEmpty()) {
      int size = q.size();
      while(size-->0){
        if(q.peek().windowCnt == des){
          break out;
        }
        Node node = q.poll();
        int w = node.windowCnt;
        int c = node.clipBoardCnt;

        if(visitedEmoticon[w][w]==0){
          q.add(new Node(w, w));
          visitedEmoticon[w][w] = 1;
        }
        if(w+c<=1000&&visitedEmoticon[w+c][c]==0){
          q.add(new Node(w + c, c));
          visitedEmoticon[w+c][c] = 1;
        }
        if(w-1>=2&&visitedEmoticon[w-1][c]==0){
          q.add(new Node(w - 1, c));
          visitedEmoticon[w-1][c] = 1;
        }
      }
      cnt++;
    }
    sb.append(cnt);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  static class Node{

    int windowCnt;
    int clipBoardCnt;

    public Node(int windowCnt, int clipBoardCnt) {
      this.windowCnt = windowCnt;
      this.clipBoardCnt = clipBoardCnt;
    }
  }


}
